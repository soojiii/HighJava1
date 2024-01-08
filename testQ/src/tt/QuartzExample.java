package tt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzExample {
    public static void main(String[] args) {
        try {
            // 스케줄러 팩토리 생성
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            // 작업(Job) 생성
            JobDetail job = JobBuilder.newJob(HelloJob.class)
                    .withIdentity("helloJob", "group1")
                    .build();

            // 트리거(Trigger) 생성
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("helloTrigger", "group1")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(5)
                            .repeatForever())
                    .build();

            // 작업과 트리거 스케줄에 등록
            scheduler.scheduleJob(job, trigger);

            // 스케줄러 실행
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}


