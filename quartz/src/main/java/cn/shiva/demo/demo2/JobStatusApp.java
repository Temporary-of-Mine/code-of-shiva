package cn.shiva.demo.demo2;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author shiva   2021/10/2 12:04
 */
public class JobStatusApp {

    public static void main(String[] args) throws Exception {
        // 1.创建调度器 Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 2.创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail job = JobBuilder.newJob(JobStatus.class)
                .withIdentity("statusJob", "group1")
                .usingJobData("count", 1L)
                .build();

        // 3.构建Trigger实例,每隔30s执行一次
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("statusTrigger", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        // 4.执行，开启调度器
        scheduler.scheduleJob(job, trigger);
        System.out.println(System.currentTimeMillis());
        scheduler.start();

        //主线程睡眠1分钟，然后关闭调度器
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println(System.currentTimeMillis());
    }
}
