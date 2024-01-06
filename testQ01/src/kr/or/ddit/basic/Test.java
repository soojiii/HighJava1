package kr.or.ddit.basic;

import org.quartz.*;
import org.quartz.impl.*;

public class Test {
	  public static void main(String[] args) throws Exception {
		  
	      //스케줄러 시작
	      StdSchedulerFactory.getDefaultScheduler().start();
	      
	      // 작업 생성
	      JobDetail job = JobBuilder.newJob(TestJob.class)
	             .withIdentity("fJob", "fJobGroup").build();
	 
	      // 작업 트리거 생성
	      Trigger trigger = TriggerBuilder.newTrigger()
	            .withIdentity("fJobT", "fJobTGroup")
	            .startNow()
	            .withSchedule(
	            		//1초 간격으로 무한반복
	                  SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
	                  .repeatForever()).build();
	 
	      // 스케줄러에 작업, 트리거
	      StdSchedulerFactory.getDefaultScheduler().scheduleJob(job, trigger);
	      
	      // 5초 대기
	      Thread.sleep(5000);  
	      
	      //스케줄러 종료
	      StdSchedulerFactory.getDefaultScheduler().shutdown();
	   }
	  
}
