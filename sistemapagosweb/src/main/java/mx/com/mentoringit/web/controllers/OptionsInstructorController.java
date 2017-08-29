package mx.com.mentoringit.web.controllers;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.primefaces.context.RequestContext;

import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.model.dto.UpdateInstructorDTO;
import mx.com.mentoringit.web.beans.OptionsInstructorBean;
import mx.com.mentoringit.web.services.IOptionsInstructorServices;

@ManagedBean(name = "MbOptionsInstructorController")
@RequestScoped
public class OptionsInstructorController implements Serializable {
	private final static Logger log = Logger.getLogger(OptionsInstructorController.class);
	
	@ManagedProperty(value = "#{MbOptionsInstructor}")
	private OptionsInstructorBean optionBean;
	@ManagedProperty(value = "#{optionsInstructorServices}")
	private IOptionsInstructorServices optionServices;

	public OptionsInstructorController(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// obtiene todos los instructores
	public List<StudentDTO> allInstructors() {

		try {
			return optionServices.allInstructors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 log.error(e);
			return null;
		}
	}

	// obtiene todos los instructores
	public void selectInstructor() {

		try {
			UpdateInstructorDTO updateIns = optionServices.selectInstructor(optionBean.getIdInstructor());
			optionBean.setPhone(updateIns.getPhone());
			optionBean.setEmail(updateIns.getEmail());
			optionBean.setTypeStudy(updateIns.getTypeStudy());
			optionBean.setDegree(updateIns.getDegree());
			optionBean.setCedula(updateIns.getCedula());
			optionBean.setCertificate(updateIns.getCertification());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e);

		}

	}
	
	public void update(){
		UpdateInstructorDTO instructorDTO = new UpdateInstructorDTO();
		instructorDTO.setId(optionBean.getIdInstructor());
		instructorDTO.setPhone(optionBean.getPhone());
		instructorDTO.setEmail(optionBean.getEmail());
		instructorDTO.setTypeStudy(optionBean.getTypeStudy());
		instructorDTO.setDegree(optionBean.getDegree());
		instructorDTO.setCedula(optionBean.getCedula());
		instructorDTO.setCertification(optionBean.getCertificate());
		
		try {
			optionServices.updateInstructor(instructorDTO);
			RequestContext.getCurrentInstance().execute("PF('success').show()");
			System.out.println("Actualizado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('fail').show()");
			log.error(e);
			e.printStackTrace();
		}
		
	}

	/* getters and setters */
	public OptionsInstructorBean getOptionBean() {
		return optionBean;
	}

	public IOptionsInstructorServices getOptionServices() {
		return optionServices;
	}

	public void setOptionBean(OptionsInstructorBean optionBean) {
		this.optionBean = optionBean;
	}

	public void setOptionServices(IOptionsInstructorServices optionServices) {
		this.optionServices = optionServices;
	}

}
