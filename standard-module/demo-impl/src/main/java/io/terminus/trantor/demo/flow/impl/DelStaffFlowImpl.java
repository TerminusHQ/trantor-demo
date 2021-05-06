package io.terminus.trantor.demo.flow.impl;

import io.terminus.trantor.demo.flow.DelStaffFlow;
import io.terminus.trantor.demo.func.DelStaffAndEquFunc;
import io.terminus.trantor.demo.func.DelStaffFunc;
import io.terminus.trantor.demo.func.EnableEquFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author liuyayue
 * @create 2021/4/21 9:09 下午
 */
@FlowImpl(name = "del staff Flow impl")
public class DelStaffFlowImpl implements DelStaffFlow {

    private DelStaffFunc delStaffFunc;

    private EnableEquFunc enableEquFunc;

    private DelStaffAndEquFunc delStaffAndEquFunc;

    @Override
    public BooleanResult execute(Staff staff) {

        BooleanResult delStaff = delStaffFunc.execute(staff);
        if (staff.getEquipments()!=null) {
            IntResult equExecute = enableEquFunc.execute(staff);
            IntResult staffAndEquExecute = delStaffAndEquFunc.execute(staff);
        }
        return delStaff;
    }
}
