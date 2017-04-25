package mx.com.mentoringit.web.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mx.com.mentoringit.model.dto.UserDTO;

@ManagedBean(name="MbSession")
@RequestScoped
public class Session implements Serializable{
	
	private UserDTO userdto ;
	private HttpSession session;
//	private final HttpServletRequest httpServletRequest;
	private final FacesContext facesContext;
	private FacesMessage facesMessage;
	
	public Session(){
		facesContext = FacesContext.getCurrentInstance();		
//		httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//		httpServletRequest.getSession().getAttribute("userSession") != null
		if (session.getAttribute("userSession") != null) {
			userdto = (UserDTO)session.getAttribute("userSession");
			
		} else {			
			NavigationHandler navigHandler = facesContext.getApplication().getNavigationHandler();
			facesMessage=new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario no se ha logueado", null);
			facesContext.addMessage(null, facesMessage);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			navigHandler.handleNavigation(facesContext, null, "/index.xhtml?faces-redirect=true");
		}
	}
	
	public void cerrarSession() {

		try {
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//			httpServletRequest.getSession().setAttribute("userSession", null);
			session.setAttribute("userSession", null);
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			context.redirect(context.getRequestContextPath() + "/index.xhtml");
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

	public UserDTO getUserdto() {
		return userdto;
	}

	public void setUserdto(UserDTO userdto) {
		this.userdto = userdto;
	}

}
