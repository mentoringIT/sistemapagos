package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

public interface IExistingInstructorService {
	public List<CourseDTO> allCourse() throws Exception;

	public List<StudentDTO> allInstructors() throws Exception;

	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception;

	public List<PaymentDTO> selectPayment(Integer idStudent, Integer idProduct) throws Exception;

	public StudentDTO selectStudent(Integer idStudent) throws Exception;

	public void insertPayment(PaymentDTO payment) throws Exception;

	public String selectCourseName(Integer idCourse) throws Exception;

}
