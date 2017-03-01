package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.PSPDAO;
import mx.com.mentoringit.model.dao.PaymentDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@Service
public class NewStudentService implements INewStudentService{
	
	private CourseDAO courseDAO;
	private StudentDAO studentDAO;
	private ProductDAO productDAO;
	private PaymentDAO paymentDAO;
	
	
	
	//getters anad setters
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}
	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}
	
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public PaymentDAO getPaymentDAO() {
		return paymentDAO;
	}
	@Autowired
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}	
	
	@Override
	public List<CourseDTO> allCourse() throws Exception {		
		return this.courseDAO.select();
	}
	@Override
	public void insertStudent(StudentDTO student) throws Exception {
		this.studentDAO.insertStudent(student);
	}
	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}
	
	@Override
	public Integer idMax() throws Exception {
		Integer id;
		id = this.studentDAO.selectIdMax().getId();
		return id;
	}
	@Override
	public void insertPayment(PaymentDTO payment) throws Exception {
		this.paymentDAO.insertPayment(payment);		
	}
	
	@Override
	public String selectStudentName(Integer idStudent) throws Exception {
		return this.studentDAO.selectName(idStudent).getName();
	}

	@Override
	public String selectCourseName(Integer idCourse) throws Exception {
		return this.courseDAO.selectName(idCourse).getName();
	}

}
