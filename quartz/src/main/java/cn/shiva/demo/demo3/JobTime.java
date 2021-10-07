package cn.shiva.demo.demo3;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author shiva   2021/10/2 12:23
 */
public class JobTime implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("任务执行。。。");
        System.out.println(context.getTrigger().getStartTime());
        System.out.println(context.getTrigger().getEndTime());
    }

}
