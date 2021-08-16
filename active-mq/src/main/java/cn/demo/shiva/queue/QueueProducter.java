package cn.demo.shiva.queue;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shiva   2021/8/15 21:13
 */
@Component
public class QueueProducter {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 直接传入名称，这种情况下，会自动创建 对应名称 的队列
     */
    public void sendQueueMsg(String queueName, String message){
        jmsMessagingTemplate.convertAndSend(queueName, message);
    }

}
