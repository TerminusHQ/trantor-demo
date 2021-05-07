package io.terminus.trantor.custom.demo.flow.impl;

import io.terminus.trantor.demo.flow.CreatePositionFlow;
import io.terminus.trantor.demo.func.CreatePositionFunc;
import io.terminus.trantor.demo.model.Position;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;

/**
 * 
 * @author: Chen Gong
 * @date：2021/5/7 3:59 下午
 */
@FlowImpl(name = "create other position with dynamic route")
@RouteRuleValue({"middle_High"})
public class CustomCreatePositionFlowImpl implements CreatePositionFlow {

    private CreatePositionFunc createPositionFunc;

    @Override
    public Position execute(Position position) {
        Position result = createPositionFunc.execute(position);
        return result;
    }
}
