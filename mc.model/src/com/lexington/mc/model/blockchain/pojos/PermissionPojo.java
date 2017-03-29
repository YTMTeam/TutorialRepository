package com.lexington.mc.model.blockchain.pojos;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.log4j.Logger;

import com.mallocinc.database.generated.to.AccountTo;

public class PermissionPojo extends PojoApi {

	final static Logger log = Logger.getLogger(AccountTo.class.getName());

	private static final long serialVersionUID = 1L;
	public static final String workingClassName = "PermissionTab";

	/**********************************************************************
	 *
	 * Database Variables declarations
	 *
	 **********************************************************************/
	private java.lang.String PERMISSION_ID = null;
	private java.lang.String ACCOUNT_ID = null;
	private java.lang.String REQUESTING_INSTITUTION = null;
	private java.sql.Timestamp CREATE_TIMESTAMP = null;


	/**********************************************************************
	 *
	 * Setters
	 *
	 **********************************************************************/
	public void setPERMISSION_ID(java.lang.String value) {
		this.PERMISSION_ID = value;
	}
	public void setACCOUNT_ID(java.lang.String value) {
	   this.ACCOUNT_ID = value;
	}
	public void setREQUESTING_INSTITUTION(java.lang.String value) {
	   this.REQUESTING_INSTITUTION = value;
	}
	public void setCREATE_TIMESTAMP(java.sql.Timestamp value) {
	   this.CREATE_TIMESTAMP = value;
	}
	
	
	

	/**********************************************************************
	 *
	 * Getters
	 *
	 **********************************************************************/
	// @JsonProperty("PERMISSION_ID")
	public java.lang.String getPERMISSION_ID() {
		return this.PERMISSION_ID;
	}

	// @JsonProperty("ACCOUNT_ID")
	public java.lang.String getACCOUNT_ID() {
		return this.ACCOUNT_ID;
	}

	// @JsonProperty("REQUESTING_INSTITUTION")
	public java.lang.String getREQUESTING_INSTITUTION() {
		return this.REQUESTING_INSTITUTION;
	}

	// @JsonProperty("CREATE_TIMESTAMP")
	public java.sql.Timestamp getCREATE_TIMESTAMP() {
		return this.CREATE_TIMESTAMP;
	}

	public String getRowKey() {
		return PERMISSION_ID;
	}

}