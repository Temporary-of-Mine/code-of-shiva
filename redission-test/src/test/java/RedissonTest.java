import cn.shiva.RedissonServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author shiva   2025-04-02 15:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedissonServerApplication.class})
public class RedissonTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void rdsFirstTest() throws InterruptedException {
        RLock lock = redissonClient.getLock("anyLock");//可重入锁
        //获取锁
        //boolean isLock = lock.tryLock(1, 3, TimeUnit.SECONDS);//参数：等待时间，锁失效时间，时间单位（看门狗机制会失效）
        boolean isLock = lock.tryLock();//不设置参数默认采用看门狗机制,采用默认失效时间30秒
        try {
            if (isLock) {
                System.out.println("获取到分布式锁");
            } else {
                System.out.println("没有获取到");
            }
            //通过睡眠 查看看门狗机制是否生效，不能打断点
            TimeUnit.SECONDS.sleep(60);
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    private static int index = 0;
    @Test
    public void reEntryTest() throws InterruptedException {
        index++;
        RLock lock = redissonClient.getLock("anyLock");//可重入锁
        //获取锁
        boolean isLock = lock.tryLock();//不设置参数默认采用看门狗机制,采用默认失效时间30秒
        try {
            if (isLock) {
                System.out.println("获取到分布式锁");
            } else {
                System.out.println("没有获取到");
            }
            TimeUnit.SECONDS.sleep(10);
            //递归五次，测试一下看看重入是不是生效
            if (index > 5) {
                return;
            }
            //递归调用
            reEntryTest();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

}
