package mx.com.mentoringit.web.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.StudentDAO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.model.dto.UpdateInstructorDTO;

@Service
public class OptionsInstructorServices implements IOptionsInstructorServices{
	
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<StudentDTO> allInstructors() throws Exception {
		return this.studentDAO.select();
	}

	@Override
	public UpdateInstructorDTO selectInstructor(Integer id) throws Exception { 
		return studentDAO.selectInstructor(id);
	}

	@Override
	public void updateInstructor(UpdateInstructorDTO instructorDTO) throws Exception {
		this.studentDAO.updateInstructor(instructorDTO);		
	}

}
