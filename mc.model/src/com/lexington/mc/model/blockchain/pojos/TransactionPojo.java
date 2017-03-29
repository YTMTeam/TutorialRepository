package com.lexington.mc.model.blockchain.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class TransactionPojo extends PojoApi{
     String blockhash;
	 String txid;
	 String txHash;
	 BigDecimal version;
	 BigDecimal locktime;
	 ArrayList<String> data;
	 String streamType;


	public String getTxHash() {
		return txHash;
	}
	public void setTxHash(String txHash) {
		this.txHash = txHash;
	}
	public BigDecimal getVersion() {
		return version;
	}
	public void setVersion(BigDecimal version) {
		this.version = version;
	}
	public BigDecimal getLocktime() {
		return locktime;
	}
	public void setLocktime(BigDecimal locktime) {
		this.locktime = locktime;
	}
	public ArrayList<String> getData() {
		return data;
	}
	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public String getTxid() {
      return txid;
   }
   public void setTxid(String txid) {
      this.txid = txid;
   }
   public String getStreamType() {
		return streamType;
	}
	public void setStreamType(String streamType) {
		this.streamType = streamType;
	}

   public String getBlockhash() {
      return blockhash;
   }
   public void setBlockhash(String blockhash) {
      this.blockhash = blockhash;
   }
	
   public String getRowKey() {
      return txid.toString();
   }
}
