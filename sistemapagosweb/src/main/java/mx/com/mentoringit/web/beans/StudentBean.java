package mx.com.mentoringit.web.beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.IStudentService;

@ManagedBean
@SessionScoped
public class StudentBean {
	private List<StudentDTO> listaA;
	private IStudentService studentService;
	
	public StudentBean() {}
		
	public List<StudentDTO> getListaA() {
		try {
			listaA = this.studentService.student();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaA;
	}

	public IStudentService getStudentService() {
		return studentService;
	}


	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

}
