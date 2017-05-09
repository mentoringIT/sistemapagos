package mx.com.mentoringit.web.beans;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.controllers.StudentController;
import mx.com.mentoringit.web.services.IStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbStudentList")
@RequestScoped
public class StudentBean implements Serializable {
	private final static Logger log = Logger.getLogger(StudentBean.class);
	
	@ManagedProperty(value = "#{MbStudentController}")
	private StudentController controller;
	
	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;	
	private List<ProductDTO> listaD;
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> temListaPsp = new ArrayList<PSPDTO>();
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;

	private Integer idCourse = null;
	private Integer idStudent;
	private Integer idProduct;
	private Date date1 = new Date();
	private Date date2 = new Date();
	private String formatDate1;
	private String formatDate2;
	private String nameStudent;
	private Double totalCourse = 0.0;
	private Double totalPayment = 0.0;
	private Double remaining = 0.0;
	private Boolean validation = false;
	
	private String from;
	private String subject;
	private String message;

	private ByteArrayOutputStream outputStream = null;
	private BodyPart adjunto;
	private MimeMultipart m;
	
	public StudentBean(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	// obtiene todos los cursos
//	public void courses() {
//		try {
//			listaC = this.studentService.allCourse();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//	}
//
//	// obtiene todos los alumnos
//	public void students() {
//		try {
//			listaA = this.studentService.allStudent();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//	}

	// obtiene las fechas de inicio de los productos(cursos) PENDIENTE
//	public void startDates() {
//		try {
//			listaD = this.studentService.startDates(idCourse, getFormatDate1(), getFormatDate2());
//			if(this.listaD.size() != 0){
//				this.validation = true;
//			}else{
//				this.validation = false;
//			}
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//	}

	// obtiene todos los pagos de un alumno y calcula los totales PENDIENTE
//	public String paymentsByStudent() {
//		this.totalCourse = 0.0;
//		this.totalPayment = 0.0;
//		this.remaining = 0.0;
//
//		try {
//			if(this.idProduct != null){
//			listaPsp = this.studentService.paymentByStudent(idStudent, idProduct);
//			
//				if (listaPsp.size() != 0) {
//					for (int i = 0; i < listaPsp.size(); i++) {
//						if (i == 0) {
//
//							this.totalCourse = listaPsp.get(i).getTotalCourse();
//							this.nameStudent = listaPsp.get(i).getStudentName();
//						}
//						this.totalPayment = this.totalPayment + listaPsp.get(i).getAmountPayment();
//					}
//					this.remaining = this.totalCourse - this.totalPayment;					
//					return "consult";
//				} else {
//					RequestContext.getCurrentInstance().execute("PF('no_payments').show()");
//					return "";
//				}
//			}else{
//				RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
//				return "";
//			}
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//			return "";	
//		}
//		
//		
//	}

	// crea los tikets de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double totalPayment = 0.0;
		m = new MimeMultipart();

		try {

			if (this.temListaPsp.size() != 0) {
				for (int i = 0; i < this.temListaPsp.size(); i++) {

					Double remaining2;
					totalPayment = totalPayment + this.temListaPsp.get(i).getAmountPayment();
					remaining2 = this.temListaPsp.get(i).getTotalCourse() - totalPayment;

					report.setStudentName(this.temListaPsp.get(i).getStudentName());
					report.setCourseName(this.temListaPsp.get(i).getCourseName());
					report.setNumPayment(this.temListaPsp.get(i).getNumPayment().toString());
					report.setAmountPayment(this.temListaPsp.get(i).getAmountPayment().toString());
					report.setDatePayment(this.temListaPsp.get(i).getDatePayment().toString());
					report.setTypePayment(this.temListaPsp.get(i).getTypePayment());
					report.setRemaining(remaining2.toString());
					report.setTotalCourse(this.temListaPsp.get(i).getTotalCourse().toString());

					listaR.add(report);

					File jasper = new File(
							FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
							new JRBeanCollectionDataSource(listaR));
					outputStream = new ByteArrayOutputStream();
					JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

					adjunto = new MimeBodyPart();

					DataSource ds = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
					adjunto.setDataHandler(new DataHandler(ds));
					adjunto.setFileName("Recibo " + this.temListaPsp.get(i).getNumPayment() + "_"
							+ this.temListaPsp.get(i).getStudentName() + ".pdf");
					m.addBodyPart(adjunto);

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
		c.setSubject(this.subject);
		c.setFrom(this.from.trim());
		c.setMessage(this.message);

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
//			e.printStackTrace();
			log.error(e);
			return false;
		}
	}

	// metodos getters y setters

//	public IStudentService getStudentService() {
//		return studentService;
//	}
//
//	public void setStudentService(IStudentService studentService) {
//		this.studentService = studentService;
//	}

	public List<CourseDTO> getListaC() {
		listaC = controller.courses();
		return listaC;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}

	public List<StudentDTO> getListaA() {
		listaA = controller.students();
		return listaA;
	}

	public void setListaA(List<StudentDTO> listaA) {
		this.listaA = listaA;
	}

	public List<ProductDTO> getListaD() {
		listaD = controller.startDates(idCourse, getFormatDate1(), getFormatDate2());
		return listaD;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {

		if (!idCourse.equals(this.idCourse)) {
			this.validation = false;
			this.idStudent = null;
			this.idProduct = null;
			this.listaD = null;
		}

		this.idCourse = idCourse;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate1 = format.format(date1);
		return formatDate1;
	}

	public void setFormatDate1(String formatDate1) {
		this.formatDate1 = formatDate1;
	}

	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate2 = format.format(date2);
		return formatDate2;
	}

	public void setFormatDate2(String formatDate2) {
		this.formatDate2 = formatDate2;
	}

	public List<PSPDTO> getFilterPayments() {
		return filterPayments;
	}

	public void setFilterPayments(List<PSPDTO> filterPayments) {
		this.filterPayments = filterPayments;
	}

	public PSPDTO getDetail() {
		return detail;
	}

	public void setDetail(PSPDTO detail) {
		this.detail = detail;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public List<PSPDTO> getListaPsp() {
//		paymentsByStudent();
		return listaPsp;
	}

	public void setListaPsp(List<PSPDTO> listaPsp) {
		this.listaPsp = listaPsp;
	}

	public Double getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(Double totalCourse) {
		this.totalCourse = totalCourse;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Double getRemaining() {
		return remaining;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public List<PSPDTO> getTemListaPsp() {
		return temListaPsp;
	}

	public void setTemListaPsp(List<PSPDTO> temListaPsp) {
		this.temListaPsp = temListaPsp;
	}

//	public String getFrom() { PENDIENTE
//		try {
//			this.from = (this.studentService.selectStudent(this.idStudent)).getEmail();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//		return from;
//	}

	public void setFrom(String from) {
		this.from = from;
	}

//	public String getSubject() { PENDIENTE
//		try {
//			this.subject = "Recibos de pagos realizados  para el curso "
//					+ this.studentService.selectCourseName(this.idCourse);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//		return subject;
//	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public StudentController getController() {
		return controller;
	}

	public void setController(StudentController controller) {
		this.controller = controller;
	}
}
