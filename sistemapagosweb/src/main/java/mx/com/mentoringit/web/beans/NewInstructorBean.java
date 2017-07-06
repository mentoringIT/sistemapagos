package mx.com.mentoringit.web.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.ProductDTO;

@ManagedBean(name = "MbNewInstructorBean")
@SessionScoped
public class NewInstructorBean {
	/*atributos de la parte 1*/
	private String name;
	private String pLastName;
	private String mLastName;
	private String completeName;
	private String phone;
	private String email;
	private String typeStudy;
	private String certification;
	private String title;
	private String cedula;
	private String formatDate1;
	private String formatDate2;
	private String formatDatePayment;
	/*atributos de la parte 2*/
	private Integer idInstructor;
	private Integer idCourse;
	private Date date1;
	private Date date2;
	private Integer idProduct;
	private String placeCourse;
	private String timeCourse;
	private Date datePayment;
	private Double total;
	private Double amount;
	private Integer numPayment;
	private String typePayment;
	private List<ProductDTO> listaD;
	private Boolean validation;

	public NewInstructorBean() {		
		this.date1 = new Date();
		this.date2 = new Date();
		this.datePayment = new Date();
		this.total = 0.0;
		this.amount = 0.0;
		this.numPayment = 1;	
		this.validation = false;
	}


	/*getters and setters*/
	
	public String getName() {
		return name;
	}

	public String getpLastName() {
		return pLastName;
	}

	public String getmLastName() {
		return mLastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getTypeStudy() {
		return typeStudy;
	}

	public String getCertification() {
		return certification;
	}

	public String getTitle() {
		return title;
	}

	public String getCedula() {
		return cedula;
	}

	public Integer getIdInstructor() {
		return idInstructor;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public Date getDate1() {
		return date1;
	}

	public Date getDate2() {
		return date2;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public String getPlaceCourse() {
		return placeCourse;
	}

	public String getTimeCourse() {
		return timeCourse;
	}

	public Date getDatePayment() {
		return datePayment;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}

	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTypeStudy(String typeStudy) {
		this.typeStudy = typeStudy;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public void setIdInstructor(Integer idInstructor) {
		this.idInstructor = idInstructor;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public void setPlaceCourse(String placeCourse) {
		this.placeCourse = placeCourse;
	}

	public void setTimeCourse(String timeCourse) {
		this.timeCourse = timeCourse;
	}

	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
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


	public String getCompleteName() {
		this.completeName = this.name + " " + this.pLastName + " " + this.mLastName;
		return completeName;
	}


	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDate1 = format.format(date1);
		return formatDate1;
	}


	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDate2 = format.format(date2);
		return formatDate2;
	}


	public String getFormatDatePayment() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDatePayment = format.format(datePayment);
		return formatDatePayment;
	}


	public List<ProductDTO> getListaD() {
		return listaD;
	}


	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}


	public Boolean getValidation() {
		return validation;
	}


	public void setValidation(Boolean validation) {
		this.validation = validation;
	}

}
