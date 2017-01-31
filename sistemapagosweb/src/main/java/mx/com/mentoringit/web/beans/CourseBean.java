package mx.com.mentoringit.web.beans;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.ICourseService;


@ManagedBean
@SessionScoped
public class CourseBean {
	
	private Integer idCourse;	
	
	private List<CourseDTO> listaC;	
	private List<StudentDTO> listaA;
	private ICourseService courseService;
		
	

	public CourseBean() {}	
	
	

	public List<StudentDTO> getListaA() {
		selectStudent();
		return listaA;
	}

	public List<CourseDTO> getListaC() {
		selectCourse();
		return listaC;
	}
	
	public ICourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	}

	public Integer getIdCourse() {		
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {		
		this.idCourse = idCourse;
	}

	
	public void selectCourse(){
		try {
			listaC = this.courseService.course();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectStudent(){
		try {
			listaA = this.courseService.student(idCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
