package com.lexington.mc.webview.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lexington.mc.logic.entities.EntityBankDeprecated;
import com.lexington.mc.logic.providers.AccountProvider;
import com.lexington.mc.logic.providers.BankProvider;
import com.lexington.mc.logic.util.MessageException;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.beans.ManageGlobalSearch;
import com.lexington.mc.webview.beans.ManageUser;
import com.mallocinc.database.generated.to.AccountTo;

@SessionScoped
@ManagedBean(name = "mediaDisplay")
public class MediaDisplayUtil {
	final static Logger log = Logger.getLogger(MediaDisplayUtil.class.getName());
	UtilCodeTypes       uct = new UtilCodeTypes();
	byte [] bytes;


	/**
	 * 
	 * @return
	 */
	//the id is from the media renderer
//	public StreamedContent getStreamProfilePic() throws IOException {
//
//		FacesContext context = FacesContext.getCurrentInstance();
//		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
//		InputStream in = servletContext.getResourceAsStream("images/1pixel.png");
//		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//			// So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
//			return new DefaultStreamedContent();
//		} else {
//			// So, browser is requesting the media. Return a real StreamedContent with the media bytes.
//			String id = context.getExternalContext().getRequestParameterMap().get("id");
//			try {
//				if(id==null)
//					return new DefaultStreamedContent(in, "image/png");
//				if(id.equals(""))
//					return new DefaultStreamedContent(in, "image/png");
//				AccountTo q = new AccountProvider().getAccountByAccountId(new BigDecimal(id));
//				if(q!=null)
//					if(q.getPICTURE()!=null)
//						return new DefaultStreamedContent(new ByteArrayInputStream(q.getPICTURE()));
//			} catch (MessageException e) {
//				FacesUtil.throwMessage(e);
//				return new DefaultStreamedContent(in, "image/png");
//			}
//		}
//		return new DefaultStreamedContent(in, "image/png");
//
//	}



//	public StreamedContent getStreamProfilePicSession() throws IOException {
//		ManageUser user = (ManageUser)FacesUtil.getSessionMapValue("user");
//		ManageGlobalSearch search= user.getGlobalSearch();
//		FacesContext context = FacesContext.getCurrentInstance();
//		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
//		InputStream in = servletContext.getResourceAsStream("images/1pixel.png");
//		if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//			// So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
//			return new DefaultStreamedContent(in, "image/png");
//		} else {
//			//               QuestionTo q = new QuestionProvider().getQuestionToById(new BigDecimal(questionId));
//			//                  if(q!=null)
//			//                     if(q.getQUESTION_BLOB()!=null)
//			if(search!=null)
//			{
//
//				String addressId = context.getExternalContext().getRequestParameterMap().get("addressId");
//				AccountTo found=null;
//				if(search.getResults()!=null && addressId != null)
//				{
//					for(AccountTo a: search.getResults())
//						if(a.getACCOUNT_ID().equals(new BigDecimal(addressId)))
//							found=a;
//				}
//				if(found!=null){
//					byte [] pic=found.getPICTURE();
//					search.getResults().remove(found);
//					return new DefaultStreamedContent(new ByteArrayInputStream(pic));
//				}
//			}
//			else
//				return new DefaultStreamedContent(in, "image/png");
//		}
//		return new DefaultStreamedContent(in, "image/png");
//
//
//
//	}



	public byte[] getBytes() {
		return bytes;
	}


	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	public StreamedContent getStreamBankPicSession() throws IOException {
	
			FacesContext context = FacesContext.getCurrentInstance();
			ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
			InputStream in = servletContext.getResourceAsStream("images/1pixel.png");
			try {
			if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
				// So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
				return new DefaultStreamedContent(in, "image/png");
			} else {
				String bankId = context.getExternalContext().getRequestParameterMap().get("bankId");
				EntityBankDeprecated bank;

				bank = new BankProvider().getBankByBankId(new BigDecimal(bankId));

				if(bank.getBankTo().getBANK_LOGO()!=null){

 					return new DefaultStreamedContent(new ByteArrayInputStream(bank.getBankTo().getBANK_LOGO()));
					
//					AccountTo q = new AccountProvider().getAccountByAccountId(new BigDecimal(1));
//					return new DefaultStreamedContent(new ByteArrayInputStream(q.getPICTURE()));
				}
				else
					return new DefaultStreamedContent(in, "image/png");
			}



		} catch (MessageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return new DefaultStreamedContent(in, "image/png");
	}
}
