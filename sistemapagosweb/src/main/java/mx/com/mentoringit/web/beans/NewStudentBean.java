package mx.com.mentoringit.web.beans;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.INewStudentService;

@ManagedBean
@SessionScoped
public class NewStudentBean {
	
	private INewStudentService newStudentService;
	private List<CourseDTO> listaC;
	private List<ProductDTO> listaD;
		
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
	private Integer num_payment = 0;
	private String type_payment;
	private Integer idCourse;
	private Integer idProduct;
	private Integer idStudent;
	private Date date1;
	private Date date2;
	private String formatDate1;
	private String formatDate2;
	
	
	//obtiene todos los cursos
	public void selectCourse() {
		try {
			listaC = this.newStudentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inserta al estudiante en la base
	public String inStudent(){
		StudentDTO student = new StudentDTO();
		
		student.setEmail(this.email);
		student.setName(getCompleteName());
		student.setPhone(this.tel);
		
		try {
			this.newStudentService.insertStudent(student);
			this.idStudent = this.newStudentService.idMax();
			insertPayment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "next";
	}
	
	// obtiene las fechas de inicio
		public void startDates() {

			try {
				listaD = this.newStudentService.startDates(this.idCourse, getFormatDate1(), getFormatDate2());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			payment.setDate_payment(this.paymentDate);
			payment.setTotal_course(this.total);
			payment.setProduct_id(this.idProduct);

			try {
				this.newStudentService.insertPayment(payment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		

	
	
	//getters and setters
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
		this.completeName = this.name + " " +this.pLastName + " " + this.mLastName;
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
		selectCourse();
		return listaC;
	}
	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}
	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
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

}
