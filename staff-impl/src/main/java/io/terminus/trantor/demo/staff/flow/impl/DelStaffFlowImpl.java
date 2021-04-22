package io.terminus.trantor.demo.staff.flow.impl;

import io.terminus.trantor.demo.staff.flow.DelStaffFlow;
import io.terminus.trantor.demo.staff.func.DelStaffFunc;
import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;

/**
 * @author liuyayue
 * @create 2021/4/21 9:09 下午
 */
@FlowImpl(name = "删除员工 Flow 实现")
public class DelStaffFlowImpl implements DelStaffFlow {

    private DelStaffFunc delStaffFunc;

    @Override
    public BooleanResult execute(Staff staff) {
        BooleanResult delStaff = delStaffFunc.execute(staff);
        return delStaff;
    }
}
