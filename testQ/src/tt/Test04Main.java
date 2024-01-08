package tt;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.newTrigger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Test04Main {
    public static void main(String[] args) throws Exception {
    	try {
			
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
        //작업 정의
        JobDetail job1 = JobBuilder.newJob(Test04.class)
//      JobDetail job = newJob(Test02.class)
        		
        	 // 작업 식별자 설정
            .withIdentity("myJob1", "group1")
            
             // myData 키로 데이터 추가
            .usingJobData("myData1", "안녕! 쿼츠1!")
            .build();
        LocalDateTime alarmTime1 = LocalDateTime.of(2024, 1, 8, 10, 51);
        Date alarmDate1 = Date.from(alarmTime1.atZone(ZoneId.systemDefault()).toInstant());
        
        
        JobDetail job2 = JobBuilder.newJob(Test04.class)
        		
        		.withIdentity("myJob2", "group1")
        		.usingJobData("myData2", "안녕! 쿼츠2!")
        		.build();
        
        LocalDateTime alarmTime2 = LocalDateTime.of(2024, 1, 8, 10, 51);
        Date alarmDate2 = Date.from(alarmTime2.atZone(ZoneId.systemDefault()).toInstant());
        
        
        
        //언제 시작해서 얼마나 자주 반복할지 정의
        Trigger trigger1 = TriggerBuilder.newTrigger()
//      Trigger trigger = newTrigger()
        		
        	// 트리거 식별자 설정
            .withIdentity("myTrigger1", "group1") 
            
            .startAt(alarmDate1)		//입력된 날에 시작
//          .startNow()  //즉시 시작
            
            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//          .withSchedule(simpleSchedule()
                .withIntervalInSeconds(10)	//초
//              .withIntervalInMinutes(n)	//n분
//              .withIntervalInHours(n)  	//n시간
//              .withIntervalInDays(n)		//n일
                
                .repeatForever())   //계속반복
//              .repeat()		//n만큼 반복
            
            // 작업 지정
            .forJob("myJob1", "group1") 
            .withPriority(10)
            .build();
        
        
        Trigger trigger2 = TriggerBuilder.newTrigger()
        		
        		.withIdentity("myTrigger2", "group1") 
        		.startAt(alarmDate2)
        		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
        		.withIntervalInSeconds(10)
        		.repeatForever())
        		
        		.forJob("myJob2", "group1") 
        		.withPriority(20)
        		.build();
        
//        job1.getJobDataMap().put("priority", 10);
//        job2.getJobDataMap().put("priority", 20);

        scheduler.start();
        
        scheduler.scheduleJob(job1, trigger1);
        scheduler.scheduleJob(job2, trigger2);

        
        Thread.sleep(6000);
        
        scheduler.shutdown();
        
	} catch (SchedulerException | InterruptedException e) {
		e.printStackTrace();
	}
    	
    }
}
