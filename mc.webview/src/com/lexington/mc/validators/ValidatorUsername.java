package com.lexington.mc.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.model.util.UtilProperites;
import com.lexington.mc.webview.util.ManageLanguage;

@FacesValidator("validatorUsername")
public class ValidatorUsername implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent comp, Object value) throws ValidatorException {
		String username = (String)value;
		if(username.contains(" ")){
			FacesMessage errorMessage = new FacesMessage(UtilProperites.getMessageProperty(ManageLanguage.getLocal(), "validateUsername"));
			errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(errorMessage);
		}

	}

}
