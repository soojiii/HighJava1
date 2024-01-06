package kr.or.ddit.basic;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

import org.quartz.*;

public class TestJob extends ChainableJob{

	   @Override
	   protected void doExecute(JobExecutionContext context) 
	                                   throws JobExecutionException {
		   
		   // 
	      JobDataMap map = context.getJobDetail().getJobDataMap();
	      System.out.println("Executing " + context.getJobDetail().getKey().getName() 
	                         + " with " + new LinkedHashMap(map));
	      
	      boolean alreadyChained = map.get("jobValue") != null;
	      if (!alreadyChained) {
	         map.put("jobTime", new Date().toString());
	         map.put("jobValue", new Random().nextLong());
	      }
	      
	      if (!alreadyChained && new Random().nextBoolean()) {
	         chainJob(context, TestJob.class, "secondJob", "secondJobGroup");
	      }
	   }
}
