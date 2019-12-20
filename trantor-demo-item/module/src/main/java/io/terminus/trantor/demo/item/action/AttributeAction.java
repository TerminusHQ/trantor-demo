package io.terminus.trantor.demo.item.action;

import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TEnvParam;
import io.terminus.trantor.demo.item.model.Attribute;
import io.terminus.trantor.exception.ActionErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/9
 */
@Slf4j
@Component
public class AttributeAction {
    @TAction(modelClass = Attribute.class, nextSystem = TAction.NextKey.CREATE)
    public void create(Attribute attribute) {
        if (attribute.isRequired()) {
            throw new ActionErrorException("这是一个自定义异常");
        }
    }

    @TAction(modelClass = Attribute.class)
    public void testEnv(@TEnvParam Map<String, Object> env) {
        log.info("get env: {}", env);
    }
}
