package io.homo.efficio.scratchpad.quartz;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
	
	@Test
	public void helloJob() throws SchedulerException, InterruptedException{
		
		JobDetail jobDetail = newJob(HelloJob.class).build();
		
		Trigger trigger = newTrigger().build();
		
		Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
		defaultScheduler.start();
		defaultScheduler.scheduleJob(jobDetail, trigger);
		Thread.sleep(3*1000);
		
		defaultScheduler.shutdown(true);
		
		
	}
}
