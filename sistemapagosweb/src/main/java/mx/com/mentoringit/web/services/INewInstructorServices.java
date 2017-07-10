package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ProfileDTO;
import mx.com.mentoringit.model.dto.RegistrationDTO;
import mx.com.mentoringit.model.dto.StudentDTO;

public interface INewInstructorServices {
	public List<CourseDTO> allCourse() throws Exception;

	public List<ProductDTO> startDates(int id, String date1, String date2) throws Exception;

	public String selectCourseName(Integer idCourse) throws Exception;

	public void insertStudent(StudentDTO student) throws Exception;

	public void insertRegister(RegistrationDTO registrationDTO) throws Exception;

	public Integer idMax() throws Exception;

	public void insertPayment(PaymentDTO payment) throws Exception;
	
	public void insertProfile(ProfileDTO profile) throws Exception;

}
