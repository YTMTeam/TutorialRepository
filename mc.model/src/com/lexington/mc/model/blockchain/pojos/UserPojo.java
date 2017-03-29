package com.lexington.mc.model.blockchain.pojos;


import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.mallocinc.database.generated.to.UsersTo;

public class UserPojo  extends PojoApi{
   
   final static Logger log = Logger.getLogger(UsersTo.class.getName());

   private static final long serialVersionUID = 1L;
   public static final String workingClassName ="UsersTab";

   /**********************************************************************
    *
    * Database Variables declarations
    *
    **********************************************************************/
   private java.math.BigDecimal USER_ID = null;
private java.math.BigDecimal BANK_ID = null;
private java.lang.String USER_NAME = null;


   /**********************************************************************
    *
    * Setters
    *
    **********************************************************************/   
   public void setUSER_ID( java.math.BigDecimal value ) {
      this.USER_ID = value;
   }
   public void setBANK_ID( java.math.BigDecimal value ) {
      this.BANK_ID = value;
   }
   public void setUSER_NAME( java.lang.String value ) {
      this.USER_NAME = value;
   }

   /**********************************************************************
    *
    * Getters
    *
    **********************************************************************/   
   //@JsonProperty("USER_ID")
   public java.math.BigDecimal getUSER_ID( ) {
      return this.USER_ID;
   }
   //@JsonProperty("BANK_ID")
   public java.math.BigDecimal getBANK_ID( ) {
      return this.BANK_ID;
   }
   //@JsonProperty("USER_NAME")
   public java.lang.String getUSER_NAME( ) {
      return this.USER_NAME;
   }
   
   /**********************************************************
    * 
    * This print() method is used for debugging.
    * 
    ***********************************************************/
   public void print() {
      log.debug("Transfer object - Begins:");
            String content;
      content = String.format("1.\t%-30s -> [%s]\n", "USER_ID",  this.getUSER_ID());
      log.debug(content);
      content = String.format("2.\t%-30s -> [%s]\n", "BANK_ID",  this.getBANK_ID());
      log.debug(content);
      content = String.format("3.\t%-30s -> [%s]\n", "USER_NAME",  this.getUSER_NAME());
      log.debug(content);

      log.debug("Transfer object - Ends.");
   }

   
   public String getRowKey() {
      return USER_ID.toString();
   }
}