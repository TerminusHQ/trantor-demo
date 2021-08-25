package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.func.StaffPositionTypeFunc;
import io.terminus.trantor.erp.func.StaffUpdateFunc;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@FlowImpl(name = "update staff flow impl")
public class StaffUpdateFlowImpl implements StaffUpdateFlow {
    private StaffPositionTypeFunc staffPositionTypeFunc;
    private StaffUpdateFunc staffUpdateFunc;

    @Override
    public void execute(Staff staff) {
        // 根据不同岗位类型做不同处理
        staffPositionTypeFunc.execute(staff);

        // 更新员工信息
        staffUpdateFunc.execute(staff);
    }
}
