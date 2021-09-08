package cn.demo.shiva.confirm;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author shiva   2021/9/8 21:41
 */
@Component
public class ReturnsCallback implements RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setReturnsCallback(this);
    }

    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.println("消息主体 message : " + returnedMessage.getMessage());
        System.out.println("消息主体 message : " + returnedMessage.getReplyCode());
        System.out.println("描述：" + returnedMessage.getReplyText());
        System.out.println("消息使用的交换器 exchange : " + returnedMessage.getExchange());
        System.out.println("消息使用的路由键 routing : " + returnedMessage.getRoutingKey());
    }
}
