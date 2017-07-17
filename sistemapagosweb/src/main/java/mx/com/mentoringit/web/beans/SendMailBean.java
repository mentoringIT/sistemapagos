package mx.com.mentoringit.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "MbSendMail")
@SessionScoped
public class SendMailBean {
	
	private String from;
	private String subject;
	private String message; 
	private NewInstructorBean instructorBean;
	
	public SendMailBean(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		if(session.getAttribute("object").getClass().isInstance(new NewInstructorBean())){
			instructorBean = (NewInstructorBean)session.getAttribute("object");
			from = instructorBean.getEmail();
			subject = instructorBean.getSubject();	
		}
		
	}

	public String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}



	public void setFrom(String from) {
		this.from = from;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public NewInstructorBean getInstructorBean() {
		return instructorBean;
	}

	public void setInstructorBean(NewInstructorBean instructorBean) {
		this.instructorBean = instructorBean;
	}
	

}
