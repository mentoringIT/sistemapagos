package mx.com.mentoringit.web.services;

import java.util.List;

import mx.com.mentoringit.model.dto.PSPDTO;

public interface IPspService {
	public List<PSPDTO> payments () throws Exception;

}
