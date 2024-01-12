package tt;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Test04 implements Job{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getMergedJobDataMap();
        String myData = dataMap.getString("myData");
        System.out.println("가져온 myData 값 : " + myData);
    }
}
