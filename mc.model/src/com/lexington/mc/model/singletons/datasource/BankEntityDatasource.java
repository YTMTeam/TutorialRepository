package com.lexington.mc.model.singletons.datasource;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.blockchain.pojos.BankPojo;
import com.lexington.mc.model.entities.EntityBank;
import com.lexington.mc.model.entities.EntityEmployee;
import com.lexington.mc.model.util.IEntityDatasourceCreator;

public class BankEntityDatasource implements IEntityDatasourceCreator {
  
	private static ArrayList<EntityBank> banks = new ArrayList<>();
	
	public static ArrayList<EntityBank> getAll() {
		return banks;
	}
 

	public static EntityBank getByBankId(BigDecimal bank_ID) {
		for(EntityBank e :banks){
			if(e.getBank().getBANK_ID().equals(bank_ID)){
				return e;	
			}	
		}
		return null;
	}
	
    public static EntityBank getBankByBankCode(String bankCode) {
       for(EntityBank bank : banks) {
          if(bank.getBank().getBANK_CODE().equals(bankCode)) {
             return bank;
          }
          
       }
       return null;
    }	
	
}
