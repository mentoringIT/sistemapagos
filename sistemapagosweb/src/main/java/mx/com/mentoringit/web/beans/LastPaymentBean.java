package mx.com.mentoringit.web.beans;


import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.web.controllers.LastPaymentController;
import mx.com.mentoringit.web.services.ILastPaymentService;

@ManagedBean(name = "MbLastPayment")
@RequestScoped
public class LastPaymentBean implements Serializable{
		
	private List<PSPDTO> listaPsp;	
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;
	
	public LastPaymentBean(){}
	
	//obtiene los pagos realizados
//	public void lastPaymens(){
//		try {
//			listaPsp = this.lastPaymentService.payments();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			log.error(e);
//		}
//	}

	
	//getters and setters
	
	public List<PSPDTO> getListaPsp() {
		return listaPsp;
	}

	public void setListaPsp(List<PSPDTO> listaPsp) {
		this.listaPsp = listaPsp;
	}

	public PSPDTO getDetail() {
		return detail;
	}


	public void setDetail(PSPDTO detail) {
		this.detail = detail;
	}


	public List<PSPDTO> getFilterPayments() {
		return filterPayments;
	}


	public void setFilterPayments(List<PSPDTO> filterPayments) {
		this.filterPayments = filterPayments;
	}
}
