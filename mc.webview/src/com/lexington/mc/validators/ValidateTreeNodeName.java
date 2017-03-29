package com.lexington.mc.validators;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.model.util.UtilProperites;
import com.lexington.mc.webview.util.FacesUtil;

@FacesValidator("treeNodeNameValidator")
public class ValidateTreeNodeName implements Validator {
   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
      final Pattern PATTERN_TREE_NAME = Pattern.compile(UtilProperites.getSettingsProperty("regexTreeTableName"));

      if (!PATTERN_TREE_NAME.matcher(value.toString()).matches()) {
         String text = FacesUtil.getMessage("followingCharsAreForbbiden");

         // format string
         text = String.format(text, UtilProperites.getSettingsProperty("regexTreeTableBlackList"));
         FacesMessage message = new FacesMessage(text);
         message.setSeverity(FacesMessage.SEVERITY_ERROR);
         throw new ValidatorException(message);
      }

      System.out.println("Tree name validation of" + value.toString() + " ok");

   }
}
