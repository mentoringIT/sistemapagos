package mx.com.mentoringit.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import mx.com.mentoringit.model.dto.UserDTO;

@ManagedBean(name="MbSession")
@RequestScoped
public class Session {
	
	private UserDTO userdto;
	private final HttpServletRequest httpServletRequest;
	private final FacesContext facesContext;
	private FacesMessage facesMessage;
	
	public Session(){
		facesContext = FacesContext.getCurrentInstance();		
		httpServletRequest = (HttpServletRequest)facesContext.getExternalContext().getRequest();
		
		if (httpServletRequest.getSession().getAttribute("userSession") != null) {
			userdto = (UserDTO)httpServletRequest.getSession().getAttribute("userSession");
			
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
			httpServletRequest.getSession().setAttribute("userSession", null);
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
