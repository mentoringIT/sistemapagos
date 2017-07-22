package mx.com.mentoringit.web.beans;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "MbSendMail")
@SessionScoped
public class SendMailBean {
	
	private String from;
	private String subject;
	private String message;
	private BodyPart adjunto;
	private NewInstructorBean instructorBean;
	private ExistingInstructorBean existingInsBean;
	
	public SendMailBean(){
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		
		if(session.getAttribute("object").getClass().isInstance(new NewInstructorBean())){
			System.out.println("new instructor");
			instructorBean = (NewInstructorBean)session.getAttribute("object");
			from = instructorBean.getEmail();
			subject = instructorBean.getSubject();
			
			adjunto = new MimeBodyPart();
			DataSource ds = new ByteArrayDataSource( instructorBean.getOutputStream().toByteArray(), "application/pdf");
			try {
				adjunto.setDataHandler(new DataHandler(ds));
				adjunto.setFileName("Recibo");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(session.getAttribute("object").getClass().isInstance(new ExistingInstructorBean())){
			System.out.println("existing instructor");
			existingInsBean = (ExistingInstructorBean)session.getAttribute("object");
			from = existingInsBean.getFrom();
			subject = existingInsBean.getSubject();
			
			adjunto = new MimeBodyPart();
			DataSource ds = new ByteArrayDataSource( existingInsBean.getOutputStream().toByteArray(), "application/pdf");
			try {
				adjunto.setDataHandler(new DataHandler(ds));
				adjunto.setFileName("Recibo");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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

	

	public BodyPart getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(BodyPart adjunto) {
		this.adjunto = adjunto;
	}

	public NewInstructorBean getInstructorBean() {
		return instructorBean;
	}

	public void setInstructorBean(NewInstructorBean instructorBean) {
		this.instructorBean = instructorBean;
	}

	public ExistingInstructorBean getExistingInsBean() {
		return existingInsBean;
	}

	public void setExistingInsBean(ExistingInstructorBean existingInsBean) {
		this.existingInsBean = existingInsBean;
	}
	

}
