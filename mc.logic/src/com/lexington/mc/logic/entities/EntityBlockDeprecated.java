package com.lexington.mc.logic.entities;

import com.mallocinc.database.generated.to.BlockTo;

public class EntityBlockDeprecated {
	BlockTo to =new BlockTo();

	
	
	public EntityBlockDeprecated(BlockTo to2) {
		this.to=to2;
	}

	public BlockTo getTo() {
		return to;
	}

	public void setTo(BlockTo to) {
		this.to = to;
	}
	
	
}
