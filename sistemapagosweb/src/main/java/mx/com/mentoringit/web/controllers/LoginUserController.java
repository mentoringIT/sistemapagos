package mx.com.mentoringit.web.controllers;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import mx.com.mentoringit.model.dto.UserDTO;
import mx.com.mentoringit.web.beans.ILoginUserBean;
import mx.com.mentoringit.web.beans.LoginUserBean;
import mx.com.mentoringit.web.services.IUserService;

@ManagedBean(name = "MbLoginUserController")
@SessionScoped
public class LoginUserController implements ILoginUserBean, Serializable{
	private final static Logger log = Logger.getLogger(LoginUserController.class);
	
	@ManagedProperty(value = "#{userService}")
	private IUserService userService;
	
	@ManagedProperty(value = "#{MbLoginUserBean}")
	private LoginUserBean lub;
	
	public LoginUserController(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String userLogin() {

		UserDTO userDTO = new UserDTO(), user = null;
		String result = "";

		userDTO.setUsername(lub.getUsername());
		userDTO.setPassword(lub.getPassword());

		try {
			user = userService.userLogin(userDTO);
			if (user != null) {
				// httpServletRequest.getSession().setAttribute("userSession",
				// user);
				lub.getSession().setAttribute("userSession", user);

				result = "login";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ususario y/o contraseña incorectos"));
				result = "fail";
			}

		} catch (Exception e) {
			log.error(e);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ususario y/o contraseña incorectos"));
			result = "fail";

		}
		return result;
	}

	
	
	
	
	public void messageUser() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El campo usuario es obligatorio"));
	}

	public void messageKey() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "El campo clave es obligatorio"));
	}


	//getters and setters
	public IUserService getUserService() {
		return userService;
	}

	public LoginUserBean getLub() {
		return lub;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setLub(LoginUserBean lub) {
		this.lub = lub;
	}
}
