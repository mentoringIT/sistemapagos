package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

public interface INewStudentService {
	public List<CourseDTO> allCourse() throws Exception;
	public void insertStudent(StudentDTO student) throws Exception;
	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception;
	public Integer idMax() throws Exception;
	public void insertPayment(PaymentDTO payment) throws Exception;
}
