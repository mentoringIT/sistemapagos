package mx.com.mentoringit.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import mx.com.mentoringit.model.dto.UserDTO;
import mx.com.mentoringit.web.services.IUserService;

@ManagedBean
@SessionScoped
public class UserBean implements IUserBean {

	private IUserService userService;
	private String username;
	private String password;
	private UserDTO user;
	private final HttpServletRequest httpServletRequest;
	private final FacesContext facesContext;

	public UserBean() {
		user = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		facesContext = FacesContext.getCurrentInstance();
		httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
	}

	@Override
	public String userLogin() {
		UserDTO userDTO = new UserDTO();
		String result = "";

		userDTO.setUsername(username);
		userDTO.setPassword(password);

		try {
			user  = userService.userLogin(userDTO);
			if (user != null) {
				httpServletRequest.getSession().setAttribute("userSession", user);
				result = "login";
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ususario y/o contraseña incorectos"));
				result = "fail";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Ususario y/o contraseñas incorectos"));
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