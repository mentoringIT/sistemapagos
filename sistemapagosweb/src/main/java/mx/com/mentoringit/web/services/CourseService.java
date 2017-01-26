package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.CourseDAO;
import mx.com.mentoringit.model.dao.RegistrationDAO;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

@Service
public class CourseService implements ICourseService {
	
	private CourseDAO courseDAO;
	private RegistrationDAO regDAO;
	

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

	@Override
	public List<CourseDTO> course() throws Exception {		
		return courseDAO.select() ;
	}

	@Override
	public List<StudentDTO> student(Integer id) throws Exception {
		return regDAO.select(id);
	}

	
}
