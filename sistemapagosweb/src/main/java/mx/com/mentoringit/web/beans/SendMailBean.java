package mx.com.mentoringit.web.beans;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "MbSendMail")
@ViewScoped
public class SendMailBean {

	private String from;
	private String subject;
	private String message;
	private BodyPart adjunto;
	private NewInstructorBean instructorBean;
	private ExistingInstructorBean existingInsBean;
	private PaymentByInstructorBean byInstructorBean;

	public SendMailBean() {

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		if (session.getAttribute("new") != null) {

			instructorBean = (NewInstructorBean) session.getAttribute("new");
			from = instructorBean.getEmail();
			subject = instructorBean.getSubject();

			adjunto = new MimeBodyPart();
			DataSource ds = new ByteArrayDataSource(instructorBean.getOutputStream().toByteArray(), "application/pdf");
			try {
				adjunto.setDataHandler(new DataHandler(ds));
				adjunto.setFileName("Recibo");
				session.setAttribute("new", null);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (session.getAttribute("existing") != null) {

			existingInsBean = (ExistingInstructorBean) session.getAttribute("existing");
			from = existingInsBean.getFrom();
			subject = existingInsBean.getSubject();

			adjunto = new MimeBodyPart();
			DataSource ds = new ByteArrayDataSource(existingInsBean.getOutputStream().toByteArray(), "application/pdf");
			try {
				adjunto.setDataHandler(new DataHandler(ds));
				adjunto.setFileName("Recibo");
				session.setAttribute("existing", null);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (session.getAttribute("search") != null) {

			byInstructorBean = (PaymentByInstructorBean) session.getAttribute("search");
			from = byInstructorBean.getFrom();
			subject = byInstructorBean.getSubject();
			session.setAttribute("search", null);
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

	public PaymentByInstructorBean getByInstructorBean() {
		return byInstructorBean;
	}

	public void setByInstructorBean(PaymentByInstructorBean byInstructorBean) {
		this.byInstructorBean = byInstructorBean;
	}

}
