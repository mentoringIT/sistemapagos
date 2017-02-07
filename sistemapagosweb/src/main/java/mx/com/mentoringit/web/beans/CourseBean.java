package mx.com.mentoringit.web.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.ICourseService;

@ManagedBean
@SessionScoped
public class CourseBean {

	private Integer idCourse;
	private Integer idStudent;
	private Date date1;
	private Date date2;
	private String formatDate1;
	private String formatDate2;
	private Double total;
	private Double amount;
	private Integer num_payment;
	private String type_payment;
	private Date date_payment;
	private String date_payment2;
	private Integer date_start;
	
	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;
	private List<StudentDTO> listaAllS;
	private List<ProductDTO> listaD;
	private ICourseService courseService;
	

	public CourseBean() {}

	//obtiene todos los cursos
	public void selectCourse() {
		try {
			listaC = this.courseService.course();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//obtiene alumnos segun el curso
	public void selectStudent() {

		try {
			listaA = this.courseService.student(idCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//obtiene todos los alumnos
	public void selectAllStudent() {

		try {
			listaAllS = this.courseService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//obtiene las fechas de inicio
		public void stratDates() {

			try {
				listaD = this.courseService.dates(this.idCourse, getFormatDate1(), getFormatDate2());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public String insertPayment(){
			PaymentDTO payment = new PaymentDTO();
			
			payment.setStudent_id(this.idStudent);
			payment.setCourse_id(this.idCourse);
			payment.setNum_payment(this.num_payment);
			payment.setAmount_payment(this.amount);
			payment.setType_payment(this.type_payment);
			payment.setDate_payment(this.date_payment);
			payment.setTotal_course(this.total);
			payment.setProduct_id(this.date_start);
			
			try {
				this.courseService.paymetStudent(payment);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "next";
			
		}

	
	
	//getters y setters
	
	//da formatos al primer rango de fecha
	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate1 = format.format(date1);
		return formatDate1;
	}
	//da formatos al segundo rango de fecha
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
	
	//muestra todos los alumnos
	public List<StudentDTO> getListaAllS() {
		selectAllStudent();
		return listaAllS;
	}
	//muestra alumnos segun el curso
	public List<StudentDTO> getListaA() {
		selectStudent();
		return listaA;
	}
	//muestra todos los cursos
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
		this.idCourse = idCourse;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}
	//muestra las fechas de inicio de un curso
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

	public Integer getDate_start() {
		return date_start;
	}

	public void setDate_start(Integer fecha_inicio) {
		this.date_start = fecha_inicio;
	}

	
}
