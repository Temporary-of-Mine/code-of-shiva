package cn.demo.shiva.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author shiva   2021/8/16 21:16
 */

@Component
public class TopicCustomer {
    @JmsListener(destination="shiva.topic")
    public void readActiveTopic1(String message) {
        System.out.println("readActiveTopic1接受到：" + message);
    }

    @JmsListener(destination="shiva.topic")
    public void readActiveTopic2(String message) {
        System.out.println("readActiveTopic2接受到：" + message);
    }

}
