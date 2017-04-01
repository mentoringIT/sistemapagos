package mx.com.mentoringit.web.beans;

import java.util.List;
import java.util.Properties;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProductDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.services.INewStudentService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@SessionScoped
public class NewStudentBean {
	
	private INewStudentService newStudentService;
	private List<CourseDTO> listaC;
	private List<ProductDTO> listaD;
	
	private String from;
	private String subject;
	private String message;
		
	private String name;
	private String pLastName;
	private String mLastName;
	private String completeName;
	private String tel;
	private String email;
	private Date paymentDate = new Date();
	private String formatDatePayment;
	private Double total = 0.0;
	private Double amount = 0.0;
	private Integer num_payment = 1;
	private String type_payment;
	private Integer idCourse;
	private Integer idProduct;
	private Integer idStudent;
	private Date date1 = new Date();
	private Date date2 = new Date();
	private String formatDate1;
	private String formatDate2;
	
	
	//obtiene todos los cursos
	public void selectCourse() {
		try {
			listaC = this.newStudentService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inserta al estudiante en la base
	public String inStudent(){
		StudentDTO student = new StudentDTO();
		
		student.setEmail(this.email);
		student.setName(getCompleteName());
		student.setPhone(this.tel);
		
		try {
			this.newStudentService.insertStudent(student);
			this.idStudent = this.newStudentService.idMax();
			insertPayment();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "next";
	}
	
	// obtiene las fechas de inicio
		public void startDates() {

			try {
				listaD = this.newStudentService.startDates(this.idCourse, getFormatDate1(), getFormatDate2());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// inserta el pago en la base
		public void insertPayment() {
			PaymentDTO payment = new PaymentDTO();

			payment.setStudent_id(this.idStudent);
			payment.setCourse_id(this.idCourse);
			payment.setNum_payment(this.num_payment);
			payment.setAmount_payment(this.amount);
			payment.setType_payment(this.type_payment);
			payment.setDate_payment(this.paymentDate);
			payment.setTotal_course(this.total);
			payment.setProduct_id(this.idProduct);

			try {
				this.newStudentService.insertPayment(payment);
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Info","Pago registrado con exito"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Warning","No se ha podido registrar el pago"));
				e.printStackTrace();
			}

		}

		//crea el tiket de pago
		
		public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double remaining = 0.0;
		
		remaining = total - amount; 

		try {
			report.setStudentName(this.getCompleteName());
			report.setCourseName(this.newStudentService.selectCourseName(this.idCourse));
			report.setNumPayment(this.num_payment.toString());
			report.setAmountPayment(this.amount.toString());
			report.setDatePayment(getFormatDatePayment());
			report.setTypePayment(this.type_payment);
			report.setRemaining(remaining.toString());
			report.setTotalCourse(this.total.toString());

			listaR.add(report);
			
			File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),null,new JRBeanCollectionDataSource(listaR));
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"C:\\Users\\ed\\git\\sistemapagos\\sistemapagosweb\\src\\main\\webapp\\PDF\\pago.pdf");
//			byte[] b = JasperExportManager.exportReportToPdf(jasperPrint); 
//            HttpServletResponse res = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//            res.setContentType("application/pdf");
//            
//           res.setHeader("Content-disposition", "inline;filename=arquivo.pdf");
//            
//            res.getOutputStream().write(b);
//            res.getCharacterEncoding();
			
//            FacesContext.getCurrentInstance().responseComplete();
            
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info","Tiket generado"));
            listaR.clear();
			System.out.println("echo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info","Tiket generado"));
			e.printStackTrace();
		}
	}
		
		//controla el envio del correo
		public boolean controller(Correo c){
			
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
		
		//establece los valores para el envio del correo
		public void sendMail(){
			Correo c = new Correo();
			c.setPassword("lbmenluywbcytxeq");
			c.setUserEmail("edflores830@gmail.com");
			c.setSubject(this.subject);
			c.setFrom(this.from.trim());
			c.setMessage(this.message);
						
			if(controller(c)){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Info","Envio exitoso"));
				System.out.println("Envio exitoso");
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				try {
					context.redirect(context.getRequestContextPath() + "/menuAlumnos.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
						"Info","Envio fallido"));
				System.out.println("Envio fallido");
				ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
				try {
					context.redirect(context.getRequestContextPath() + "/pagoAlumnoNuevo.xhtml");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
		//elimina del pdf creado
		public void deletePdf(){
			File fi = new File("C:\\Users\\ed\\git\\sistemapagos\\sistemapagosweb\\PDF\\pagos.pdf");
			fi.delete();
		}
		
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpLastName() {
		return pLastName;
	}
	public void setpLastName(String pLastName) {
		this.pLastName = pLastName;
	}
	public String getmLastName() {
		return mLastName;
	}
	public void setmLastName(String mLastName) {
		this.mLastName = mLastName;
	}	
	
	public String getCompleteName() {
		this.completeName = this.name + " " +this.pLastName + " " + this.mLastName;
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getFormatDatePayment() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDatePayment = format.format(paymentDate);
		return formatDatePayment;
	}
	public void setFormatDatePayment(String formatDatePayment) {
		this.formatDatePayment = formatDatePayment;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getNum_payment() {
		return num_payment;
	}
	public void setNum_payment(Integer num_payment) {
		this.num_payment = num_payment;
	}
	public String getType_payment() {
		return type_payment;
	}
	
	public void setType_payment(String type_payment) {
		this.type_payment = type_payment;
	}
	public List<CourseDTO> getListaC() {
		selectCourse();
		return listaC;
	}
	public void setListaC(List<CourseDTO> listaC) {
		this.listaC = listaC;
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
		this.formatDate1 = format.format(date1);
		return formatDate1;
	}

	public void setFormatDate1(String formatDate1) {
		this.formatDate1 = formatDate1;
	}

	public String getFormatDate2() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.formatDate2 = format.format(date2);
		return formatDate2;
	}

	public void setFormatDate2(String formatDate2) {
		this.formatDate2 = formatDate2;
	}




	public List<ProductDTO> getListaD() {
		return listaD;
	}

	public void setListaD(List<ProductDTO> listaD) {
		this.listaD = listaD;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}
	
	public INewStudentService getNewStudentService() {
		return newStudentService;
	}
	public void setNewStudentService(INewStudentService newStudentService) {
		this.newStudentService = newStudentService;
	}

	public String getFrom() {
		try {
			this.from = (this.newStudentService.selectStudent(this.idStudent)).getEmail();
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
			this.subject = "Recibo de pago No. "+ this.num_payment+" para el curso "+
							this.newStudentService.selectCourseName(this.idCourse);
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
