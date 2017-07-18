package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.ProductDAO;
import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@Service
public class ExistingInstructorService implements IExistingInstructorService{
	@Autowired
	private CourseDAO courseDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<CourseDTO> allCourse() throws Exception {
		return this.courseDAO.select() ;
	}

	@Override
	public List<StudentDTO> allInstructors() throws Exception {
		return this.studentDAO.select();
	}

	@Override
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception {
		return this.productDAO.startDate(id, date1, date2);
	}
	

}
