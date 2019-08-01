package org.study.thread;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by ArnoldLee on 17/9/20.
 */
public class MultiThreadLong {
    public static Long t = 0L;

    public static class ChangeT implements Runnable{
        private Long to;

        public ChangeT(Long to) {
            this.to = to;
        }

        @Override
        public void run() {
            while (true){
                MultiThreadLong.t = to;
                Thread.yield();
            }

        }
    }

    public static class ReadT implements Runnable{
        @Override
        public void run() {
            while (true){
                Long tmp = MultiThreadLong.t;
                if(tmp!=111L && tmp!=-999L && tmp!= 333L && tmp!= -444L){
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
//        Date nowTime = new Date();
//        DateFormat dateFormat = DateFormat.getTimeInstance();
//        //当前时间字符串,xx:xx:xx格式
//        String nowTimeFormatTempStr = dateFormat.format(nowTime);
//        //取出小时
//        String nowTimeHourStr = nowTimeFormatTempStr.split(":")[0];
//        int nowTimeHourEnd = Integer.valueOf(nowTimeHourStr).intValue();
//        //默认往前推1小时
//        int nowTimeHourStart = nowTimeHourEnd-1;
//        System.out.println(nowTimeHourEnd+","+nowTimeHourStart);
    }

}
