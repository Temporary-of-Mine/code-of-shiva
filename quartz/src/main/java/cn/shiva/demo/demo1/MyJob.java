package cn.shiva.demo.demo1;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author shiva   2021/10/1 21:28
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println(context.getJobDetail().getJobDataMap().get("tiggerDataMap"));
        System.out.println("任务被执行了。。。");
    }
}
