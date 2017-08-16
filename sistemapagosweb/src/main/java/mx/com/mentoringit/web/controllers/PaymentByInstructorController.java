package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.primefaces.context.RequestContext;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.PaymentByInstructorBean;
import mx.com.mentoringit.web.services.IPaymentByInstructorService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbPaymentByInstructorController")
@SessionScoped
public class PaymentByInstructorController implements Serializable {
	private final static Logger log = Logger.getLogger(PaymentByInstructorController.class);

	@ManagedProperty(value = "#{paymentByInstructorService}")
	private IPaymentByInstructorService instructorService;

	@ManagedProperty(value = "#{MbPaymentByInstructor}")
	private PaymentByInstructorBean byInstructorBean;

	public PaymentByInstructorController() {
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// obtiene todos los cursos
	public List<CourseDTO> courses() {
		try {
			return instructorService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			return null;
		}
	}

	// obtiene todos los instructores
	public List<StudentDTO> allInstructors() {

		try {
			return instructorService.allInstructors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			return null;
		}
	}

	// obtiene las fechas de inicio de los productos(cursos)
	public void startDates() {
		try {
			byInstructorBean.setListaD(instructorService.startDates(byInstructorBean.getIdCourse(),
					byInstructorBean.getFormatDate1(), byInstructorBean.getFormatDate2()));
			if (byInstructorBean.getListaD().size() != 0) {
				byInstructorBean.setValidation(true);
			} else {
				byInstructorBean.setValidation(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			byInstructorBean.setValidation(false);
		}
	}

	// obtiene todos los pagos de un instructor y calcula los totales
	public String paymentsByInstructor() {
		byInstructorBean.setTotalCourse(0.0); // this.totalCourse = 0.0;
		byInstructorBean.setTotalPayment(0.0);// this.totalPayment = 0.0;
		byInstructorBean.setRemaining(0.0);// this.remaining = 0.0;

		try {
			if (byInstructorBean.getIdProduct() != null) {
				byInstructorBean.setListaPsp(instructorService.paymentByInstructor(byInstructorBean.getIdStudent(),
						byInstructorBean.getIdProduct()));

				if (byInstructorBean.getListaPsp().size() != 0) {
					for (int i = 0; i < byInstructorBean.getListaPsp().size(); i++) {
						if (i == 0) {
							byInstructorBean.setTotalCourse(byInstructorBean.getListaPsp().get(i).getTotalCourse());
							byInstructorBean.setNameInstructor(byInstructorBean.getListaPsp().get(i).getStudentName());
						}
						byInstructorBean.setTotalPayment(byInstructorBean.getTotalPayment()
								+ byInstructorBean.getListaPsp().get(i).getAmountPayment());

					}
					byInstructorBean
							.setRemaining(byInstructorBean.getTotalCourse() - byInstructorBean.getTotalPayment());
					return "consult";
				} else {
					RequestContext.getCurrentInstance().execute("PF('no_payments').show()");
					return "";
				}
			} else {
				RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
				return "";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block

			log.error(e);
			// RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
			return "";
		}
	}

	// crea los tikets de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double totalPayment = 0.0;
		byInstructorBean.setM(new MimeMultipart());

		try {

			if (byInstructorBean.getTemListaPsp().size() != 0) {
				for (int i = 0; i < byInstructorBean.getTemListaPsp().size(); i++) {

					Double remaining2;
					totalPayment = totalPayment + byInstructorBean.getTemListaPsp().get(i).getAmountPayment();
					remaining2 = byInstructorBean.getTemListaPsp().get(i).getTotalCourse() - totalPayment;

					report.setStudentName(byInstructorBean.getTemListaPsp().get(i).getStudentName());
					report.setCourseName(byInstructorBean.getTemListaPsp().get(i).getCourseName());
					report.setNumPayment(byInstructorBean.getTemListaPsp().get(i).getNumPayment().toString());
					report.setAmountPayment(byInstructorBean.getTemListaPsp().get(i).getAmountPayment().toString());
					report.setDatePayment(byInstructorBean.getTemListaPsp().get(i).getDatePayment().toString());
					report.setTypePayment(byInstructorBean.getTemListaPsp().get(i).getTypePayment());
					report.setRemaining(remaining2.toString());
					report.setTotalCourse(byInstructorBean.getTemListaPsp().get(i).getTotalCourse().toString());

					listaR.add(report);

					File jasper = new File(
							FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
							new JRBeanCollectionDataSource(listaR));
					byInstructorBean.setOutputStream(new ByteArrayOutputStream());
					JasperExportManager.exportReportToPdfStream(jasperPrint, byInstructorBean.getOutputStream());

					byInstructorBean.setAdjunto(new MimeBodyPart());

					DataSource ds = new ByteArrayDataSource(byInstructorBean.getOutputStream().toByteArray(),
							"application/pdf");
					byInstructorBean.getAdjunto().setDataHandler(new DataHandler(ds));
					byInstructorBean.getAdjunto()
							.setFileName("Recibo " + byInstructorBean.getTemListaPsp().get(i).getNumPayment() + "_"
									+ byInstructorBean.getTemListaPsp().get(i).getStudentName() + ".pdf");
					byInstructorBean.getM().addBodyPart(byInstructorBean.getAdjunto());

					listaR.clear();

				}
				// this.temListaPsp.clear();
				byInstructorBean.setFrom((instructorService.selectStudent(byInstructorBean.getIdStudent())).getEmail());
				byInstructorBean.setSubject("Recibos de pagos realizados  para el curso "
						+ instructorService.selectCourseName(byInstructorBean.getIdCourse()));
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('exito').show()");

			} else {
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('vacio').show()");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('fallido').show()");
			log.error(e);
		}
	}

	public void addAttribute() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("search", this.byInstructorBean);

	}

	/* getters and setters */
	public IPaymentByInstructorService getInstructorService() {
		return instructorService;
	}

	public PaymentByInstructorBean getByInstructorBean() {
		return byInstructorBean;
	}

	public void setInstructorService(IPaymentByInstructorService instructorService) {
		this.instructorService = instructorService;
	}

	public void setByInstructorBean(PaymentByInstructorBean byInstructorBean) {
		this.byInstructorBean = byInstructorBean;
	}

}
