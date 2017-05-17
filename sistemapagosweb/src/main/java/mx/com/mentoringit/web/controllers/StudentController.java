package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.primefaces.context.RequestContext;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.StudentBean;
import mx.com.mentoringit.web.services.IStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbStudentController")
@SessionScoped
public class StudentController implements Serializable {
	private final static Logger log = Logger.getLogger(StudentController.class);
	
	@ManagedProperty(value = "#{studentService}")
	private IStudentService studentService;
	
	@ManagedProperty(value = "#{MbStudentList}")
	private StudentBean stb;

	public StudentController() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// obtiene todos los cursos
	public List<CourseDTO> courses() {
		try {
			return studentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			return null;
		}
	}

	// obtiene todos los alumnos
	public List<StudentDTO> students() {
		try {
			return studentService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			return null;
		}
	}

	// obtiene las fechas de inicio de los productos(cursos) PENDIENTE
	public void startDates() {
		try {
			stb.setListaD(studentService.startDates(stb.getIdCourse(), stb.getFormatDate1(), stb.getFormatDate2()));
			if(stb.getListaD().size() != 0){
				stb.setValidation(true);
			}else{
				stb.setValidation(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			stb.setValidation(false);
		}
	}
	
	// obtiene todos los pagos de un alumno y calcula los totales PENDIENTE
	public String paymentsByStudent() {
		stb.setTotalCourse(0.0); //		this.totalCourse = 0.0;
		stb.setTotalPayment(0.0);//		this.totalPayment = 0.0;
		stb.setRemaining(0.0);//		this.remaining = 0.0;
		
		try {
			if(stb.getIdProduct() != null){
			stb.setListaPsp(studentService.paymentByStudent(stb.getIdStudent(), stb.getIdProduct()));
			
				if (stb.getListaPsp().size() != 0) {
					for (int i = 0; i < stb.getListaPsp().size(); i++) {
						if (i == 0) {
							stb.setTotalCourse(stb.getListaPsp().get(i).getTotalCourse());
							stb.setNameStudent(stb.getListaPsp().get(i).getStudentName());							
						}
						stb.setTotalPayment(stb.getTotalPayment() + stb.getListaPsp().get(i).getAmountPayment());
						
					}
					stb.setRemaining(stb.getTotalCourse() - stb.getTotalPayment());					
					return "consult";
				} else {
					RequestContext.getCurrentInstance().execute("PF('no_payments').show()");
					return "";
				}
			}else{
				RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
				return "";
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			log.error(e);
//			RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
			return "";	
		}	
	}
	
	
	// crea los tikets de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double totalPayment = 0.0;
		stb.setM(new MimeMultipart());

		try {
			 stb.setFrom((studentService.selectStudent(stb.getIdStudent())).getEmail()); 
			 stb.setSubject("Recibos de pagos realizados  para el curso " + studentService.selectCourseName(stb.getIdCourse()));		

			if (stb.getTemListaPsp().size() != 0) {
				for (int i = 0; i < stb.getTemListaPsp().size(); i++) {

					Double remaining2;
					totalPayment = totalPayment + stb.getTemListaPsp().get(i).getAmountPayment();
					remaining2 = stb.getTemListaPsp().get(i).getTotalCourse() - totalPayment;

					report.setStudentName(stb.getTemListaPsp().get(i).getStudentName());
					report.setCourseName(stb.getTemListaPsp().get(i).getCourseName());
					report.setNumPayment(stb.getTemListaPsp().get(i).getNumPayment().toString());
					report.setAmountPayment(stb.getTemListaPsp().get(i).getAmountPayment().toString());
					report.setDatePayment(stb.getTemListaPsp().get(i).getDatePayment().toString());
					report.setTypePayment(stb.getTemListaPsp().get(i).getTypePayment());
					report.setRemaining(remaining2.toString());
					report.setTotalCourse(stb.getTemListaPsp().get(i).getTotalCourse().toString());

					listaR.add(report);

					File jasper = new File(
							FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
							new JRBeanCollectionDataSource(listaR));
					stb.setOutputStream(new ByteArrayOutputStream());
					JasperExportManager.exportReportToPdfStream(jasperPrint, stb.getOutputStream());

					stb.setAdjunto(new MimeBodyPart());

					DataSource ds = new ByteArrayDataSource(stb.getOutputStream().toByteArray(), "application/pdf");
					stb.getAdjunto().setDataHandler(new DataHandler(ds));
					stb.getAdjunto().setFileName("Recibo " + stb.getTemListaPsp().get(i).getNumPayment() + "_"
							+ stb.getTemListaPsp().get(i).getStudentName() + ".pdf");
					stb.getM().addBodyPart(stb.getAdjunto());

					listaR.clear();

				}
				// this.temListaPsp.clear();
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('exito').show()");

			} else {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('vacio').show()");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('fallido').show()");
			log.error(e);
		}
	}

	// establece los valores para el envio del correo
	public void sendMail() {
		Correo c = new Correo();
		c.setPassword("Zaq12wsx123");
		c.setUserEmail("contacto@mentoringit.com.mx");
		c.setSubject(stb.getSubject());
		c.setFrom(stb.getFrom().trim());
		c.setMessage(stb.getMessage());

		if (controller(c)) {
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('success').show()");
		} else {
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('fail').show()");
		}

	}

	// controla el envio del correo
	private boolean controller(Correo c) {

		try {
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "gator4105.hostgator.com"); // Depende del servidor 
			props.setProperty("mail.smtp.starttls.enable", "true"); // Depende del servidor
			props.setProperty("mail.smtp.port", "587"); // Puede ser otro puerto
			props.setProperty("mail.smtp.user", "contacto@mentoringit.com.mx");
			props.setProperty("mail.smtp.auth", "true"); // Depende del servidor
			
	        Session s = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(c.getUserEmail(), c.getPassword());
	            }
	          });

	        BodyPart texto = new MimeBodyPart();
			// BodyPart adjunto;
			// MimeMultipart m = new MimeMultipart();

			texto.setText(c.getMessage());

			// for (int i=0; i<3;i++) {
			// adjunto = new MimeBodyPart();
			//
			//
			// DataSource ds = new
			// ByteArrayDataSource(outputStream.toByteArray(),
			// "application/pdf");
			// adjunto.setDataHandler(new DataHandler(ds));
			// adjunto.setFileName("Recibo");
			// m.addBodyPart(adjunto);

			// }

			 stb.getM().addBodyPart(texto);

			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUserEmail()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
			mensaje.setSubject(c.getSubject());
			mensaje.setContent(stb.getM(),"text/html; charset=utf-8");

			Transport t = s.getTransport("smtp");
			t.connect(c.getUserEmail(), c.getPassword());
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();

			return true;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	
	public void validateTrue(){
		stb.setValidation(true);
	}
	
	public void validateFalse(){
		stb.setValidation(false);
	}
	

	// getters and setters
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public StudentBean getStb() {
		return stb;
	}

	public void setStb(StudentBean stb) {
		this.stb = stb;
	}

}
