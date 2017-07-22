package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.ExistingInstructorBean;
import mx.com.mentoringit.web.services.IExistingInstructorService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbExistingInstructorController")
@SessionScoped
public class ExistingInstructorController {
	@ManagedProperty(value = "#{MbExistingInstructor}")
	private ExistingInstructorBean existingInsBean;

	@ManagedProperty(value = "#{existingInstructorService}")
	private IExistingInstructorService instructorService;

	// obtiene todos los cursos
	public List<CourseDTO> selectCourse() {
		try {
			return instructorService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
			return null;
		}
	}

	// obtiene todos los alumnos
	public List<StudentDTO> allInstructors() {

		try {
			return instructorService.allInstructors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
			return null;
		}
	}

	// obtiene las fechas de inicio
	public void startDates() {

		try {
			existingInsBean.setListaD(instructorService.startDates(existingInsBean.getIdCourse(),
					existingInsBean.getFormatDate1(), existingInsBean.getFormatDate2()));
			if (existingInsBean.getListaD().size() != 0) {
				existingInsBean.setValidation(true);
			} else {
				existingInsBean.setValidation(false);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
			existingInsBean.setValidation(false);
		}
	}

	public void test() {
		existingInsBean.setTotalCourse(100.0);
		existingInsBean.setTotalPayment(100.0);
		existingInsBean.setRemaining(100.0);
	}

	// muestra los totales
	public void totals() {
		existingInsBean.setTotalCourse(0.0);
		existingInsBean.setTotalPayment(0.0);
		existingInsBean.setRemaining(0.0);
		existingInsBean.setAmount(0.0);
		try {

			List<PaymentDTO> listaP;
			listaP = instructorService.selectPayment(existingInsBean.getIdStudent(), existingInsBean.getIdProduct());

			if (listaP.size() != 0) {
				for (int i = 0; i < listaP.size(); i++) {
					if (i == 0) {

						existingInsBean.setTotalCourse(listaP.get(i).getTotal_course());
						existingInsBean.setTotal(existingInsBean.getTotalCourse());
					}
					existingInsBean
							.setTotalPayment(existingInsBean.getTotalPayment() + listaP.get(i).getAmount_payment());
					existingInsBean.setNumPayment(listaP.get(i).getNum_payment());

				}
				existingInsBean.setNumPayment(existingInsBean.getNumPayment().intValue() + 1);
				existingInsBean.setRemaining(existingInsBean.getTotalCourse() - existingInsBean.getTotalPayment());

			} else {
				existingInsBean.setNumPayment(1);
				existingInsBean.setTotal(0.0);
				existingInsBean.setAmount(0.0);
			}

			status(existingInsBean.getTotalCourse().doubleValue(), existingInsBean.getTotalPayment().doubleValue());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
		}
	}

	private void status(double n1, double n2) {
		RequestContext rc = RequestContext.getCurrentInstance();
		if (n1 == n2 && n2 != 0.0) {
			existingInsBean.setPaymentStatus(true);
			rc.execute("PF('status').show()");

		} else {
			existingInsBean.setPaymentStatus(false);
			rc.update("form1");
		}
	}

	// crea el tiket de pago
	public void createReport() {
		List<ReportData> listaR = new ArrayList<ReportData>();
		ReportData report = new ReportData();
		Double resto = 0.0;
		boolean flag = false;

		if (existingInsBean.getRemaining().doubleValue() != 0.0) {
			resto = existingInsBean.getRemaining() - existingInsBean.getAmount();
		} else {
			resto = existingInsBean.getTotal() - existingInsBean.getAmount();
		}

		if (existingInsBean.getTotal().equals(existingInsBean.getTotalPayment())) {
			flag = true;
			// esb.setPaymentStatus(true);
		}

		try {

			if (existingInsBean.getIdProduct() != null) {
				if (!flag) {
					report.setStudentName((instructorService.selectStudent(existingInsBean.getIdStudent())).getName());
					report.setCourseName(instructorService.selectCourseName(existingInsBean.getIdCourse()));
					report.setNumPayment(existingInsBean.getNumPayment().toString());
					report.setAmountPayment(existingInsBean.getAmount().toString());
					report.setDatePayment(existingInsBean.getDatePayment2());
					report.setTypePayment(existingInsBean.getTypePayment());
					report.setRemaining(resto.toString());
					report.setTotalCourse(existingInsBean.getTotal().toString());

					listaR.add(report);

					File jasper = new File(
							FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
							new JRBeanCollectionDataSource(listaR));
					existingInsBean.setOutputStream(new ByteArrayOutputStream());
					JasperExportManager.exportReportToPdfStream(jasperPrint, existingInsBean.getOutputStream());

					InputStream is = new ByteArrayInputStream(existingInsBean.getOutputStream().toByteArray());
					existingInsBean.setMedia(new DefaultStreamedContent(is, "application/pdf", "Recibo.pdf"));

					listaR.clear();

					existingInsBean.setFrom((instructorService.selectStudent(existingInsBean.getIdStudent())).getEmail());

					existingInsBean.setSubject("Recibo de pago No. " + existingInsBean.getNumPayment()
							+ " para el curso " + instructorService.selectCourseName(existingInsBean.getIdCourse()));

					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('detail').show()");
				} else {
					existingInsBean.setPaymentStatus(true);
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
			// log.error(e);

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
			// valida que el pago actual no sea mayor que el total del curso o
			// el restante a pagar
			if ((existingInsBean.getAmount().doubleValue() > existingInsBean.getTotal().doubleValue())
					|| ((existingInsBean.getAmount().doubleValue() > existingInsBean.getRemaining().doubleValue())
							&& (existingInsBean.getRemaining().doubleValue() != 0.0))) {
				RequestContext.getCurrentInstance().execute("PF('invalidPayment').show()");
			} else {/* actualiza el estado de los totales al realizar el pago */
				listaP = instructorService.selectPayment(existingInsBean.getIdStudent(),
						existingInsBean.getIdProduct());

				if (!listaP.isEmpty()) {
					for (PaymentDTO p : listaP) {
						pay = p;
						totalC = p.getTotal_course();
						totalP = totalP + p.getAmount_payment();
					}
					restante = totalC - (totalP + existingInsBean.getAmount());
				} else {
					existingInsBean.setTotalCourse(existingInsBean.getTotal());
					existingInsBean.setTotalPayment(existingInsBean.getAmount());
					existingInsBean.setRemaining(existingInsBean.getTotalCourse() - existingInsBean.getTotalPayment());
				}

				// if (!pay.getTotal_course().equals(this.totalPayment)) {
				payment.setStudent_id(existingInsBean.getIdStudent());
				payment.setCourse_id(existingInsBean.getIdCourse());
				payment.setNum_payment(existingInsBean.getNumPayment());
				payment.setAmount_payment(existingInsBean.getAmount());
				payment.setType_payment(existingInsBean.getTypePayment());
				payment.setDate_payment(existingInsBean.getDatePayment());
				payment.setTotal_course(existingInsBean.getTotal());
				payment.setProduct_id(existingInsBean.getIdProduct());
				payment.setType_register("t");

				// muestra el estado de pagos actual si el alumno ya ha
				// realizado pagos
				if (pay.getNum_payment() != null) {
					existingInsBean.setTotalCourse(totalC);
					existingInsBean.setTotalPayment(totalP + existingInsBean.getAmount().doubleValue());
					existingInsBean.setRemaining(restante);
				}

				instructorService.insertPayment(payment);
				existingInsBean.setAmount(0.0);
				existingInsBean.setNumPayment(existingInsBean.getNumPayment().intValue() + 1);
				RequestContext rc = RequestContext.getCurrentInstance();
				rc.execute("PF('regExito').show()");
				// } else {
				// RequestContext.getCurrentInstance().execute("PF('status').show()");
				// }
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestContext rc = RequestContext.getCurrentInstance();
			rc.execute("PF('regFallido').show()");
			// log.error(e);
		}

	}

	public void addAttribute() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("object", existingInsBean);

	}

	/* getters and setters */
	public ExistingInstructorBean getExistingInsBean() {
		return existingInsBean;
	}

	public IExistingInstructorService getInstructorService() {
		return instructorService;
	}

	public void setExistingInsBean(ExistingInstructorBean existingInsBean) {
		this.existingInsBean = existingInsBean;
	}

	public void setInstructorService(IExistingInstructorService instructorService) {
		this.instructorService = instructorService;
	}

}
