package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

public interface ICourseService {
	public List<CourseDTO> course() throws Exception;
	public List<StudentDTO> student(Integer id) throws Exception;
	public List<StudentDTO> allStudent() throws Exception;
	public List<ProductDTO> dates(int id, String date1, String date2) throws Exception;
	public void paymetStudent(PaymentDTO payment) throws Exception;
}
