package mx.com.mentoringit.web.beans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
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
import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.activation.DataHandler;
import javax.activation.DataSource;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.ICourseService;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class CourseBean implements Serializable {
	private ICourseService courseService;

	private Integer idCourse;
	private Integer idStudent;
	private Integer idProduct;

	private Date date1 = new Date();
	private Date date2 = new Date();
	private String formatDate1;
	private String formatDate2;
	private Double total = 0.0;
	private Double amount = 0.0;
	private Integer num_payment = 1;
	private String type_payment;
	private Date date_payment = new Date();
	private String date_payment2;
	private Boolean validation = false;
	private Boolean paymentStatus = false;
	private Boolean valData = false;

	private String from;
	private String subject;
	private String message;

	private Double totalCourse = 0.0;
	private Double totalPayment = 0.0;
	private Double remaining = 0.0;

	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;
	private List<StudentDTO> listaAllS;
	private List<ProductDTO> listaD;
	private ByteArrayOutputStream outputStream = null;
	private StreamedContent media = null;

	public CourseBean() {
	}

	// obtiene todos los cursos
	public void selectCourse() {
		try {
			listaC = this.courseService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene alumnos segun el curso
	public void selectStudent() {

		try {
			listaA = this.courseService.studentByCourse(idCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene todos los alumnos
	public void selectAllStudent() {

		try {
			listaAllS = this.courseService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene las fechas de inicio
	public void startDates() {

		try {
			listaD = this.courseService.startDates(this.idCourse, getFormatDate1(), getFormatDate2());
			if(this.listaD.size() != 0){
				this.validation = true;
			}else{
				this.validation = false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.validation = false;
		}
	}

	// inserta el pago en la base
	public void insertPayment() {
		PaymentDTO payment = new PaymentDTO();

		payment.setStudent_id(this.idStudent);
		payment.setCourse_id(this.idCourse);
		payment.setNum_payment(this.num_payment);
		payment.setAmount_payment(this.amount);
		payment.setType_payment(this.type_payment);
		payment.setDate_payment(this.date_payment);
		payment.setTotal_course(this.total);
		payment.setProduct_id(this.idProduct);

		try {
			this.courseService.insertPayment(payment);
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('regExito').show()");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('regFallido').show()");
			e.printStackTrace();
		}

	}

	// crea el tiket de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();

		try {
			if (this.idProduct != null) {
				report.setStudentName((this.courseService.selectStudent(this.idStudent)).getName());
				report.setCourseName(this.courseService.selectCourseName(this.idCourse));
				report.setNumPayment(this.num_payment.toString());
				report.setAmountPayment(this.amount.toString());
				report.setDatePayment(getDate_payment2());
				report.setTypePayment(this.type_payment);
				report.setRemaining(this.remaining.toString());
				report.setTotalCourse(this.total.toString());

				listaR.add(report);

				File jasper = new File(
						FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
						new JRBeanCollectionDataSource(listaR));
				outputStream = new ByteArrayOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

				InputStream is = new ByteArrayInputStream(this.outputStream.toByteArray());
				media = new DefaultStreamedContent(is, "application/pdf", "Recibo");

				listaR.clear();
				System.out.println("hecho");
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('detail').show()");

			} else {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('selecionar').show()");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('genPago').show()");
			e.printStackTrace();

		}

	}

	// muestra los totales
	public void totals() {
		this.totalCourse = 0.0;
		this.totalPayment = 0.0;
		this.remaining = 0.0;
		this.amount = 0.0;
		try {

			List<PaymentDTO> listaP;
			listaP = this.courseService.selectPayment(idStudent, idProduct);

			if (listaP.size() != 0) {
				for (int i = 0; i < listaP.size(); i++) {
					if (i == 0) {

						this.totalCourse = listaP.get(i).getTotal_course();
						this.total = this.totalCourse;
					}
					this.totalPayment = this.totalPayment + listaP.get(i).getAmount_payment();
					this.num_payment = listaP.get(i).getNum_payment();

				}
				this.num_payment = this.num_payment + 1;
				this.remaining = this.totalCourse - this.totalPayment;				
				
			} else {
				this.num_payment = 1;
				this.total = 0.0;
				this.amount = 0.0;
			}
			
			status(this.totalCourse.doubleValue(), this.totalPayment.doubleValue());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void status(double n1, double n2) {
		RequestContext rc = RequestContext.getCurrentInstance();
		if (n1 == n2 && n2 != 0.0){
			this.paymentStatus = true;			
			rc.execute("PF('status').show()");
			
		} else {
			this.paymentStatus = false;
			rc.update("form1");
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
			BodyPart adjunto;
			MimeMultipart m = new MimeMultipart();

			texto.setText(c.getMessage());

			adjunto = new MimeBodyPart();

			DataSource ds = new ByteArrayDataSource(outputStream.toByteArray(), "application/pdf");
			adjunto.setDataHandler(new DataHandler(ds));
			adjunto.setFileName("Recibo");
			m.addBodyPart(adjunto);

			m.addBodyPart(texto);
			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUserEmail()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
			mensaje.setSubject(c.getSubject());
			mensaje.setContent(m);

			Transport t = s.getTransport("smtp");
			t.connect(c.getUserEmail(), c.getPassword());
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();

			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
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
	

	// getters y setters

	// da formatos al primer rango de fecha
	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate1 = format.format(date1);
		return formatDate1;
	}

	// da formatos al segundo rango de fecha
	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate2 = format.format(date2);
		return formatDate2;
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

	// muestra todos los alumnos
	public List<StudentDTO> getListaAllS() {
		selectAllStudent();
		return listaAllS;
	}

	// muestra alumnos segun el curso
	public List<StudentDTO> getListaA() {
		selectStudent();
		return listaA;
	}

	// muestra todos los cursos
	public List<CourseDTO> getListaC() {
		selectCourse();
		return listaC;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
			
		if(!idCourse.equals(this.idCourse)){
			this.validation = false;
			this.total = 0.0;
			this.amount = 0.0;
			this.num_payment = 1;
			this.idStudent = null;
			this.idProduct = null;
			this.listaD = null;
			}
		this.idCourse = idCourse;
		
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	// muestra las fechas de inicio de un curso
	public List<ProductDTO> getListaD() {
		return listaD;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDate_payment2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		date_payment2 = format.format(date_payment);
		return date_payment2;
	}

	public Date getDate_payment() {
		return date_payment;
	}

	public void setDate_payment(Date fecha_pago) {
		this.date_payment = fecha_pago;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double monto) {
		this.amount = monto;
	}

	public Integer getNum_payment() {
		return num_payment;
	}

	public void setNum_payment(Integer num_pago) {
		this.num_payment = num_pago;
	}

	public String getType_payment() {
		return type_payment;
	}

	public void setType_payment(String forma_pago) {
		this.type_payment = forma_pago;
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

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
		this.valData = false;
	}

	public String getFrom() {
		try {
			this.from = (this.courseService.selectStudent(this.idStudent)).getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		try {
			this.subject = "Recibo de pago No. " + this.num_payment + " para el curso "
					+ this.courseService.selectCourseName(this.idCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.subject;
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

	public Boolean getValidation() {
		return validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}

	public StreamedContent getMedia() {
		return media;
	}

	public void setMedia(StreamedContent media) {
		this.media = media;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Boolean getValData() {
		return valData;
	}

	public void setValData(Boolean valData) {
		this.valData = valData;
	}

}
