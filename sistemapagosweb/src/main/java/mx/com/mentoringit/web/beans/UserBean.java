package mx.com.mentoringit.web.beans;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.http.HttpRequest;

import mx.com.mentoringit.model.dto.UserDTO;
import mx.com.mentoringit.web.services.IUserService;

@ManagedBean
@SessionScoped
public class UserBean implements IUserBean, Serializable {
	private final static Logger log = Logger.getLogger(UserBean.class);

	private IUserService userService;
	private HttpSession session;
	private String username;
	private String password;
	
//	private final HttpServletRequest httpServletRequest;
//	private final FacesContext facesContext;

	public UserBean() {
//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
//		facesContext = FacesContext.getCurrentInstance();
//		httpServletRequest = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String userLogin() {
		
		UserDTO userDTO = new UserDTO(),
				user = null;
		String result = "";

		userDTO.setUsername(username);
		userDTO.setPassword(password);

		try {
			user  = userService.userLogin(userDTO);
			if (user != null) {
//				httpServletRequest.getSession().setAttribute("userSession", user);
				session.setAttribute("userSession", user);
				
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