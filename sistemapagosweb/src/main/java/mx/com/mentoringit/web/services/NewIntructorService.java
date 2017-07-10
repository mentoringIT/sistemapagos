package mx.com.mentoringit.web.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.PaymentDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.ProfileDAO;
import mx.com.mentoringit.model.dao.RegistrationDAO;
import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ProfileDTO;
import mx.com.mentoringit.model.dto.RegistrationDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@Service
public class NewIntructorService implements INewInstructorServices {

	private CourseDAO courseDAO;
	private ProductDAO productDAO;
	private StudentDAO studentDAO;
	private RegistrationDAO registrationDAO;
	private PaymentDAO paymentDAO;
	private ProfileDAO profileDAO;

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	@Autowired
	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

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

	public RegistrationDAO getRegistrationDAO() {
		return registrationDAO;
	}

	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Autowired
	public void setRegistrationDAO(RegistrationDAO registrationDAO) {
		this.registrationDAO = registrationDAO;
	}

	public PaymentDAO getPaymentDAO() {
		return paymentDAO;
	}

	@Autowired
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}

	public ProfileDAO getProfileDAO() {
		return profileDAO;
	}

	@Autowired
	public void setProfileDAO(ProfileDAO profileDAO) {
		this.profileDAO = profileDAO;
	}

	@Override
	public List<CourseDTO> allCourse() throws Exception {
		return courseDAO.select();
	}

	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}

	@Override
	public String selectCourseName(Integer idCourse) throws Exception {
		return this.courseDAO.selectName(idCourse).getName();
	}

	@Override
	public void insertRegister(RegistrationDTO registrationDTO) throws Exception {
		this.registrationDAO.insertRegister(registrationDTO);
	}

	@Override
	public void insertStudent(StudentDTO student) throws Exception {
		this.studentDAO.insertStudent(student);
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
	public void insertProfile(ProfileDTO profile) throws Exception {
		this.profileDAO.insertProfile(profile);

	}

}
