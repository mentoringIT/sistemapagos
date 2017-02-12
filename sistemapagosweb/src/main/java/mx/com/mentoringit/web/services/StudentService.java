package mx.com.mentoringit.web.services;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.PSPDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
	
	private CourseDAO courseDAO;
	private StudentDAO studentDAO;
	private ProductDAO productDAO;
	private PSPDAO pspDAO;

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
	
	
	public PSPDAO getPspDAO() {
		return pspDAO;
	}
	@Autowired
	public void setPspDAO(PSPDAO pspDAO) {
		this.pspDAO = pspDAO;
	}
	

	@Override
	public List<CourseDTO> allCourse() throws Exception {
		return this.courseDAO.select();
	}
	@Override
	public List<StudentDTO> allStudent() throws Exception {
		return this.studentDAO.select();
	}
	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}

	@Override
	public List<PSPDTO> paymentByStudent(Integer idStudent, Integer idProduct) throws Exception {
		return this.pspDAO.paymentByStudent(idStudent, idProduct);
	}

	@Override
	public String selectName(Integer idStudent) throws Exception {
		return studentDAO.selectName(idStudent).getName();
	}

}
