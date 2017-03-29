package com.lexington.mc.logic.entities;

import com.lexington.mc.model.blockchain.common.BlockchainConstants;
import com.mallocinc.database.generated.to.VTradeTo;

public class EntityVPaymentDeprecated {
	VTradeTo to=new VTradeTo();

	
	
	public EntityVPaymentDeprecated(VTradeTo to) {
		super();
		this.to = to;
	}

	public VTradeTo getTo() {
		return to;
	}

	public void setTo(VTradeTo to) {
		this.to = to;
	}
	
	public boolean isBuyDirection(){
		return BlockchainConstants.DirectionStatus.BUY.equals(to.getTRANSACTION_TYPE()); 
		
	}
	
	public boolean isSellDirection(){
		return BlockchainConstants.DirectionStatus.SELL.equals(to.getTRANSACTION_TYPE()); 
		
	}
	
	 
	
}
