package cn.demo.shiva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiva   2021/8/14 0:24
 */
@RestController
@RequestMapping("test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("debug")
    public String debug() {
        logger.info("controller 处理请求");
        int i = 0;
        i = 1 / i;
        return "";
    }
}
