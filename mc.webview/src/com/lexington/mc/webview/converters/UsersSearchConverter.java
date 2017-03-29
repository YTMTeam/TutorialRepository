package com.lexington.mc.webview.converters;

import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.AccountTo;

@FacesConverter("usersSearchConverter")
public class UsersSearchConverter implements Converter {

   

   public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
      if (value != null && value.trim().length() > 0) {
         try {

            return findUser(value);

         } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid user."));
         }
      } else {
         return null;
      }
   }

   public String getAsString(FacesContext fc, UIComponent uic, Object object) {
      if (object != null) {
         return String.valueOf(((AccountTo) object).getACCOUNT_ID());
      } else {
         return null;
      }
   }

   private AccountTo findUser(String id) {
      try {
         return new AccountProvider().getAccountByAccountId(id);
      } catch (MessageException e) {
         FacesUtil.throwMessage(e);
      }
      return null;
   }
}