package mx.com.mentoringit.web.beans;

import java.util.List;
import java.util.Properties;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import javax.faces.bean.ManagedBean;
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
import org.primefaces.model.StreamedContent;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;

import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.INewStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbNewStudent")
@SessionScoped
public class NewStudentBean implements Serializable {
	
	private INewStudentService newStudentService;
	private List<CourseDTO> listaC;
	private List<ProductDTO> listaD;

	private String from;
	private String subject;
	private String message;

	private String name;
	private String pLastName;
	private String mLastName;
	private String completeName;
	private String tel;
	private String email;
	private Date paymentDate = new Date();
	private String formatDatePayment;
	private Double total = 0.0;
	private Double amount = 0.0;
	private Integer num_payment = 1;
	private String type_payment;
	private Integer idCourse;
	private Integer idProduct;
	private Integer idStudent;
	private Date date1 = new Date();
	private Date date2 = new Date();
	private String formatDate1;
	private String formatDate2;
	private Boolean validation = false;

	private ByteArrayOutputStream outputStream = null;
	private StreamedContent media = null;
	
	public NewStudentBean(){
		
	}

//	// obtiene todos los cursos
//	public void selectCourse() {
//		try {
//			listaC = this.newStudentService.allCourse();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//	}

//	// inserta al estudiante en la base
//	public String inStudent() {
//		StudentDTO student = new StudentDTO();
//
//		student.setEmail(this.email);
//		student.setName(getCompleteName());
//		student.setPhone(this.tel);
//
//		try {
//			this.newStudentService.insertStudent(student);
//			this.idStudent = this.newStudentService.idMax();
//			insertPayment();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//		return "next";
//	}

//	// obtiene las fechas de inicio
//	public void startDates() {
//
//		try {
//			listaD = this.newStudentService.startDates(this.idCourse, getFormatDate1(), getFormatDate2());
//			if (this.listaD.size() != 0) {
//				this.validation = true;
//			} else {
//				this.validation = false;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//			this.validation = false;
//		}
//	}

//	// inserta el pago en la base
//	private void insertPayment() {
//		PaymentDTO payment = new PaymentDTO();
//
//		payment.setStudent_id(this.idStudent);
//		payment.setCourse_id(this.idCourse);
//		payment.setNum_payment(this.num_payment);
//		payment.setAmount_payment(this.amount);
//		payment.setType_payment(this.type_payment);
//		payment.setDate_payment(this.paymentDate);
//		payment.setTotal_course(this.total);
//		payment.setProduct_id(this.idProduct);
//
//		try {
//			this.newStudentService.insertPayment(payment);
//			RequestContext rc = RequestContext.getCurrentInstance();
//			rc.execute("PF('regExito').show()");
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			RequestContext rc = RequestContext.getCurrentInstance();
//			rc.execute("PF('regFallido').show()");
//
//			log.error(e);
//		}
//
//	}

//	// crea el tiket de pago
//	public void createReport() {
//		List<ReportData> listaR = new ArrayList<ReportData>();
//		ReportData report = new ReportData();
//		Double remaining = 0.0;
//
//		try {
//			if (this.idProduct != null) {
//				if (this.amount.doubleValue() > this.total.doubleValue()) {
//					RequestContext.getCurrentInstance().execute("PF('invalidPayment').show()");
//				} else {
//					remaining = this.total - this.amount;
//
//					report.setStudentName(this.getCompleteName());
//					report.setCourseName(this.newStudentService.selectCourseName(this.idCourse));
//					report.setNumPayment(this.num_payment.toString());
//					report.setAmountPayment(this.amount.toString());
//					report.setDatePayment(getFormatDatePayment());
//					report.setTypePayment(this.type_payment);
//					report.setRemaining(remaining.toString());
//					report.setTotalCourse(this.total.toString());
//
//					listaR.add(report);
//
//					File jasper = new File(
//							FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
//					JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
//							new JRBeanCollectionDataSource(listaR));
//					outputStream = new ByteArrayOutputStream();
//					JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
//
//					InputStream is = new ByteArrayInputStream(this.outputStream.toByteArray());
//					media = new DefaultStreamedContent(is, "application/pdf", "Recibo.pdf");
//
//					listaR.clear();
//
//					RequestContext rc = RequestContext.getCurrentInstance();
//					rc.execute("PF('detail').show()");
//
//				}
//			} else {
//				RequestContext rc = RequestContext.getCurrentInstance();
//				rc.execute("PF('selecionar').show()");
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			RequestContext rc = RequestContext.getCurrentInstance();
//			rc.execute("PF('genPago').show()");
//			log.error(e);
//		}
//	}

//	// controla el envio del correo
//	private boolean controller(Correo c) {
//
//		try {
//			Properties props = new Properties();
//			props.setProperty("mail.smtp.host", "gator4105.hostgator.com"); // Depende
//																			// del
//																			// servidor
//			props.setProperty("mail.smtp.starttls.enable", "true"); // Depende
//																	// del
//																	// servidor
//			props.setProperty("mail.smtp.port", "587"); // Puede ser otro puerto
//			props.setProperty("mail.smtp.user", "contacto@mentoringit.com.mx");
//			props.setProperty("mail.smtp.auth", "true"); // Depende del servidor
//
//			Session s = Session.getInstance(props, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(c.getUserEmail(), c.getPassword());
//				}
//			});
//
//			BodyPart texto = new MimeBodyPart();
//			BodyPart adjunto;
//			MimeMultipart m = new MimeMultipart();
//
//			texto.setText(c.getMessage());
//
//			adjunto = new MimeBodyPart();
//			DataSource ds = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
//			adjunto.setDataHandler(new DataHandler(ds));
//			adjunto.setFileName("Recibo");
//			m.addBodyPart(adjunto);
//
//			m.addBodyPart(texto);
//
//			MimeMessage mensaje = new MimeMessage(s);
//			mensaje.setFrom(new InternetAddress(c.getUserEmail()));
//			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
//			mensaje.setSubject(c.getSubject());
//			mensaje.setContent(m,"text/html; charset=utf-8");
//
//			Transport t = s.getTransport("smtp");
//			t.connect(c.getUserEmail(), c.getPassword());
//			t.sendMessage(mensaje, mensaje.getAllRecipients());
//			t.close();
//
//			return true;
//		} catch (Exception e) {
//
////			e.printStackTrace();
//			log.error(e);
//			return false;
//		}
//	}
//
//	// establece los valores para el envio del correo
//	public void sendMail() {
//		Correo c = new Correo();
//		c.setPassword("Zaq12wsx123");
//		c.setUserEmail("contacto@mentoringit.com.mx");
//		c.setSubject(this.subject);
//		c.setFrom(this.from.trim());
//		c.setMessage(this.message);
//
//		if (controller(c)) {
//			RequestContext rc = RequestContext.getCurrentInstance();
//			rc.execute("PF('success').show()");
//		} else {
//			RequestContext rc = RequestContext.getCurrentInstance();
//			rc.execute("PF('fail').show()");
//		}
//
//	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpLastName() {
		return pLastName;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public String getmLastName() {
		return mLastName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public String getCompleteName() {
		this.completeName = this.name + " " + this.pLastName + " " + this.mLastName;
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getFormatDatePayment() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDatePayment = format.format(paymentDate);
		return formatDatePayment;
	}

	public void setFormatDatePayment(String formatDatePayment) {
		this.formatDatePayment = formatDatePayment;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNum_payment() {
		return num_payment;
	}

	public void setNum_payment(Integer num_payment) {
		this.num_payment = num_payment;
	}

	public String getType_payment() {
		return type_payment;
	}

	public void setType_payment(String type_payment) {
		this.type_payment = type_payment;
	}

	public List<CourseDTO> getListaC() {
//		selectCourse();
		return listaC;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {

		if (!idCourse.equals(this.idCourse)) {
			this.validation = false;
			this.name = null;
			this.pLastName = null;
			this.mLastName = null;
			this.tel = null;
			this.email = null;
			this.total = 0.0;
			this.amount = 0.0;
			this.num_payment = 1;
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
		this.formatDate1 = format.format(date1);
		return formatDate1;
	}

	public void setFormatDate1(String formatDate1) {
		this.formatDate1 = formatDate1;
	}

	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDate2 = format.format(date2);
		return formatDate2;
	}

	public void setFormatDate2(String formatDate2) {
		this.formatDate2 = formatDate2;
	}

	public List<ProductDTO> getListaD() {
		return listaD;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public INewStudentService getNewStudentService() {
		return newStudentService;
	}

	public void setNewStudentService(INewStudentService newStudentService) {
		this.newStudentService = newStudentService;
	}

	public String getFrom() {
//		try {
//			this.from = (this.newStudentService.selectStudent(this.idStudent)).getEmail();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
//		try {
//			this.subject = "Recibo de pago No. " + this.num_payment + " para el curso "
//					+ this.newStudentService.selectCourseName(this.idCourse);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StreamedContent getMedia() {
		return media;
	}

	public void setMedia(StreamedContent media) {
		this.media = media;
	}

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}

	public void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
	}

}
