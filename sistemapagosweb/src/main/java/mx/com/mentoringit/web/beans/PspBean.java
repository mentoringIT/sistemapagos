package mx.com.mentoringit.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.web.services.IPspService;

@ManagedBean
@SessionScoped
public class PspBean {
	private IPspService pspService;
	
	private List<PSPDTO> listaPsp;
	private List<PSPDTO> filterPayments;
	private PSPDTO detail;
	
	public void lastPaymens(){
		try {
			listaPsp = this.pspService.payments();
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


	public IPspService getPspService() {
		return pspService;
	}

	public void setPspService(IPspService pspService) {
		this.pspService = pspService;
	}

}
