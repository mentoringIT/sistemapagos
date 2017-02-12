package mx.com.mentoringit.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.mentoringit.model.dao.PSPDAO;
import mx.com.mentoringit.model.dto.PSPDTO;

@Service
public class LastPaymentService implements ILastPaymentService{
	private PSPDAO pspDAO;

	public PSPDAO getPspDAO() {
		return pspDAO;
	}
	
	@Autowired
	public void setPspDAO(PSPDAO pspDAO) {
		this.pspDAO = pspDAO;
	}

	@Override
	public List<PSPDTO> payments() throws Exception {
		return this.pspDAO.lastPayment();
	}
	
	

}
