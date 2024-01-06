package io.homo.efficio.scratchpad.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class HelloJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("## Hello Quartz!!!!!!!!!");
	}
	
	
}
