package com.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guozhenhua
 * @date 2020/07/06
 */
@RefreshScope
@RestController
public class TestController {

    @Value("${info.from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }
}
