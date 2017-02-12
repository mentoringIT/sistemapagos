package mx.com.mentoringit.web.beans;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.IStudentService;

@ManagedBean
@SessionScoped
public class StudentBean {
	
	private IStudentService studentService;	
	
	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;
	private List<ProductDTO> listaD;
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;
	
	private Integer idCourse;
	private Integer idStudent;
	private Integer idProduct;
	private Date date1;
	private Date date2;
	private String formatDate1;
	private String formatDate2;
	private String nameStudent;
	private Double totalCourse = 0.0;
	private Double totalPayment = 0.0;
	private Double remaining = 0.0;
	
	
	
	public void courses(){
		try {
			listaC = this.studentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void students(){
		try {
			listaA = this.studentService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startDates(){
		try {
			listaD = this.studentService.startDates(idCourse, getFormatDate1(), getFormatDate2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String paymentsByStudent(){
		this.totalCourse = 0.0;
		this.totalPayment = 0.0;
		this.remaining = 0.0;
		
		try {
			listaPsp = this.studentService.paymentByStudent(idStudent, idProduct);
			
			if (listaPsp.size() != 0) {
			for (int i = 0; i < listaPsp.size(); i++) {
				if (i == 0) {

					this.totalCourse = listaPsp.get(i).getTotalCourse();
					this.nameStudent = listaPsp.get(i).getStudentName();
				}
				this.totalPayment = this.totalPayment + listaPsp.get(i).getAmountPayment();
			}
			}else{
				this.nameStudent = this.studentService.selectName(idStudent);
			}

			this.remaining = this.totalCourse - this.totalPayment;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "consult";
	}
	
	
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<CourseDTO> getListaC() {
		courses();
		return listaC;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}


	public List<StudentDTO> getListaA() {
		students();
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
		paymentsByStudent();
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

	
	

}
