package com.lexington.mc.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.model.util.UtilProperites;
import com.lexington.mc.webview.util.ManageLanguage;

@FacesValidator("validatorEsayInputText")
public class ValidateEsayInputText implements Validator{
   
   static final int INPUT_TEXT_MAX_SIZE = 2000;

   @Override
   public void validate(FacesContext context, UIComponent comp, Object value)
           throws ValidatorException{
       String text = (String) value;
       if(text != null && text.length() > INPUT_TEXT_MAX_SIZE){
           FacesMessage errorMessage = new FacesMessage(UtilProperites.getMessageProperty(ManageLanguage.getLocal(), "validateEsayInputText"));
           errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(errorMessage);
       }
   }
}