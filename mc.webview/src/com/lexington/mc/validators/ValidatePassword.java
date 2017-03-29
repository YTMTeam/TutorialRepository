package com.lexington.mc.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;

@FacesValidator("passwordValidator")
public class ValidatePassword implements Validator {

   private Pattern             pattern;
   private Matcher             matcher;
   private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*([!-/]|[:-@]|[\\Q[\\E-`]|[\\Q{\\E-~])).{6,20})";

   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      pattern = Pattern.compile(PASSWORD_PATTERN);
      matcher = pattern.matcher((String) value);

      if (!matcher.matches()) {
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("complexPass"));
         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

   }

}