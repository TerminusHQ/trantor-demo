package io.terminus.trantor.demo.staff.flow.impl;

import io.terminus.trantor.demo.staff.flow.CreatePositionFlow;
import io.terminus.trantor.demo.staff.func.CreatePositionFunc;
import io.terminus.trantor.demo.staff.func.CreateStaffFunc;
import io.terminus.trantor.demo.staff.model.Position;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;

/**
 * @author liuyayue
 * @create 2021/4/22 7:56 下午
 */
@FlowImpl(name = "create position with dynamic route")
@RouteRuleValue({"high"})

public class CreateHighPositionFlowIImpl implements CreatePositionFlow {

    private CreatePositionFunc createPositionFunc;

    private CreateStaffFunc createStaffFunc;

    @Override
    public Position execute(Position position) {
        //创建高级岗位时可以添加其他的逻辑
        //比如创建高级岗位同时创建该岗位下的员工
        Position result = createPositionFunc.execute(position);
        return result;
    }
}
