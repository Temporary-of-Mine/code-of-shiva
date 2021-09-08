package cn.demo.shiva.confirm;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author shiva   2021/9/8 21:36
 */
@Component
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean arrival, String cause) {
        System.out.println("消息唯一标识：" + correlationData);
        System.out.println("消息是否到达 broker(exchange)：" + arrival);
        System.out.println("失败原因：" + cause);
    }

}
