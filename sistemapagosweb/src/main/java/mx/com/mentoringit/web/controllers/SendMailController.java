package mx.com.mentoringit.web.controllers;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.primefaces.context.RequestContext;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.web.beans.SendMailBean;

@ManagedBean(name = "MbSendMailController")
public class SendMailController {
	
	@ManagedProperty(value = "#{MbSendMail}")
	private SendMailBean mailBean; 
	
	
	
	
	// controla el envio del correo
	private boolean controller(Correo c) {

		try {
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", "gator4105.hostgator.com"); // Depende
																			// del
																			// servidor
			props.setProperty("mail.smtp.starttls.enable", "true"); // Depende
																	// del
																	// servidor
			props.setProperty("mail.smtp.port", "587"); // Puede ser otro puerto
			props.setProperty("mail.smtp.user", "contacto@mentoringit.com.mx");
			props.setProperty("mail.smtp.auth", "true"); // Depende del servidor

			Session s = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(c.getUserEmail(), c.getPassword());
				}
			});

			BodyPart texto = new MimeBodyPart();
			BodyPart adjunto;
			MimeMultipart m = new MimeMultipart();

			texto.setText(c.getMessage());

			adjunto = new MimeBodyPart();
			DataSource ds = new ByteArrayDataSource( mailBean.getInstructorBean().getOutputStream().toByteArray(), "application/pdf");
			adjunto.setDataHandler(new DataHandler(ds));
			adjunto.setFileName("Recibo");
			m.addBodyPart(adjunto);

			m.addBodyPart(texto);

			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUserEmail()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
			mensaje.setSubject(c.getSubject());
			mensaje.setContent(m,"text/html; charset=utf-8");

			Transport t = s.getTransport("smtp");
			t.connect(c.getUserEmail(), c.getPassword());
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();

			return true;
		} catch (Exception e) {
//			log.error(e);
			return false;
		}
	}

	// establece los valores para el envio del correo
	public void sendMail() {
		Correo c = new Correo();
		c.setPassword("Zaq12wsx123");
		c.setUserEmail("contacto@mentoringit.com.mx");
		c.setSubject(mailBean.getSubject());
		c.setFrom(mailBean.getFrom());
		c.setMessage(mailBean.getMessage());

		if (controller(c)) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MbExistingStudentBean", null);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MbNewStudent", null);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MbStudentList", null);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MbNewInstructorBean", null);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("MbSendMail", null);
			
			
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('success').show()");
		} else {
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('fail').show()");
		}

	}

	public SendMailBean getMailBean() {
		return mailBean;
	}

	public void setMailBean(SendMailBean mailBean) {
		this.mailBean = mailBean;
	}


}
