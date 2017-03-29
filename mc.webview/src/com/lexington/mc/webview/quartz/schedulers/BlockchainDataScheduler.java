package com.lexington.mc.webview.quartz.schedulers;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.lexington.mc.model.util.UtilCodeTypes;
import com.lexington.mc.webview.quartz.jobs.BlockchainJob;
import com.mallocinc.shared.util.time.TimestampUtility;

public class BlockchainDataScheduler {
	final Logger            log       = Logger.getLogger(BlockchainDataScheduler.class.getName());
	UtilCodeTypes uct = new UtilCodeTypes();
	public static Scheduler scheduler = null;

	private final String KEY_PREFIX = "blockchain_scheduler_";
	
	
	public void startScheduledDataProvider(BigDecimal timeOut) {

		String jobKeyString = KEY_PREFIX + TimestampUtility.getCurrentTimestampString();

		JobKey jobKey = new JobKey(jobKeyString);

		JobDetail instanceJobDetail = JobBuilder.newJob(BlockchainJob.class).withIdentity(jobKey).build();

		Trigger trigger = TriggerBuilder.newTrigger()
				.startNow()
		        .withSchedule(SimpleScheduleBuilder.simpleSchedule()
			   	.withIntervalInSeconds(timeOut.intValue())
		        .repeatForever())
			    .forJob(jobKeyString)
			    .build();
		
		Scheduler scheduler;

		try {

			scheduler = getScheduler();
			scheduler.start();
			scheduler.scheduleJob(instanceJobDetail, trigger);
			System.out.println();

		} catch (SchedulerException e) {
		}
	}
	Scheduler getScheduler() {
		if (scheduler == null) {
			try {
				scheduler = new StdSchedulerFactory().getScheduler();

			} catch (SchedulerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return scheduler;
	}
}