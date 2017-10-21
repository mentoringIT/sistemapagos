package mx.com.mentoringit.web.beans;

import java.io.ByteArrayInputStream;
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
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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
import javax.servlet.ServletContext;

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
import mx.com.mentoringit.web.services.ICourseService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbExistingStudentBean")
@SessionScoped
public class ExistingStudentBean implements Serializable {
	
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
//	private List<StudentDTO> listaA;
	private List<StudentDTO> listaAllS;
	private List<ProductDTO> listaD;
	private ByteArrayOutputStream outputStream = null;
	private StreamedContent media = null;
//	private String realPath;

	public ExistingStudentBean() {
		System.out.println("entrando al constructor");
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
//		selectAllStudent();
		return listaAllS;
	}

	// muestra alumnos segun el curso
//	public List<StudentDTO> getListaA() {
//		selectStudent();
//		return listaA;
//	}

	// muestra todos los cursos
	public List<CourseDTO> getListaC() {
//		selectCourse();
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

		if (!idCourse.equals(this.idCourse)) {
			this.validation = false;
			this.total = 0.0;
			this.amount = 0.0;
			this.num_payment = 1;
			this.idStudent = null;
			this.idProduct = null;
			this.listaD = null;
			this.paymentStatus = false;
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
//		try {
//			this.from = (this.courseService.selectStudent(this.idStudent)).getEmail();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
		return this.from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
//		try {
//			this.subject = "Recibo de pago No. " + this.num_payment + " para el curso "
//					+ this.courseService.selectCourseName(this.idCourse);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
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

	public void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
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

//	public String getRealPath() {
//		return realPath;
//	}

}
