package io.terminus.trantor.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author: husc 2020-07-23 上午9:43
 */
@RestController
@RequestMapping("/api")
public class HealthCheckController {

    @GetMapping("/health")
    public String check(){
        return "ok";
    }
}
