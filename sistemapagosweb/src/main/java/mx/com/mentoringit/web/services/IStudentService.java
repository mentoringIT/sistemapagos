package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.StudentDTO;

public interface IStudentService {
	public List<StudentDTO> student() throws Exception;

}
