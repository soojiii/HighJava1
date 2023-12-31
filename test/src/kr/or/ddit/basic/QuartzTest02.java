package kr.or.ddit.basic;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest02 {
	public static void main(String[] args) throws SchedulerException {
		
		//job 생성
		JobDetail job = JobBuilder.newJob(MyJob.class)
				.withIdentity("myJob","group1")
				.build();
		
		// Trigger 생성
		Trigger trigger = TriggerBuilder.newTrigger()
			.withIdentity("myTrigger", "group1")
			.startNow()
			.withSchedule(SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(10)
					.repeatForever())
			.build();
		
		// 스케줄러 생성 및 Job, Trigger 등록
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.start();
		scheduler.scheduleJob(job, trigger);

	}
}

