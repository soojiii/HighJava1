package tt;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Test04 implements Job{
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getMergedJobDataMap();
        
        int priority = dataMap.getInt("priority");
        
        String myData1 = dataMap.getString("myData1");
        String myData2 = dataMap.getString("myData2");
        
        
        System.out.println("가져온 myData1 값 : " + myData1);
        System.out.println("가져온 myData2 값 : " + myData2);
        
    }
}
