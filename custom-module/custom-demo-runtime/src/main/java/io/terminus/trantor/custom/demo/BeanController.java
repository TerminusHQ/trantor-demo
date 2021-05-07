package io.terminus.trantor.custom.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Chen Gong
 * @date：2021/5/7 3:48 下午
 */
@RestController
@RequestMapping
public class BeanController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/beanList")
    public List<String> beanList() {
        return Arrays.asList(applicationContext.getBeanDefinitionNames());
    }
}
