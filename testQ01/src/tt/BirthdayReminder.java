package tt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthdayReminder {

    public static void main(String[] args) {
        try {
            // 스케줄러 팩토리 생성
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            // JobDetail 생성
            JobDetail jobDetail = JobBuilder.newJob(BirthdayJob.class)
                    .withIdentity("birthdayJob", "group1")
                    .build();

            // 생일에 해당하는 날짜와 시간 지정
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date birthdate = dateFormat.parse("2024-01-06 17:14:00");

            // Trigger 생성
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("birthdayTrigger", "group1")
                    .startAt(birthdate)
                    .build();

            // Job과 Trigger를 스케줄러에 등록
            scheduler.scheduleJob(jobDetail, trigger);

            // 스케줄러 실행
            scheduler.start();

        } catch (SchedulerException | ParseException e) {
            e.printStackTrace();
        }
    }
}

class BirthdayJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 생일 알람을 울리는 로직을 여기에 작성합니다.
        System.out.println("Happy Birthday!");
    }
}

