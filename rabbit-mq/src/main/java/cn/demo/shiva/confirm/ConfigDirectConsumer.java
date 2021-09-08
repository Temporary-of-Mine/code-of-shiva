package cn.demo.shiva.confirm;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author shiva   2021/9/4 21:46
 */
@Component
@RabbitListener(queues = "directQueue")
public class ConfigDirectConsumer {

    @RabbitHandler
    public void process(Map<String, Object> message) {
        System.out.println("消费者收到消息  : " + message.toString());
    }
}
