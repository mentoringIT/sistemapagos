package mx.com.mentoringit.web.beans;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@ManagedBean(name = "MbPaymentByInstructor")
@SessionScoped
public class PaymentByInstructorBean {
	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;
	private List<ProductDTO> listaD;
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> temListaPsp;
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;

	private Integer idCourse;
	private Integer idStudent;
	private Integer idProduct;
	private Date date1;
	private Date date2;
	private String formatDate1;
	private String formatDate2;
	private String nameInstructor;
	private Double totalCourse;
	private Double totalPayment;
	private Double remaining;
	private Boolean validation;

	private String from;
	private String subject;
	private String message;

	private ByteArrayOutputStream outputStream;
	private BodyPart adjunto;
	private MimeMultipart m;

	public PaymentByInstructorBean() {
		this.temListaPsp = new ArrayList<PSPDTO>();
		this.idProduct = null;
		this.date1 = new Date();
		this.date2 = new Date();
		this.totalCourse = 0.0;
		this.totalPayment = 0.0;
		this.remaining = 0.0;
		this.validation = false;
		this.outputStream = null;

	}

	/* getters and setters */
	public List<CourseDTO> getListaC() {
		return listaC;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}

	public List<StudentDTO> getListaA() {
		return listaA;
	}

	public void setListaA(List<StudentDTO> listaA) {
		this.listaA = listaA;
	}

	public List<ProductDTO> getListaD() {
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

	public String getNameInstructor() {
		return nameInstructor;
	}

	public void setNameInstructor(String nameInstructor) {
		this.nameInstructor = nameInstructor;
	}

	public List<PSPDTO> getTemListaPsp() {
		return temListaPsp;
	}

	public void setTemListaPsp(List<PSPDTO> temListaPsp) {
		this.temListaPsp = temListaPsp;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
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

	public MimeMultipart getM() {
		return m;
	}

	public void setM(MimeMultipart m) {
		this.m = m;
	}

	public BodyPart getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(BodyPart adjunto) {
		this.adjunto = adjunto;
	}

}
