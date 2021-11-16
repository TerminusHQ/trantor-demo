package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.dict.PositionType;
import io.terminus.trantor.erp.func.StaffCreateFunc;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import lombok.RequiredArgsConstructor;

/**
 * @author trantor@terminus.io
 * @date 2021/06/25
 */
@RouteRuleValue({PositionType.PRIMARY})
@RequiredArgsConstructor
@FlowImpl(name = "trantor primary staff create flow impl")
public class PrimaryStaffCreateFlowImpl implements StaffCreateFlow {
    private final StaffCreateFunc staffCreateFunc;
    @Override
    public void execute(Staff staff) {
        staffCreateFunc.execute(staff);
    }
}
