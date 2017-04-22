package mx.com.mentoringit.web.beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class ValidateSpinner implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		String valor = Double.toString((Double) arg2);

		for (int x = 0; x < valor.length(); x++) {
			if (valor.codePointAt(x) != 46) {
				if (!(valor.codePointAt(x) >= 48 && valor.codePointAt(x) <= 57)) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(null, "", "caracter invalido"));
				}
				break;
			}
		}
	}
}
