package com.lexington.mc.model.blockchain.pojos;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.mallocinc.database.generated.to.AccountTo;

public class LoginPojo extends PojoApi {

	final static Logger log = Logger.getLogger(AccountTo.class.getName());

	private static final long serialVersionUID = 1L;
	public static final String workingClassName = "AccountTab";

	/**********************************************************************
	 *
	 * Database Variables declarations
	 *
	 **********************************************************************/
	private java.lang.String LOGIN_ID = null;
	private java.lang.String USER_NAME = null;
	private java.lang.String BANK_CODE = null;
	private java.sql.Timestamp CREATE_TIMESTAMP = null;

	/**********************************************************************
	 *
	 * Setters
	 *
	 **********************************************************************/


   public void setLOGIN_ID(java.lang.String lOGIN_ID) {
      LOGIN_ID = lOGIN_ID;
   }

   public void setUSER_NAME(java.lang.String uSER_NAME) {
      USER_NAME = uSER_NAME;
   }

   public void setBANK_CODE(java.lang.String bANK_CODE) {
      BANK_CODE = bANK_CODE;
   }


   public void setCREATE_TIMESTAMP(java.sql.Timestamp cREATE_TIMESTAMP) {
      CREATE_TIMESTAMP = cREATE_TIMESTAMP;
   }
	
	
	

	/**********************************************************************
	 *
	 * Getters
	 *
	 **********************************************************************/
   
   public java.sql.Timestamp getCREATE_TIMESTAMP() {
      return CREATE_TIMESTAMP;
   }
   public java.lang.String getBANK_CODE() {
      return BANK_CODE;
   }
   public java.lang.String getUSER_NAME() {
      return USER_NAME;
   }
   public java.lang.String getLOGIN_ID() {
      return LOGIN_ID;
   }
   

   public String getRowKey() {
      return LOGIN_ID;
  }


}