package mx.com.mentoringit.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.web.services.ILastPaymentService;

@ManagedBean
@SessionScoped
public class LastPaymentBean {
	private ILastPaymentService lastPaymentService;
	
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;
	
	public void lastPaymens(){
		try {
			listaPsp = this.lastPaymentService.payments();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//getters and setters
	
	public List<PSPDTO> getListaPsp() {
		lastPaymens();
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


	public ILastPaymentService getLastPaymentService() {
		return lastPaymentService;
	}


	public void setLastPaymentService(ILastPaymentService lastPaymentService) {
		this.lastPaymentService = lastPaymentService;
	}






}