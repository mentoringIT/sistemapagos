package mx.com.mentoringit.web.beans;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import mx.com.mentoringit.model.dto.Correo;
import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.IStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class StudentBean {

	private IStudentService studentService;

	private List<CourseDTO> listaC;
	private List<StudentDTO> listaA;
	private List<ProductDTO> listaD;
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> temListaPsp = new ArrayList<PSPDTO>();
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;

	private Integer idCourse;
	private Integer idStudent;
	private Integer idProduct;
	private Date date1 = new Date();
	private Date date2 = new Date();
	private String formatDate1;
	private String formatDate2;
	private String nameStudent;
	private Double totalCourse = 0.0;
	private Double totalPayment = 0.0;
	private Double remaining = 0.0;

	private String from;
	private String subject;
	private String message;

	// obtiene todos los cursos
	public void courses() {
		try {
			listaC = this.studentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene todos los alumnos
	public void students() {
		try {
			listaA = this.studentService.allStudent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene las fechas de inicio de los productos(cursos)
	public void startDates() {
		try {
			listaD = this.studentService.startDates(idCourse, getFormatDate1(), getFormatDate2());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// obtiene todos los pagos de un alumno y calcula los totales
	public String paymentsByStudent() {
		this.totalCourse = 0.0;
		this.totalPayment = 0.0;
		this.remaining = 0.0;

		try {
			listaPsp = this.studentService.paymentByStudent(idStudent, idProduct);

			if (listaPsp.size() != 0) {
				for (int i = 0; i < listaPsp.size(); i++) {
					if (i == 0) {

						this.totalCourse = listaPsp.get(i).getTotalCourse();
						this.nameStudent = listaPsp.get(i).getStudentName();
					}
					this.totalPayment = this.totalPayment + listaPsp.get(i).getAmountPayment();
				}
			} else {
				this.nameStudent = this.studentService.selectStudent(idStudent).getName();
			}

			this.remaining = this.totalCourse - this.totalPayment;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "consult";
	}

	// crea los tikets de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double totalPayment = 0.0;

		try {

			for (int i = 0; i < this.temListaPsp.size(); i++) {

				Double remaining2;
				totalPayment = totalPayment + this.temListaPsp.get(i).getAmountPayment();
				remaining2 = this.temListaPsp.get(i).getTotalCourse() - totalPayment;

				report.setStudentName(this.temListaPsp.get(i).getStudentName());
				report.setCourseName(this.temListaPsp.get(i).getCourseName());
				report.setNumPayment(this.temListaPsp.get(i).getNumPayment().toString());
				report.setAmountPayment(this.temListaPsp.get(i).getAmountPayment().toString());
				report.setDatePayment(this.temListaPsp.get(i).getDatePayment().toString());
				report.setTypePayment(this.temListaPsp.get(i).getTypePayment());
				report.setRemaining(remaining2.toString());
				report.setTotalCourse(this.temListaPsp.get(i).getTotalCourse().toString());

				listaR.add(report);

				File jasper = new File(
						FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
						new JRBeanCollectionDataSource(listaR));
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						"C:\\Users\\ed\\git\\sistemapagos\\sistemapagosweb\\src\\main\\webapp\\PDF\\pago_"
								+ this.temListaPsp.get(i).getNumPayment() + ".pdf");
				listaR.clear();

			}
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tiket(s) generado(s)"));

			System.out.println("hecho");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Tiket generado"));
			e.printStackTrace();
		}
	}

	// establece los valores para el envio del correo
	public void sendMail() {
		Correo c = new Correo();
		c.setPassword("lbmenluywbcytxeq");
		c.setUserEmail("edflores830@gmail.com");
		c.setSubject(this.subject);
		c.setFrom(this.from.trim());
		c.setMessage(this.message);

		if (controller(c)) {
			System.out.println("Envio exitoso");
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			try {
				context.redirect(context.getRequestContextPath() + "/menuAlumnos.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Envio fallido");
			ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
			try {
				context.redirect(context.getRequestContextPath() + "/pagosPorAlumno.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// controla el envio del correo
	public boolean controller(Correo c) {

		try {
			Properties p = new Properties();
			p.put("mail.smtp.host", "smtp.gmail.com");
			p.setProperty("mail.smtp.starttls.enable", "true");
			p.setProperty("mail.smtp.port", "587");
			p.setProperty("mail.smtp.user", c.getUserEmail());
			p.setProperty("mail.smtp.auth", "true");

			Session s = Session.getDefaultInstance(p, null);
			BodyPart texto = new MimeBodyPart();
			BodyPart adjunto; 
			MimeMultipart m = new MimeMultipart();
			
			texto.setText(c.getMessage());
			
			File file = new File("C:\\Users\\ed\\git\\sistemapagos\\sistemapagosweb\\src\\main\\webapp\\PDF");
			File []files = file.listFiles();
			
			for (File f : files) {				
				adjunto = new MimeBodyPart();			
				
				if (f.exists()) {
					
					adjunto.setDataHandler(new DataHandler(new FileDataSource(f.getAbsolutePath())));
					adjunto.setFileName(f.getName());
					m.addBodyPart(adjunto);
					
				}
			}
			
			m.addBodyPart(texto);

			MimeMessage mensaje = new MimeMessage(s);
			mensaje.setFrom(new InternetAddress(c.getUserEmail()));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(c.getFrom()));
			mensaje.setSubject(c.getSubject());
			mensaje.setContent(m);

			Transport t = s.getTransport("smtp");
			t.connect(c.getUserEmail(), c.getPassword());
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();
			
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}
	}

	// metodos getters y setters

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}

	public List<CourseDTO> getListaC() {
		courses();
		return listaC;
	}

	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
	}

	public List<StudentDTO> getListaA() {
		students();
		return listaA;
	}

	public void setListaA(List<StudentDTO> listaA) {
		this.listaA = listaA;
	}

	public List<ProductDTO> getListaD() {
		return listaD;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public String getFormatDate1() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate1 = format.format(date1);
		return formatDate1;
	}

	public void setFormatDate1(String formatDate1) {
		this.formatDate1 = formatDate1;
	}

	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		formatDate2 = format.format(date2);
		return formatDate2;
	}

	public void setFormatDate2(String formatDate2) {
		this.formatDate2 = formatDate2;
	}

	public List<PSPDTO> getFilterPayments() {
		return filterPayments;
	}

	public void setFilterPayments(List<PSPDTO> filterPayments) {
		this.filterPayments = filterPayments;
	}

	public PSPDTO getDetail() {
		return detail;
	}

	public void setDetail(PSPDTO detail) {
		this.detail = detail;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public List<PSPDTO> getListaPsp() {
		paymentsByStudent();
		return listaPsp;
	}

	public void setListaPsp(List<PSPDTO> listaPsp) {
		this.listaPsp = listaPsp;
	}

	public Double getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(Double totalCourse) {
		this.totalCourse = totalCourse;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}

	public Double getRemaining() {
		return remaining;
	}

	public void setRemaining(Double remaining) {
		this.remaining = remaining;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public List<PSPDTO> getTemListaPsp() {
		return temListaPsp;
	}

	public void setTemListaPsp(List<PSPDTO> temListaPsp) {
		this.temListaPsp = temListaPsp;
	}

	public String getFrom() {
		try {
			this.from = (this.studentService.selectStudent(this.idStudent)).getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		try {
			this.subject = "Recibos de pagos realizados  para el curso "+
							this.studentService.selectCourseName(this.idCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
