package mx.com.mentoringit.web.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.model.DefaultStreamedContent;

import mx.com.mentoringit.model.dto.CourseDTO;
import mx.com.mentoringit.model.dto.PaymentDTO;
import mx.com.mentoringit.model.dto.ProfileDTO;
import mx.com.mentoringit.model.dto.RegistrationDTO;
import mx.com.mentoringit.model.dto.ReportData;
import mx.com.mentoringit.model.dto.StudentDTO;
import mx.com.mentoringit.web.beans.NewInstructorBean;
import mx.com.mentoringit.web.services.INewInstructorServices;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "MbNewInstructorController")
@SessionScoped
public class NewInstructorController implements Serializable {
	@ManagedProperty(value = "#{newIntructorService}")
	private INewInstructorServices newIntructorService;

	@ManagedProperty(value = "#{MbNewInstructorBean}")
	private NewInstructorBean instructorBean;

	/* metodos */

	/* obtiene todos los cursos */
	public List<CourseDTO> allCourses() {
		try {
			return newIntructorService.allCourse();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// obtiene las fechas de inicio
	public void startDates() {

		try {
			instructorBean.setListaD(newIntructorService.startDates(instructorBean.getIdCourse(), 
					instructorBean.getFormatDate1(), instructorBean.getFormatDate2()));
			if (instructorBean.getListaD().size() != 0) {
				instructorBean.setValidation(true);
			} else {
				instructorBean.setValidation(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			instructorBean.setValidation(true);
		}
	}
	
	
	// crea el tiket de pago
			public void createReport() {
				List<ReportData> listaR = new ArrayList<ReportData>();
				ReportData report = new ReportData();
				Double remaining = 0.0;
		
				try {				
								
					if (instructorBean.getIdProduct() != null) {
						if (instructorBean.getAmount().doubleValue() > instructorBean.getTotal().doubleValue()) {
							RequestContext.getCurrentInstance().execute("PF('invalidPayment').show()");
						} else {
							remaining = instructorBean.getTotal() - instructorBean.getAmount();
		
							report.setStudentName(instructorBean.getCompleteName());
							report.setCourseName(newIntructorService.selectCourseName(instructorBean.getIdCourse()));
							report.setNumPayment(instructorBean.getNumPayment().toString());
							report.setAmountPayment(instructorBean.getAmount().toString());
							report.setDatePayment(instructorBean.getFormatDatePayment());
							report.setTypePayment(instructorBean.getTypePayment());
							report.setRemaining(remaining.toString());
							report.setTotalCourse(instructorBean.getTotal().toString());
		
							listaR.add(report);
		
							File jasper = new File(
									FacesContext.getCurrentInstance().getExternalContext().getRealPath("/payment.jasper"));
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null,
									new JRBeanCollectionDataSource(listaR));
							instructorBean.setOutputStream(new ByteArrayOutputStream());
							JasperExportManager.exportReportToPdfStream(jasperPrint, instructorBean.getOutputStream());
		
							InputStream is = new ByteArrayInputStream(instructorBean.getOutputStream().toByteArray());
							instructorBean.setMedia(new DefaultStreamedContent(is, "application/pdf", "Recibo.pdf"));
		
							listaR.clear();
							
//							instructorBean.setSubject("Recibo de pago No. " + instructorBean.getNumPayment() + " para el curso "
//									+ this.newIntructorService.selectCourseName(instructorBean.getIdCourse()));			
		
							RequestContext rc = RequestContext.getCurrentInstance();
							rc.execute("PF('detail').show()");
		
						}
					} else {
						RequestContext rc = RequestContext.getCurrentInstance();
						rc.execute("PF('selecionar').show()");
					}
		
				} catch (Exception e) {
					// TODO Auto-generated catch block
					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('genPago').show()");
//					log.error(e);
				}
			}
			

			// inserta al estudiante en la base
			public String inStudent() {
				StudentDTO student = new StudentDTO();
				ProfileDTO profileDTO = new ProfileDTO();
//				RegistrationDTO register = new RegistrationDTO();
				
				student.setEmail(instructorBean.getEmail());
				student.setName(instructorBean.getCompleteName());
				student.setPhone(instructorBean.getPhone());
				student.setStatus((short)1);
				student.setType_register("t");
				
				profileDTO.setTypeStudy(instructorBean.getTypeStudy());
				profileDTO.setCertification(instructorBean.getCertification());
				profileDTO.setDegree(instructorBean.getTitle());
				profileDTO.setCedula(instructorBean.getCedula());
				
//				register.setCourseId(instructorBean.getIdCourse());
//				register.setProductoId(instructorBean.getIdProduct());

				

				try {
					newIntructorService.insertStudent(student);
					instructorBean.setIdStudent(newIntructorService.idMax());
					profileDTO.setStudentId(instructorBean.getIdStudent());
					newIntructorService.insertProfile(profileDTO);
//					register.setStudentId(instructorBean.getIdStudent());
//					newIntructorService.insertRegister(register);
					insertPayment();
				} catch (Exception e) {
					// TODO Auto-generated catch block
//					log.error(e);
				}
				return "next";
			}
			
			// inserta el pago en la base
			private void insertPayment() {
				PaymentDTO payment = new PaymentDTO();

				payment.setStudent_id(instructorBean.getIdStudent());
				payment.setCourse_id(instructorBean.getIdCourse());
				payment.setNum_payment(instructorBean.getNumPayment());
				payment.setAmount_payment(instructorBean.getAmount());
				payment.setType_payment(instructorBean.getTypePayment());
				payment.setDate_payment(instructorBean.getDatePayment());
				payment.setTotal_course(instructorBean.getTotal());
				payment.setProduct_id(instructorBean.getIdProduct());
				payment.setType_register("t");

				try {
					this.newIntructorService.insertPayment(payment);
					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('regExito').show()");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					RequestContext rc = RequestContext.getCurrentInstance();
					rc.execute("PF('regFallido').show()");
//					log.error(e);
				}

			}

	
	
	
	
	
	
	
	
	
	

	/* getters and setters */
	public INewInstructorServices getNewIntructorService() {
		return newIntructorService;
	}

	public void setNewIntructorService(INewInstructorServices newIntructorService) {
		this.newIntructorService = newIntructorService;
	}

	public NewInstructorBean getInstructorBean() {
		return instructorBean;
	}

	public void setInstructorBean(NewInstructorBean instructorBean) {
		this.instructorBean = instructorBean;
	}

}
