package com.lexington.mc.webview.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.ServletContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lexington.mc.model.blockchain.pojos.AccountPojo;
import com.lexington.mc.model.entities.EntityAccount;
import com.lexington.mc.webview.util.FacesUtil;
import com.mallocinc.database.generated.to.AccountTo;
public class FamilyController {

	private EntityAccount curUser=new EntityAccount();
	private EntityAccount curUserTo=new EntityAccount();
	private EntityAccount curFamilyMember=null;
	private ArrayList<EntityAccount> familyMembers=new ArrayList<>();

	private List<EntityAccount> listMembers;
	private boolean viewFamily;
	
	
	/**
	 * Ne postoji vise household
	 * @param event
	 */
//	public void generateFamilyMembers(){
//		familyMembers=new ArrayList<>();
//		try {	
//			familyMembers=new AccountProvider().getUsersByGroupId(curUser.getTo().getHOUSEHOLD_ID());
//	 
//		} catch (MessageException e) {
//			FacesUtil.throwMessage(e);
//		}
//		
//		
//	}

	
	 public void onRowSelect(SelectEvent event) {
//	        FacesMessage msg = new FacesMessage("User Selected", ((AccountTo) event.getObject()).getFIRST_NAME());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);
//	        curFamilyMember=new EntityAccount();
	        
		 
		 FacesUtil.throwInfo("notImplemented");
	    }
	 
	    public void onRowUnselect(UnselectEvent event) {
//	        FacesMessage msg = new FacesMessage("User Unselected", ((AccountTo) event.getObject()).getFIRST_NAME());
//	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	
	    public StreamedContent getStreamProfilePicSession() throws IOException {
		    
		      FacesContext context = FacesContext.getCurrentInstance();
		      ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		      InputStream in = servletContext.getResourceAsStream("images/1pixel.png");
		      if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
		         // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
		    	  return new DefaultStreamedContent(in, "image/png");
		      } else {
		         //               QuestionTo q = new QuestionProvider().getQuestionToById(new BigDecimal(questionId));
		         //                  if(q!=null)
		         //                     if(q.getQUESTION_BLOB()!=null)
		         
		        	 
		        	 String addressId = context.getExternalContext().getRequestParameterMap().get("addressId");
		        	 
		            if(getFamilyMembers()!=null && addressId != null)
		            {
		               /**
		                * Ne postoji vise picture u Accounts
		                */
//		            	for(AccountTo a: getFamilyMembers())
//		            		if(a.getACCOUNT_ID().equals(new BigDecimal(addressId)))
		            			// return new DefaultStreamedContent(new ByteArrayInputStream(a.getPICTURE()));
		            }
		            
		           
		          
		             
		            else
		            	return new DefaultStreamedContent(in, "image/png");
		      }
		      return new DefaultStreamedContent(in, "image/png");
		  


		   }
	public EntityAccount getCurUser() {
		return curUser;
	}

	public void setCurUser(EntityAccount curUser2) {
		this.curUser = curUser2;
	}


	public ArrayList<EntityAccount> getFamilyMembers() {
		return familyMembers;
	}


	public void setFamilyMembers(ArrayList<EntityAccount> familyMembers) {
		this.familyMembers = familyMembers;
	}


	public EntityAccount getCurUserTo() {
		return curUserTo;
	}


	public void setCurUserTo(EntityAccount curUserTo) {
		this.curUserTo = curUserTo;
	}


	public EntityAccount getCurFamilyMember() {
		return curFamilyMember;
	}


	public void setCurFamilyMember(EntityAccount curFamilyMember) {
		this.curFamilyMember = curFamilyMember;
	}


	public List<EntityAccount> getListMembers() {
		return listMembers;
	}


	public void setListMembers(List<EntityAccount> listMembers) {
		this.listMembers = listMembers;
	}


	public void setViewFamily(boolean b) {
		viewFamily=b;
		
	}


	public boolean isViewFamily() {
		return viewFamily;
	}


	 


 
 
	
 
	
	
	
	
	
}
