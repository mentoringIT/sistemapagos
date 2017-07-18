package mx.com.mentoringit.web.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.ExistingInstructorBean;
import mx.com.mentoringit.web.services.IExistingInstructorService;

@ManagedBean(name = "MbExistingInstructorController")
@SessionScoped
public class ExistingInstructorController {
	@ManagedProperty(value = "#{MbExistingInstructor}")
	private ExistingInstructorBean existingInsBean;
	
	@ManagedProperty(value = "#{existingInstructorService}")
	private IExistingInstructorService instructorService;
	
	// obtiene todos los cursos
			public List<CourseDTO> selectCourse() {
				try {
					return instructorService.allCourse();
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					log.error(e);
					return null;
				}
			}

			// obtiene todos los alumnos
			public List<StudentDTO> allInstructors() {

				try {
					return instructorService.allInstructors();
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					log.error(e);
					return null;
				}
			}
			
			// obtiene las fechas de inicio
			public void startDates() {

				try {
					existingInsBean.setListaD(instructorService.startDates(existingInsBean.getIdCourse(), existingInsBean.getFormatDate1(), existingInsBean.getFormatDate2()));
					if (existingInsBean.getListaD().size() != 0) {
						existingInsBean.setValidation(true);
					} else {
						existingInsBean.setValidation(false);
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
//					log.error(e);
					existingInsBean.setValidation(false);
				}
			}


	
	/*getters and setters*/
			public ExistingInstructorBean getExistingInsBean() {
				return existingInsBean;
			}
			
			public IExistingInstructorService getInstructorService() {
				return instructorService;
			}
			
			public void setExistingInsBean(ExistingInstructorBean existingInsBean) {
				this.existingInsBean = existingInsBean;
			}
			
			public void setInstructorService(IExistingInstructorService instructorService) {
				this.instructorService = instructorService;
			}
			

}
