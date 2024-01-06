package kr.or.ddit.basic;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.*;
import org.quartz.impl.*;

public abstract class ChainableJob implements Job {
	   private static final String CHAIN_JOB_CLASS = "chainedJC";
	   private static final String CHAIN_JOB_NAME = "chainedJN";
	   private static final String CHAIN_JOB_GROUP = "chainedJG";
	   
	   @Override
	   public void execute(JobExecutionContext context) throws JobExecutionException {
		   
		   //작업 실행
		   doExecute(context);
	 
		   //체인 작업이 설정되었는지 확인
	      if (context.getJobDetail().getJobDataMap().get(CHAIN_JOB_CLASS) != null) {
	         try {
	        	 //체인 작업 실행
	            chain(context);
	         } catch (SchedulerException e) {
	            e.printStackTrace();
	         }
	      }
	   }
	   
	   private void chain(JobExecutionContext context) throws SchedulerException {
		   //체인 작업을 위한 정보 가져오기
		   JobDataMap map = context.getJobDetail().getJobDataMap();
	      @SuppressWarnings("unchecked")
	      Class jobClass = (Class) map.remove(CHAIN_JOB_CLASS);
	      String jobName = (String) map.remove(CHAIN_JOB_NAME);
	      String jobGroup = (String) map.remove(CHAIN_JOB_GROUP);
	      
	      // 새로운 잡 생성
	      JobDetail jobDetail = newJob(jobClass)
	            .withIdentity(jobName, jobGroup)
	            .usingJobData(map)
	            .build();
	       
	      // 새로운 트리거 생성
	      Trigger trigger = newTrigger()
	            .withIdentity(jobName + "Trigger", jobGroup + "Trigger")
	                  .startNow()      
	                  .build();
	      //체인 작업 스케줄링
	      System.out.println("Chaining (Trigger에있는 syso!!!)" + jobName);
	      StdSchedulerFactory.getDefaultScheduler().scheduleJob(jobDetail, trigger);
	   }
	 
	   protected abstract void doExecute(JobExecutionContext context) 
	                                    throws JobExecutionException;
	   
	   protected void chainJob(JobExecutionContext context, 
	                          Class jobClass, 
	                          String jobName, 
	                          String jobGroup) {
		   // JobDataMap에 값 저장
	      JobDataMap map = context.getJobDetail().getJobDataMap();
	      map.put(CHAIN_JOB_CLASS, jobClass);
	      map.put(CHAIN_JOB_NAME, jobName);
	      map.put(CHAIN_JOB_GROUP, jobGroup);
	   }
}
