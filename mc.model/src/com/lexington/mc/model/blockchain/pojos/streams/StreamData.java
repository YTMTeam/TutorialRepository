package com.lexington.mc.model.blockchain.pojos.streams;



import com.mallocinc.database.generated.to.AccountTo;
import com.mallocinc.database.generated.to.BankTo;
import com.mallocinc.database.generated.to.HouseholdTo;
import com.mallocinc.database.generated.to.MonitorTo;
import com.mallocinc.database.generated.to.PositionTo;
import com.mallocinc.database.generated.to.TradeTo;
import com.mallocinc.database.generated.to.UsersTo;

public class StreamData {
    String type;
    Object data;
    
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
    
    
   
}
