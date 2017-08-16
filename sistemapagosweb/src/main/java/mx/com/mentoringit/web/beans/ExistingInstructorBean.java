package mx.com.mentoringit.web.beans;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.StreamedContent;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@ManagedBean(name = "MbExistingInstructor")
@SessionScoped
public class ExistingInstructorBean {
	private Integer idCourse;
	private Integer idStudent;
	private Integer idProduct;

	private Date date1;
	private Date date2;
	private String formatDate1;
	private String formatDate2;
	private Double total;
	private Double amount;
	private Integer numPayment;
	private String typePayment;
	private Date datePayment;
	private String datePayment2;
	private Boolean validation;
	private Boolean paymentStatus;
	private Boolean valData;

	private String from;
	private String subject;
	private String message;

	private Double totalCourse;
	private Double totalPayment;
	private Double remaining;

	private List<CourseDTO> listaC;
	// private List<StudentDTO> listaA;
	private List<StudentDTO> listaAllS;
	private List<ProductDTO> listaD;
	private ByteArrayOutputStream outputStream;
	private StreamedContent media;
	// private String realPath;

	public ExistingInstructorBean() {
		this.date1 = new Date();
		this.date2 = new Date();
		this.datePayment = new Date();
		this.total = 0.0;
		this.amount = 0.0;
		this.numPayment = 1;
		this.validation = false;
		this.paymentStatus = false;
		this.valData = false;
		this.outputStream = null;
		this.media = null;

		/*--totales--*/
		this.totalCourse = 0.0;
		this.totalPayment = 0.0;
		this.remaining = 0.0;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public Date getDate1() {
		return date1;
	}

	public Date getDate2() {
		return date2;
	}

	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate1 = format.format(date1);
		return formatDate1;
	}

	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate2 = format.format(date2);
		return formatDate2;
	}

	public Double getTotal() {
		return total;
	}

	public Double getAmount() {
		return amount;
	}

	public Integer getNumPayment() {
		return numPayment;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public Date getDatePayment() {
		return datePayment;
	}

	public String getDatePayment2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		datePayment2 = format.format(datePayment);
		return datePayment2;
	}

	public Boolean getValidation() {
		return validation;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public Boolean getValData() {
		return valData;
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}

	public Double getTotalCourse() {
		return totalCourse;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public Double getRemaining() {
		return remaining;
	}

	public List<CourseDTO> getListaC() {
		return listaC;
	}

	public List<StudentDTO> getListaAllS() {
		return listaAllS;
	}

	public List<ProductDTO> getListaD() {
		return listaD;
	}

	public ByteArrayOutputStream getOutputStream() {
		return outputStream;
	}

	public StreamedContent getMedia() {
		return media;
	}

	public void setIdCourse(Integer idCourse) {
		if (!idCourse.equals(this.idCourse)) {
			this.validation = false;
			this.total = 0.0;
			this.amount = 0.0;
			this.numPayment = 1;
			this.idStudent = null;
			this.idProduct = null;
			this.listaD = null;
			this.paymentStatus = false;
		}		

		this.idCourse = idCourse;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public void setFormatDate1(String formatDate1) {
		this.formatDate1 = formatDate1;
	}

	public void setFormatDate2(String formatDate2) {
		this.formatDate2 = formatDate2;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setNumPayment(Integer numPayment) {
		this.numPayment = numPayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}

	public void setDatePayment2(String datePayment2) {
		this.datePayment2 = datePayment2;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public void setValData(Boolean valData) {
		this.valData = valData;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTotalCourse(Double totalCourse) {
		this.totalCourse = totalCourse;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}

	public void setListaAllS(List<StudentDTO> listaAllS) {
		this.listaAllS = listaAllS;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public void setOutputStream(ByteArrayOutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public void setMedia(StreamedContent media) {
		this.media = media;
	}

}
