package mx.com.mentoringit.web.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.PaymentByInstructorBean;
import mx.com.mentoringit.web.services.IPaymentByInstructorService;

@ManagedBean(name = "MbPaymentByInstructorController")
@SessionScoped
public class PaymentByInstructorController implements Serializable {

	@ManagedProperty(value = "#{paymentByInstructorService}")
	private IPaymentByInstructorService instructorService;

	@ManagedProperty(value = "#{MbPaymentByInstructor}")
	private PaymentByInstructorBean byInstructorBean;

	public PaymentByInstructorController() {
	}

	// obtiene todos los cursos
	public List<CourseDTO> courses() {
		try {
			return instructorService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
			return null;
		}
	}

	// obtiene todos los instructores
	public List<StudentDTO> allInstructors() {

		try {
			return instructorService.allInstructors();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.error(e);
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
			// log.error(e);
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

			// log.error(e);
			// RequestContext.getCurrentInstance().execute("PF('seleccionar').show()");
			return "";
		}
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
