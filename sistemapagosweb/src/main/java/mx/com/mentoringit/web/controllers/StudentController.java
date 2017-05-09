package mx.com.mentoringit.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.StudentBean;
import mx.com.mentoringit.web.services.IStudentService;

@ManagedBean(name = "MbStudentController")
@RequestScoped
public class StudentController implements Serializable {

	@ManagedProperty(value = "#{studentService}")
	private IStudentService studentService;

	public StudentController() {
	}

	// obtiene todos los cursos
	public List<CourseDTO> courses() {
		try {
			return studentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// obtiene todos los alumnos
	public List<StudentDTO> students() {
		try {
			return studentService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// obtiene las fechas de inicio de los productos(cursos) PENDIENTE
	public List<ProductDTO> startDates(Integer id, String date1, String date2) {
		try {
			return studentService.startDates(id, date1, date2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// getters and setters
	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

}
