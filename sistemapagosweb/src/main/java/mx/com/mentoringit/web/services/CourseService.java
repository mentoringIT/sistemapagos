package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.PaymentDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.RegistrationDAO;

import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;

import mx.com.mentoringit.model.dto.StudentDTO;


@Service
public class CourseService implements ICourseService {
	
	private CourseDAO courseDAO;
	private RegistrationDAO regDAO;
	private StudentDAO studentDAO;
	private ProductDAO productDAO;
	private PaymentDAO paymentDAO;
		
	//getter y setter 
	public ProductDAO getProductDAO() {
		return productDAO;
	}
	
	@Autowired
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	
	public RegistrationDAO getRegDAO() {
		return regDAO;
	}

	@Autowired
	public void setRegDAO(RegistrationDAO regDAO) {
		this.regDAO = regDAO;
	}
	
	
	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
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
		return this.courseDAO.select() ;
	}

	@Override
	public List<StudentDTO> studentByCourse(Integer id) throws Exception {
		return this.regDAO.select(id);
	}
	
	@Override
	public List<StudentDTO> allStudent() throws Exception{
		return this.studentDAO.select();		
	}
	
	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception{
		return this.productDAO.startDate(id, date1, date2);
	}

	@Override
	public void insertPayment(PaymentDTO payment) throws Exception {
		this.paymentDAO.insertPayment(payment);
		
	}

	@Override
	public List<PaymentDTO> selectPayment(Integer idStudent, Integer idProduct) throws Exception {
		return this.paymentDAO.selectPayment(idStudent, idProduct);
		
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
