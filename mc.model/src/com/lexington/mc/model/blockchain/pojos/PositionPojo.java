package com.lexington.mc.model.blockchain.pojos;

import com.mallocinc.codegenerator.superclasses.oracle.*;
import com.mallocinc.database.generated.to.PositionTo;

import java.io.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class PositionPojo extends PojoApi {

	final static Logger log = Logger.getLogger(PositionTo.class.getName());

	private static final long serialVersionUID = 1L;
	public static final String workingClassName = "PositionTab";

	/**********************************************************************
	 *
	 * Database Variables declarations
	 *
	 **********************************************************************/
	private java.lang.String POSITION_ID = null;
	private java.lang.String ACCOUNT_ID = null;
	private java.lang.String BROKER_CODE = null;
	private java.lang.String SECURITY_SYMBOL = null;
	private java.lang.String CUSIP = null;
	private java.lang.String ISIN = null;
	private java.lang.String SEDOL = null;
	private java.lang.String CURRENCY = null;
	private java.sql.Timestamp EXPIRATION_DATE = null;
	private java.math.BigDecimal EXECUTION_PRICE = null;
	private java.math.BigDecimal MARKET_PRICE = null;
	private java.math.BigDecimal QUANTITY = null;
	private java.sql.Timestamp CREATE_TIMESTAMP = null;
	private java.sql.Timestamp SECURITY_DATE = null;

	/**********************************************************************
	 *
	 * Setters
	 *
	 **********************************************************************/
	public void setPOSITION_ID(java.lang.String value) {
		this.POSITION_ID = value;
	}

	public void setACCOUNT_ID(java.lang.String value) {
		this.ACCOUNT_ID = value;
	}

	public void setBROKER_CODE(java.lang.String value) {
		this.BROKER_CODE = value;
	}

	public void setSECURITY_SYMBOL(java.lang.String value) {
		this.SECURITY_SYMBOL = value;
	}

	public void setCUSIP(java.lang.String value) {
		this.CUSIP = value;
	}

	public void setISIN(java.lang.String value) {
		this.ISIN = value;
	}

	public void setSEDOL(java.lang.String value) {
		this.SEDOL = value;
	}

	public void setCURRENCY(java.lang.String value) {
		this.CURRENCY = value;
	}

	public void setEXPIRATION_DATE(java.sql.Timestamp value) {
		this.EXPIRATION_DATE = value;
	}

	public void setEXECUTION_PRICE(java.math.BigDecimal value) {
		this.EXECUTION_PRICE = value;
	}

	public void setMARKET_PRICE(java.math.BigDecimal value) {
		this.MARKET_PRICE = value;
	}

	public void setQUANTITY(java.math.BigDecimal value) {
		this.QUANTITY = value;
	}

	public void setCREATE_TIMESTAMP(java.sql.Timestamp value) {
		this.CREATE_TIMESTAMP = value;
	}
	
	public void setSECURITY_DATE(java.sql.Timestamp value) {
	   this.SECURITY_DATE = value;
	}

	/**********************************************************************
	 *
	 * Getters
	 *
	 **********************************************************************/
	// @JsonProperty("POSITION_ID")
	public java.lang.String getPOSITION_ID() {
		return this.POSITION_ID;
	}

	// @JsonProperty("ACCOUNT_ID")
	public java.lang.String getACCOUNT_ID() {
		return this.ACCOUNT_ID;
	}

	// @JsonProperty("BROKER_CODE")
	public java.lang.String getBROKER_CODE() {
		return this.BROKER_CODE;
	}

	// @JsonProperty("SECURITY_SYMBOL")
	public java.lang.String getSECURITY_SYMBOL() {
		return this.SECURITY_SYMBOL;
	}

	// @JsonProperty("CUSIP")
	public java.lang.String getCUSIP() {
		return this.CUSIP;
	}

	// @JsonProperty("ISIN")
	public java.lang.String getISIN() {
		return this.ISIN;
	}

	// @JsonProperty("SEDOL")
	public java.lang.String getSEDOL() {
		return this.SEDOL;
	}

	// @JsonProperty("CURRENCY")
	public java.lang.String getCURRENCY() {
		return this.CURRENCY;
	}

	// @JsonProperty("EXPIRATION_DATE")
	public java.sql.Timestamp getEXPIRATION_DATE() {
		return this.EXPIRATION_DATE;
	}

	// @JsonProperty("EXECUTION_PRICE")
	public java.math.BigDecimal getEXECUTION_PRICE() {
		return this.EXECUTION_PRICE;
	}

	// @JsonProperty("MARKET_PRICE")
	public java.math.BigDecimal getMARKET_PRICE() {
		return this.MARKET_PRICE;
	}

	// @JsonProperty("QUANTITY")
	public java.math.BigDecimal getQUANTITY() {
		return this.QUANTITY;
	}
	// @JsonProperty("CREATE_TIMESTAMP")
	public java.sql.Timestamp getCREATE_TIMESTAMP() {
		return this.CREATE_TIMESTAMP;
	}
	// @JsonProperty("SECURITY_DATE")
	public java.sql.Timestamp getSECURITY_DATE() {
	   return this.SECURITY_DATE;
	}

	/**********************************************************
	 * 
	 * This print() method is used for debugging.
	 * 
	 ***********************************************************/
	public void print() {
		log.debug("Transfer object - Begins:");
		String content;
		content = String.format("1.\t%-30s -> [%s]\n", "POSITION_ID", this.getPOSITION_ID());
		log.debug(content);
		content = String.format("2.\t%-30s -> [%s]\n", "ACCOUNT_ID", this.getACCOUNT_ID());
		log.debug(content);
		content = String.format("3.\t%-30s -> [%s]\n", "BROKER_CODE", this.getBROKER_CODE());
		log.debug(content);
		content = String.format("4.\t%-30s -> [%s]\n", "SECURITY_SYMBOL", this.getSECURITY_SYMBOL());
		log.debug(content);
		content = String.format("5.\t%-30s -> [%s]\n", "CUSIP", this.getCUSIP());
		log.debug(content);
		content = String.format("6.\t%-30s -> [%s]\n", "ISIN", this.getISIN());
		log.debug(content);
		content = String.format("7.\t%-30s -> [%s]\n", "SEDOL", this.getSEDOL());
		log.debug(content);
		content = String.format("8.\t%-30s -> [%s]\n", "CURRENCY", this.getCURRENCY());
		log.debug(content);
		content = String.format("9.\t%-30s -> [%s]\n", "EXPIRATION_DATE", this.getEXPIRATION_DATE());
		log.debug(content);
		content = String.format("10.\t%-30s -> [%s]\n", "EXECUTION_PRICE", this.getEXECUTION_PRICE());
		log.debug(content);
		content = String.format("11.\t%-30s -> [%s]\n", "MARKET_PRICE", this.getMARKET_PRICE());
		log.debug(content);
		content = String.format("12.\t%-30s -> [%s]\n", "QUANTITY", this.getQUANTITY());
		log.debug(content);
		content = String.format("13.\t%-30s -> [%s]\n", "CREATE_TIMESTAMP", this.getCREATE_TIMESTAMP());
		log.debug("Transfer object - Ends.");
	}

	@Override
	public String getRowKey() {
		return POSITION_ID;
	}

}