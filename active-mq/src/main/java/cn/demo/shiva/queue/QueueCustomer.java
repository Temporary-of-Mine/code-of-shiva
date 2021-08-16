package cn.demo.shiva.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author shiva   2021/8/15 21:54
 */
@Component
public class QueueCustomer {

    @JmsListener(destination="XKSNASWNSH")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }

}
