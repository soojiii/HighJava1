package kr.or.ddit.basic.q;

import java.util.Timer;
import java.util.TimerTask;
  
public class Test01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello, World!");
            }
        };
         // 작업이 처음 실행될 시간(0즉시), 반복될 시간 간격(5000은 5초)
        timer.schedule(task, 0, 5000); 
    }
}
