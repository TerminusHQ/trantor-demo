package io.terminus.trantor.demo.staff.flow.impl;

import io.terminus.trantor.demo.staff.flow.CreatePositionFlow;
import io.terminus.trantor.demo.staff.func.CreatePositionFunc;
import io.terminus.trantor.demo.staff.model.Position;

/**
 * @author liuyayue
 * @create 2021/4/22 08:53 下午
 */
public class CreateOtherPositionFlowImpl implements CreatePositionFlow {

    private CreatePositionFunc createPositionFunc;

    @Override
    public Position execute(Position position) {
        Position result = createPositionFunc.execute(position);
        return result;
    }
}
