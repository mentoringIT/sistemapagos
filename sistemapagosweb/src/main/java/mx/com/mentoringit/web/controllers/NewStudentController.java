package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayInputStream;
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
import org.primefaces.model.DefaultStreamedContent;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.NewStudentBean;
import mx.com.mentoringit.web.services.INewStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbNewStudentController")
@SessionScoped
public class NewStudentController implements Serializable {
	private final static Logger log = Logger.getLogger(NewStudentController.class);
	
	@ManagedProperty(value = "#{newStudentService}")
	private INewStudentService newStudentService;
	
	@ManagedProperty(value = "#{MbNewStudent}")
	private NewStudentBean nsb;
	
	public NewStudentController(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// obtiene todos los cursos
	public List<CourseDTO> selectCourse() {
		try {
			return newStudentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			log.error(e);
			return null;
		}
	}
	
	// obtiene las fechas de inicio
		public void startDates() {

			try {
				nsb.setListaD(newStudentService.startDates(nsb.getIdCourse(), nsb.getFormatDate1(), nsb.getFormatDate2()));
				if (nsb.getListaD().size() != 0) {
					nsb.setValidation(true);
				} else {
					nsb.setValidation(false);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
				nsb.setValidation(true);
			}
		}
		
		// crea el tiket de pago
		public void createReport() {
			List<ReportData> listaR = new ArrayList<ReportData>();
			ReportData report = new ReportData();
			Double remaining = 0.0;
	
			try {				
				nsb.setSubject("Recibo de pago No. " + nsb.getNum_payment() + " para el curso "
						+ this.newStudentService.selectCourseName(nsb.getIdCourse()));			

				
				if (nsb.getIdProduct() != null) {
					if (nsb.getAmount().doubleValue() > nsb.getTotal().doubleValue()) {
						RequestContext.getCurrentInstance().execute("PF('invalidPayment').show()");
					} else {
						remaining = nsb.getTotal() - nsb.getAmount();
	
						report.setStudentName(nsb.getCompleteName());
						report.setCourseName(newStudentService.selectCourseName(nsb.getIdCourse()));
						report.setNumPayment(nsb.getNum_payment().toString());
						report.setAmountPayment(nsb.getAmount().toString());
						report.setDatePayment(nsb.getFormatDatePayment());
						report.setTypePayment(nsb.getType_payment());
						report.setRemaining(remaining.toString());
						report.setTotalCourse(nsb.getTotal().toString());
	
						listaR.add(report);
	
						File jasper = new File(
								FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
								new JRBeanCollectionDataSource(listaR));
						nsb.setOutputStream(new ByteArrayOutputStream());
						JasperExportManager.exportReportToPdfStream(jasperPrint, nsb.getOutputStream());
	
						InputStream is = new ByteArrayInputStream(nsb.getOutputStream().toByteArray());
						nsb.setMedia(new DefaultStreamedContent(is, "application/pdf", "Recibo.pdf"));
	
						listaR.clear();
	
						RequestContext rc = RequestContext.getCurrentInstance();
						rc.execute("PF('detail').show()");
	
					}
				} else {
					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('selecionar').show()");
				}
	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('genPago').show()");
				log.error(e);
			}
		}
		

		// inserta al estudiante en la base
		public String inStudent() {
			StudentDTO student = new StudentDTO();

			student.setEmail(nsb.getEmail());
			student.setName(nsb.getCompleteName());
			student.setPhone(nsb.getTel());

			try {
				newStudentService.insertStudent(student);
				nsb.setIdStudent(newStudentService.idMax());
				insertPayment();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
			return "next";
		}
		
		// inserta el pago en la base
		private void insertPayment() {
			PaymentDTO payment = new PaymentDTO();

			payment.setStudent_id(nsb.getIdStudent());
			payment.setCourse_id(nsb.getIdCourse());
			payment.setNum_payment(nsb.getNum_payment());
			payment.setAmount_payment(nsb.getAmount());
			payment.setType_payment(nsb.getType_payment());
			payment.setDate_payment(nsb.getPaymentDate());
			payment.setTotal_course(nsb.getTotal());
			payment.setProduct_id(nsb.getIdProduct());

			try {
				this.newStudentService.insertPayment(payment);
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('regExito').show()");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('regFallido').show()");
				log.error(e);
			}

		}


		// controla el envio del correo
		private boolean controller(Correo c) {

			try {
				Properties props = new Properties();
				props.setProperty("mail.smtp.host", "gator4105.hostgator.com"); // Depende
																				// del
																				// servidor
				props.setProperty("mail.smtp.starttls.enable", "true"); // Depende
																		// del
																		// servidor
				props.setProperty("mail.smtp.port", "587"); // Puede ser otro puerto
				props.setProperty("mail.smtp.user", "contacto@mentoringit.com.mx");
				props.setProperty("mail.smtp.auth", "true"); // Depende del servidor

				Session s = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(c.getUserEmail(), c.getPassword());
					}
				});

				BodyPart texto = new MimeBodyPart();
				BodyPart adjunto;
				MimeMultipart m = new MimeMultipart();

				texto.setText(c.getMessage());

				adjunto = new MimeBodyPart();
				DataSource ds = new ByteArrayDataSource( nsb.getOutputStream().toByteArray(), "application/pdf");
				adjunto.setDataHandler(new DataHandler(ds));
				adjunto.setFileName("Recibo");
				m.addBodyPart(adjunto);

				m.addBodyPart(texto);

				MimeMessage mensaje = new MimeMessage(s);
				mensaje.setFrom(new InternetAddress(c.getUserEmail()));
				mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
				mensaje.setSubject(c.getSubject());
				mensaje.setContent(m,"text/html; charset=utf-8");

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

		// establece los valores para el envio del correo
		public void sendMail() {
			Correo c = new Correo();
			c.setPassword("Zaq12wsx123");
			c.setUserEmail("contacto@mentoringit.com.mx");
			c.setSubject(nsb.getSubject());
			c.setFrom(nsb.getEmail());
			c.setMessage(nsb.getMessage());

			if (controller(c)) {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('success').show()");
			} else {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('fail').show()");
			}

		}
	
	//getters and setters
	public INewStudentService getNewStudentService() {
		return newStudentService;
	}

	public void setNewStudentService(INewStudentService newStudentService) {
		this.newStudentService = newStudentService;
	}

	public NewStudentBean getNsb() {
		return nsb;
	}

	public void setNsb(NewStudentBean nsb) {
		this.nsb = nsb;
	}


}
