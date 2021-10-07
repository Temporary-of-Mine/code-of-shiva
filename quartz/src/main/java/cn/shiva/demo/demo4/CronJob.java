package cn.shiva.demo.demo4;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author shiva   2021/10/3 15:11
 */
public class CronJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务执行。。。");
    }
}
