package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
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

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.ExistingStudentBean;
import mx.com.mentoringit.web.services.ICourseService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbExistingStudentController")
@SessionScoped
public class ExistingStudentController {
	private final static Logger log = Logger.getLogger(ExistingStudentController.class);
	
	@ManagedProperty(value = "#{MbExistingStudentBean}")
	private ExistingStudentBean esb;
	
	@ManagedProperty(value = "#{courseService}")
	private ICourseService courseService;
	
	public ExistingStudentController(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// obtiene todos los cursos
		public List<CourseDTO> selectCourse() {
			try {
				return courseService.allCourse();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
				return null;
			}
		}
	
		// obtiene todos los alumnos
		public List<StudentDTO> selectAllStudent() {

			try {
				return courseService.allStudent();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
				return null;
			}
		}

		// obtiene las fechas de inicio
		public void startDates() {

			try {
				esb.setListaD(courseService.startDates(esb.getIdCourse(), esb.getFormatDate1(), esb.getFormatDate2()));
				if (esb.getListaD().size() != 0) {
					esb.setValidation(true);
				} else {
					esb.setValidation(false);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
				esb.setValidation(false);
			}
		}
		
		// muestra los totales
		public void totals() {
			esb.setTotalCourse(0.0);
			esb.setTotalPayment(0.0);
			esb.setRemaining(0.0);
			esb.setAmount(0.0);
			try {

				List<PaymentDTO> listaP;
				listaP = courseService.selectPayment(esb.getIdStudent(), esb.getIdProduct());

				if (listaP.size() != 0) {
					for (int i = 0; i < listaP.size(); i++) {
						if (i == 0) {

							esb.setTotalCourse(listaP.get(i).getTotal_course());
							esb.setTotal(esb.getTotalCourse());
						}
						esb.setTotalPayment(esb.getTotalPayment() + listaP.get(i).getAmount_payment());
						esb.setNum_payment(listaP.get(i).getNum_payment());

					}
					esb.setNum_payment(esb.getNum_payment().intValue() + 1);
					esb.setRemaining(esb.getTotalCourse() - esb.getTotalPayment());

				} else {
					esb.setNum_payment(1);
					esb.setTotal(0.0);
					esb.setAmount(0.0);
				}

				status(esb.getTotalCourse().doubleValue(), esb.getTotalPayment().doubleValue());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e);
			}
		}

		private void status(double n1, double n2) {
			RequestContext rc = RequestContext.getCurrentInstance();
			if (n1 == n2 && n2 != 0.0) {
				esb.setPaymentStatus(true);
				rc.execute("PF('status').show()");

			} else {
				esb.setPaymentStatus(false);
				rc.update("form1");
			}
		}
		
		// crea el tiket de pago
		public void createReport() {
			List<ReportData> listaR = new ArrayList<ReportData>();
			ReportData report = new ReportData();
			Double resto = 0.0;
			boolean flag = false;

			if (esb.getRemaining().doubleValue() != 0.0) {
				resto = esb.getRemaining() - esb.getAmount();
			} else {
				resto = esb.getTotal() - esb.getAmount();
			}
			
			if(esb.getTotal().equals(esb.getTotalPayment())){			
					flag = true;
					esb.setPaymentStatus(true);
			}

			try {				
				esb.setFrom((courseService.selectStudent(esb.getIdStudent())).getEmail());
				
				esb.setSubject("Recibo de pago No. " + esb.getNum_payment() + " para el curso "
						+ courseService.selectCourseName(esb.getIdCourse()));					
				
				if (esb.getIdProduct() != null) {
					if (!flag) {
						report.setStudentName((courseService.selectStudent(esb.getIdStudent())).getName());
						report.setCourseName(courseService.selectCourseName(esb.getIdCourse()));
						report.setNumPayment(esb.getNum_payment().toString());
						report.setAmountPayment(esb.getAmount().toString());
						report.setDatePayment(esb.getDate_payment2());
						report.setTypePayment(esb.getType_payment());
						report.setRemaining(resto.toString());
						report.setTotalCourse(esb.getTotal().toString());

						listaR.add(report);

						File jasper = new File(
								FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
						JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
								new JRBeanCollectionDataSource(listaR));
						esb.setOutputStream(new ByteArrayOutputStream());
						JasperExportManager.exportReportToPdfStream(jasperPrint, esb.getOutputStream());

						InputStream is = new ByteArrayInputStream(esb.getOutputStream().toByteArray());
						esb.setMedia(new DefaultStreamedContent(is, "application/pdf", "Recibo.pdf"));

						listaR.clear();
						RequestContext rc = RequestContext.getCurrentInstance();
						rc.execute("PF('detail').show()");
					} else {
						RequestContext.getCurrentInstance().execute("PF('status').show()");
					}
				} else {
					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('selecionar').show()");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('genPago').show()");
				log.error(e);

			}

		}

		
		// inserta el pago en la base
		public void insertPayment() {
			PaymentDTO payment = new PaymentDTO();
			PaymentDTO pay = new PaymentDTO();
			List<PaymentDTO> listaP;

			Double totalC = 0.0;
			Double totalP = 0.0;
			Double restante = 0.0;

			try {
				if ((esb.getAmount().doubleValue() > esb.getTotal().doubleValue())
						|| ((esb.getAmount().doubleValue() > esb.getRemaining().doubleValue())
								&& (esb.getRemaining().doubleValue() != 0.0))) {
					RequestContext.getCurrentInstance().execute("PF('invalidPayment').show()");
				} else {
					listaP = courseService.selectPayment(esb.getIdStudent(), esb.getIdProduct());

					if (!listaP.isEmpty()) {
						for (PaymentDTO p : listaP) {
							pay = p;
							totalC = p.getTotal_course();
							totalP = totalP + p.getAmount_payment();
						}
						restante = totalC - (totalP + esb.getAmount());
					} else {
						esb.setTotalCourse(esb.getTotal());
						esb.setTotalPayment(esb.getAmount());
						esb.setRemaining(esb.getTotalCourse() - esb.getTotalPayment());
					}

//					if (!pay.getTotal_course().equals(this.totalPayment)) {
						payment.setStudent_id(esb.getIdStudent());
						payment.setCourse_id(esb.getIdCourse());
						payment.setNum_payment(esb.getNum_payment());
						payment.setAmount_payment(esb.getAmount());
						payment.setType_payment(esb.getType_payment());
						payment.setDate_payment(esb.getDate_payment());
						payment.setTotal_course(esb.getTotal());
						payment.setProduct_id(esb.getIdProduct());

						if (pay.getNum_payment() != null) {
							esb.setTotalCourse(totalC);
							esb.setTotalPayment(totalP + esb.getAmount().doubleValue());
							esb.setRemaining(restante);
						}

						courseService.insertPayment(payment);
						esb.setAmount(0.0);
						esb.setNum_payment(esb.getNum_payment().intValue() + 1);
						RequestContext rc = RequestContext.getCurrentInstance();
						rc.execute("PF('regExito').show()");
//					} else {
//						RequestContext.getCurrentInstance().execute("PF('status').show()");
//					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('regFallido').show()");
				log.error(e);
			}

		}
		
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

				DataSource ds = new ByteArrayDataSource(esb.getOutputStream().toByteArray(), "application/pdf");
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
				log.error(e);
				return false;
			}
		}

		// establece los valores para el envio del correo
		public void sendMail() {
			Correo c = new Correo();
			c.setPassword("Zaq12wsx123");
			c.setUserEmail("contacto@mentoringit.com.mx");
			c.setSubject(esb.getSubject());
			c.setFrom(esb.getFrom().trim());
			c.setMessage(esb.getMessage());

			if (controller(c)) {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('success').show()");
			} else {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('fail').show()");
			}

		}


	
	
	//getters and setters
	public ExistingStudentBean getEsb() {
		return esb;
	}

	public ICourseService getCourseService() {
		return courseService;
	}

	public void setEsb(ExistingStudentBean esb) {
		this.esb = esb;
	}

	public void setCourseService(ICourseService courseService) {
		this.courseService = courseService;
	} 
	
	
	
	
}
