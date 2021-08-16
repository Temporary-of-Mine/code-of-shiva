package cn.demo.shiva.controller;

import cn.demo.shiva.queue.QueueProducter;
import cn.demo.shiva.topic.TopicProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiva   2021/8/15 20:51
 */
@RestController
public class ProducerController {

    @Autowired
    private QueueProducter queueProducter;
    @Autowired
    private TopicProducter topicProducter;

    @RequestMapping("send")
    public void send(){
        queueProducter.sendQueueMsg("XKSNASWNSH", String.valueOf(Math.random()));
    }

    @RequestMapping("topicMsg")
    public void topicMsg(){
        topicProducter.sendTopicMsg(String.valueOf(Math.random()));
    }

}
