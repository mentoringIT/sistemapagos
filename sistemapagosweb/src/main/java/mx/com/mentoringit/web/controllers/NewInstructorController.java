package mx.com.mentoringit.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.web.beans.NewInstructorBean;
import mx.com.mentoringit.web.services.INewInstructorServices;

@ManagedBean(name = "NewInstructorController")
@SessionScoped
public class NewInstructorController implements Serializable {
	@ManagedProperty(value = "#{newIntructorService}")
	private INewInstructorServices newIntructorService;

	@ManagedProperty(value = "#{MbNewInstructorBean}")
	private NewInstructorBean instructorBean;

	/* metodos */

	/* obtiene todos los cursos */
	public List<CourseDTO> allCourses() {
		try {
			return newIntructorService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// obtiene las fechas de inicio
	public void startDates() {

		try {
			instructorBean.setListaD(newIntructorService.startDates(instructorBean.getIdCourse(), 
					instructorBean.getFormatDate1(), instructorBean.getFormatDate2()));
			if (instructorBean.getListaD().size() != 0) {
				instructorBean.setValidation(true);
			} else {
				instructorBean.setValidation(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			instructorBean.setValidation(true);
		}
	}

	/* getters and setters */
	public INewInstructorServices getNewIntructorService() {
		return newIntructorService;
	}

	public void setNewIntructorService(INewInstructorServices newIntructorService) {
		this.newIntructorService = newIntructorService;
	}

	public NewInstructorBean getInstructorBean() {
		return instructorBean;
	}

	public void setInstructorBean(NewInstructorBean instructorBean) {
		this.instructorBean = instructorBean;
	}

}
