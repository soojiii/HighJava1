package kr.or.ddit.basic;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("## Hello Quartz!!!!!!!!!");
		System.out.println("뭐야");
	}
	
	private void beforeExecute(JobExecutionContext context) {
		log.info("## Hello Quartz!!!!!!!!!");
		System.out.println("뭐야1");
		
	}
    
    private void afterExecute(JobExecutionContext context) {
    	log.info("## Hello Quartz!!!!!!!!!");
    	System.out.println("뭐야2");
    }

    private void scheduleNextJob(JobExecutionContext context) {
    	log.info("## Hello Quartz!!!!!!!!!");
    	System.out.println("뭐야3");
    }
	
	
}