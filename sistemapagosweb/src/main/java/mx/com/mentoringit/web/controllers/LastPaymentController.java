package mx.com.mentoringit.web.controllers;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import mx.com.mentoringit.model.dto.PSPDTO;
import mx.com.mentoringit.web.services.ILastPaymentService;


@ManagedBean
@RequestScoped
public class LastPaymentController implements Serializable{
	private final static Logger log = Logger.getLogger(LastPaymentController.class);

	@ManagedProperty(value = "#{lastPaymentService}")
	private ILastPaymentService lastPaymentService;
	
	public LastPaymentController(){
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream("log4j.properties");
			PropertyConfigurator.configure(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//obtiene los pagos realizados
	public List<PSPDTO> lastPaymens(){		
			try {
				return this.lastPaymentService.payments();
			} catch (Exception e) {	
				log.error(e);
				return null;
			}		
	}

	public ILastPaymentService getLastPaymentService() {
		return lastPaymentService;
	}

	public void setLastPaymentService(ILastPaymentService lastPaymentService) {
		this.lastPaymentService = lastPaymentService;
	}
	
}
