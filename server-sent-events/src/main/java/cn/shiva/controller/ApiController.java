package cn.shiva.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shiva   2025-04-05 0:15
 */
@Controller
@RequestMapping(value = "/")
public class ApiController {

    @RequestMapping({"/index", ""})
    public String index() {
        return "index";
    }

}
