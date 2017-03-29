package com.lexington.mc.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;

@FacesValidator("twoFieldsValidator")
public class ValidateTwoFieds implements Validator {
   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

      String field2 = (String) component.getAttributes().get("field2");
      if (!value.equals(field2)) {
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("notTheSameFileds"));

         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

   }
}
