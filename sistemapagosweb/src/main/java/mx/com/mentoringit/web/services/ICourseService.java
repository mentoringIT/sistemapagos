package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

public interface ICourseService {
	public List<CourseDTO> course() throws Exception;
	public List<StudentDTO> student(Integer id) throws Exception;

}
