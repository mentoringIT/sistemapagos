package mx.com.mentoringit.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "MbOptionsInstructor")
@ViewScoped
public class OptionsInstructorBean {
	private Integer idInstructor;
	private String phone;
	private String email;
	private String typeStudy;
	private String certificate;
	private String degree;
	private String cedula;
	
	public OptionsInstructorBean(){	}
	
	public Integer getIdInstructor() {
		return idInstructor;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getTypeStudy() {
		return typeStudy;
	}
	public String getCertificate() {
		return certificate;
	}
	public String getDegree() {
		return degree;
	}
	public String getCedula() {
		return cedula;
	}
	public void setIdInstructor(Integer idInstructor) {
		this.idInstructor = idInstructor;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTypeStudy(String typeStudy) {
		this.typeStudy = typeStudy;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
