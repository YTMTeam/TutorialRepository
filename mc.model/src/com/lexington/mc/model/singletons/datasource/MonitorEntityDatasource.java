package com.lexington.mc.model.singletons.datasource;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.lexington.mc.model.entities.EntityMonitor;
import com.lexington.mc.model.util.IEntityDatasourceCreator;
import com.lexington.mc.model.util.UtilCodeTypes;
import com.mallocinc.shared.util.time.TimestampUtility;

public class MonitorEntityDatasource implements IEntityDatasourceCreator {
   private static UtilCodeTypes uct = new UtilCodeTypes();
   private static ArrayList<EntityMonitor> monitors = new ArrayList<>();

   public static ArrayList<EntityMonitor> getAll() {
      return monitors;
   }

   public static ArrayList<EntityMonitor> getMonitorsByStatusAndTypeAndBank(String status, String type,
         BigDecimal bank_ID) {
      ArrayList<EntityMonitor> monitors = new ArrayList<>();

      for(EntityMonitor monitor : MonitorEntityDatasource.getAll()) {
         String currentStatus = null;
         String currentType = null;

         if(monitor.getMonitor().getEND_DATE() == null || monitor.getMonitor().getEND_DATE().after(TimestampUtility.getCurrentTimestamp())) {
            currentStatus = uct.MonitorStatus.Codes.ACTIVE;
         }
         else {
            currentStatus = uct.MonitorStatus.Codes.PASSED;
         }


         if(!monitor.getEntityEmployee().getEmployee().getBANK_ID().equals(bank_ID) && ! monitor.getEntityAccount().getAccount().getBANK_ID().equals(bank_ID)) {
            continue;
         }


         if(monitor.getEntityAccount().getAccount().getBANK_ID().equals(bank_ID)) {
            currentType = uct.MonitorType.Codes.INTERNAL;
         }

         if(monitor.getEntityEmployee().getEmployee().getBANK_ID().equals(bank_ID)) {
            currentType = uct.MonitorType.Codes.EXTERNAL;

         }


         if(status.equals(currentStatus) && type.equals(currentType)) {
            if(uct.YesNoIndicator.Codes.YES.equals(monitor.getMonitor().getEMP_BANK_APPROVED())
                  && uct.YesNoIndicator.Codes.YES.equals(monitor.getMonitor().getOUT_BANK_APPROVED())) {

               monitors.add(monitor);
            }
         }
      }


      return monitors;
   }




}
