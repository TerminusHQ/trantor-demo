package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.dict.PositionType;
import io.terminus.trantor.erp.func.StaffCreateFunc;
import io.terminus.trantor.erp.func.StaffValidationFunc;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import lombok.RequiredArgsConstructor;

/**
 * @author trantor@terminus.io
 * @date 2021/06/25
 */
@RouteRuleValue({PositionType.MIDDLE,PositionType.HIGH})
@RequiredArgsConstructor
@FlowImpl(name = "trantor staff create flow impl")
public class StaffCreateFlowImpl implements StaffCreateFlow {
    private final StaffValidationFunc staffValidationFunc;
    private final StaffCreateFunc staffCreateFunc;
    @Override
    public void execute(Staff staff) {

        // 前置校验
        staffValidationFunc.execute(staff);
        // 创建员工
        staffCreateFunc.execute(staff);
    }
}
