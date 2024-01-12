package kr.or.ddit.basic.q;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Job01 implements Job {
	
	@Override
	public void execute(JobExecutionContext input) throws JobExecutionException {
		JobDataMap in = input.getJobDetail().getJobDataMap();
		HashMap<String, Phone2> list = (HashMap<String, Phone2>) in.get("list");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String Time = sdf.format(new Date());
		
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("f:/d_other/phone2Book.data")));

			for (String a : list.keySet()) {
				oout.writeObject(list.get(a));
			}
			oout.writeObject(null);
			System.out.println();
			System.out.println("** 자동 저장 완료  " + Time+" **");
			oout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
