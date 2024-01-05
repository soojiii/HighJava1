package kr.or.ddit.basic;
//  스케쥴러 사용하려면 먼저 인스턴스화 해야하는데 이를 위해
//  ==> SchedulerFactory 를 사용.

//  하나하나씩 import 해오면 너무 많으므로 맨 뒤에 * 로 다 가져옴
import org.quartz.*;
import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.CalendarIntervalScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;


// 스케줄러를 인스턴스화 및 시작하고 실행할 작업을 예약하는 코드 조각
public class QuartzTest01 {
    public static void main(String[] args) throws SchedulerException {
        SchedulerFactory schedFact = new org.quartz.impl.StdSchedulerFactory();

        Scheduler sched = schedFact.getScheduler();

        sched.start();

        // Job을 정의하고 HelloJob.class에 연결
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Job을 실행한 다음 40초마다 실행함.
        Trigger trigger = newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // 작업예약 지시??
        sched.scheduleJob(job, trigger);
    }
}


