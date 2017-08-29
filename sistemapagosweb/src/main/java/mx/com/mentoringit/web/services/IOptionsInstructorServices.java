package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.model.dto.UpdateInstructorDTO;

public interface IOptionsInstructorServices {
	public List<StudentDTO> allInstructors() throws Exception;
	public UpdateInstructorDTO selectInstructor(Integer id) throws Exception;
	public void updateInstructor(UpdateInstructorDTO instructorDTO) throws Exception;

}
