package com.lexington.mc.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;

@FacesValidator("editorLengthValidator")
public class ValidateEditorLength implements Validator {

   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

      //			try {
      //				GradingSystemTo gs2=getGradingSystemByName(gs.getGRADING_SYSTEM_NAME());
      //				if(gs2==null) return true;
      //				if(gs2.getGRADING_SYSTEM_ID().equals(gs.getGRADING_SYSTEM_ID())) return true;
      //			} catch (MessageException e) {
      //				return false;
      //			}
      //			return false;

	 //  Object maxLengthStr= component.getAttributes().get("maxLength");
	   
	   
	   
      int maxLength = new Integer((String) component.getAttributes().get("maxLength"));
    Object[] params={maxLength+""};
      if(((String)value).length()>maxLength){
    	  FacesMessage facesMessage= FacesUtil.getMessageWithParameters("warning",FacesMessage.SEVERITY_WARN, "errorBigDescMaxNumOfChars",params);
    	  throw new ValidatorException(facesMessage);
     
      
      }
   }

}