package io.terminus.trantor.demo.user.biz;

import io.terminus.trantor.api.ConditionHandler;
import org.springframework.stereotype.Component;

/**
 * @author Xyf
 */
@Component
public class TestConditionHandler implements ConditionHandler {
    @Override
    public HandlerConsumer handler() {
        return (context, request, response) -> context.addVariable("test", "test");
    }
}
