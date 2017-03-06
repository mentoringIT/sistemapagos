package mx.com.mentoringit.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.com.mentoringit.model.dto.UserDTO;
import mx.com.mentoringit.web.services.IUserService;


@ManagedBean
@SessionScoped
public class UserBean implements IUserBean{

	private IUserService userService;
	private String username;
	private String password;
	
	public UserBean() {
	}
	
	@Override
	public String userLogin() {
		
		String result = "";
		try {
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(username);
			userDTO.setPassword(password);
			userService.userLogin(userDTO);
			result ="login";
		} catch (Exception e) {
			e.printStackTrace();
			result = "fail";
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"","Ususario y/o contraseña son incorectos"));
		}
		return result;
	}

	public IUserService getUserService() {
		return userService;
	}
	
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}