package tt;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
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
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        
        //작업 정의
        JobDetail job = JobBuilder.newJob(Test04.class)
//      JobDetail job = newJob(Test02.class)
        		
        	 // 작업 식별자 설정
            .withIdentity("myJob", "group1")
            
             // myData 키로 데이터 추가
            .usingJobData("myData", "안녕! 쿼츠!")
            .build();
        
        LocalDateTime alarmTime = LocalDateTime.of(2024, 1, 8, 20, 28);  //(년, 월, 일, 시, 분, 초)
        Date alarmDate = Date.from(alarmTime.atZone(ZoneId.systemDefault()).toInstant()); //해당 시간을-> 현재 시스템의 기본 시간
        
        //언제 시작해서 얼마나 자주 반복할지 정의
        Trigger trigger = TriggerBuilder.newTrigger()
//      Trigger trigger = newTrigger()
        		
        	// 트리거 식별자 설정
            .withIdentity("myTrigger", "group1") 
            
            .startAt(alarmDate)		//입력된 날에 시작
//          .startNow()  //즉시 시작
            
            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//          .withSchedule(simpleSchedule()
            		
                .withIntervalInSeconds(1)	//초
                
            		.withRepeatCount(2)) // 3번 반복
            		.build();
            
        
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        scheduler.shutdown();
    }
}
