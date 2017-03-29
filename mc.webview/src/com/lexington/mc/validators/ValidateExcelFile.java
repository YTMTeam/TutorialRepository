package com.lexington.mc.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.model.UploadedFile;

public class ValidateExcelFile implements Validator {
   private static final Pattern pattern = Pattern.compile("([^\\s]+(\\.(?i)(xls))$)", Pattern.CASE_INSENSITIVE);

   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

      UploadedFile uFile = (UploadedFile) value;
      Matcher m = pattern.matcher(uFile.getFileName());
      boolean matchFound = m.matches();

      if (!matchFound) {
         FacesMessage message = new FacesMessage("Bad file extension" + uFile.getFileName());
         throw new ValidatorException(message);
      }
   }
}