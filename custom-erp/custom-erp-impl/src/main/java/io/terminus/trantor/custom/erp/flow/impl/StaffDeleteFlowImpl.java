package io.terminus.trantor.custom.erp.flow.impl;

import io.terminus.trantor.custom.erp.flow.StaffDeleteFlow;
import io.terminus.trantor.custom.erp.func.FreeEquFunc;
import io.terminus.trantor.erp.func.StaffDeleteFunc;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
@FlowImpl(name = "删除员工flow")
public class StaffDeleteFlowImpl implements StaffDeleteFlow {

    private StaffDeleteFunc staffDeleteFunc;

    private FreeEquFunc freeEquFunc;

    @Override
    public void execute(Staff staff) {
        // 删除员工
        staffDeleteFunc.execute(staff);

        //修改设备状态为空闲
        freeEquFunc.execute(staff.getEquipment());

    }
}
