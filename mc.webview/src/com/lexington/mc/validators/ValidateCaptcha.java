package com.lexington.mc.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.lexington.mc.webview.util.FacesUtil;

@FacesValidator("captchaValidator")
public class ValidateCaptcha implements Validator {

   @Override
   public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

      String captchaCode = (String) component.getAttributes().get("captchaCode");
      //BigDecimal parentId = (BigDecimal) component.getAttributes().get("categoryID");
      //String parentPath = (String) component.getAttributes().get("parentPath");
       String captcha = (String) value;

//      QuizCategoryProvider qdp = new QuizCategoryProvider();
//      try {

//         String newPath = parentPath + "|" + newName;

//         VQuizCategoriesSum2To categorySum2To = qdp.getCategorySum2ToByPath(newPath);

         /**checks for insert only**/
//         if (categorySum2To == null)
//            return; //that path doesn't exist, update or insert are available

         /**checks for update only**/
//         if (categoryID != null)
//            if (categorySum2To.getQUIZ_CATEGORY_ID().equals(categoryID))
//               return; //updates existing

         /**update to others path - FORBIDDEN **/
      
      if(!captchaCode.equals(captcha)){
         FacesMessage message = new FacesMessage(FacesUtil.getMessage("captchaDoesntMatch"));
         message.setSeverity(FacesMessage.SEVERITY_WARN);
         throw new ValidatorException(message);
      }
//      } catch (MessageException e) {
//         FacesUtil.throwMessage(e);
//      }

   }

}
