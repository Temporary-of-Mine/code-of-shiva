package cn.demo.shiva.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author shiva   2021/8/16 21:13
 */
@Component
public class TopicProducter {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    public void sendTopicMsg(String message){
        ActiveMQTopic destination = new ActiveMQTopic("shiva.topic");
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
