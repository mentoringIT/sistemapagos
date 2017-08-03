package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.PSPDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@Service
public class PaymentByInstructorService implements IPaymentByInstructorService {
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private PSPDAO pspDAO;

	@Override
	public List<CourseDTO> allCourse() throws Exception {
		return this.courseDAO.select();
	}

	@Override
	public List<StudentDTO> allInstructors() throws Exception {
		return this.studentDAO.select();
	}

	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}

	@Override
	public List<PSPDTO> paymentByInstructor(Integer idStudent, Integer idProduct) throws Exception {
		return this.pspDAO.paymentByStudent(idStudent, idProduct);
	}

	@Override
	public StudentDTO selectStudent(Integer idStudent) throws Exception {
		return studentDAO.selectStudent(idStudent);
	}

	@Override
	public String selectCourseName(Integer idCourse) throws Exception {
		return this.courseDAO.selectName(idCourse).getName();
	}

}
