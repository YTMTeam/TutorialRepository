package com.lexington.mc.validators;

import java.math.BigDecimal;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;
import com.lexington.mc.webview.util.TimeUtil;

@FacesValidator("durationValidator")
public class ValidateDuration implements Validator {

   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      if (value == null) {
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("requiredDuration"));
         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

      if (!(value instanceof Date)) {
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("requiredDuration"));
         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

      Date date = (Date) value;
      BigDecimal duration = new TimeUtil().getDuration(date);

      if (duration.equals(BigDecimal.ZERO)) {
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("requiredDuration"));
         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

   }

}
