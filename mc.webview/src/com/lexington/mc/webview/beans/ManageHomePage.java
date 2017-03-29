package com.lexington.mc.webview.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lexington.mc.webview.util.FacesUtil;

@ViewScoped
@ManagedBean(name = "homePage")
public class ManageHomePage {
   private boolean viewInfo = true;

   public ManageHomePage() {
      String msg = (String) FacesUtil.getSessionMapValue("homeInfo");
      if (msg != null) {
         FacesUtil.removeSessionMapValue("homeInfo");
         FacesUtil.throwInfo(msg);

      }

      /*	String msgWarn=(String) FacesUtil.getSessionMapValue("homeWarn");
      	if(msgWarn!=null){
      	FacesUtil.removeSessionMapValue("homeWarn");
      	FacesUtil.throwWarning(msgWarn);
      	
      	}
      	
      	
      	String msgError=(String) FacesUtil.getSessionMapValue("homeError");
      	if(msgError!=null){
      	FacesUtil.removeSessionMapValue("homeError");
      	FacesUtil.throwError(msgError);
      	
      	} */

   }

   public boolean isViewInfo() {
      return viewInfo;
   }

   public void setViewInfo(boolean viewInfo) {
      this.viewInfo = viewInfo;
   }

}
