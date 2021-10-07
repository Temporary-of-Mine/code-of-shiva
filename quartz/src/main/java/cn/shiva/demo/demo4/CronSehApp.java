package cn.shiva.demo.demo4;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author shiva   2021/10/2 12:25
 */
public class CronSehApp {

    public static void main(String[] args) throws Exception {
        // 1.创建调度器 Scheduler
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();

        // 2.创建JobDetail实例，并与Job类绑定(Job执行内容)
        JobDetail job = JobBuilder.newJob(CronJob.class)
                .withIdentity("job1", "group1")
                .build();

        // 3.构建Trigger实例
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?"))
                .build();

        // 4.执行，开启调度器
        scheduler.scheduleJob(job, trigger);
        System.out.println(System.currentTimeMillis());
        scheduler.start();
    }

}
