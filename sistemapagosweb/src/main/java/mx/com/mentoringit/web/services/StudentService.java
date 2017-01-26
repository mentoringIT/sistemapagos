package mx.com.mentoringit.web.services;

import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.StudentDTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
	
	public StudentService() {}
	
	private StudentDAO studentDAO;


	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List<StudentDTO> student() throws Exception {				
		return studentDAO.select();
	}

}
