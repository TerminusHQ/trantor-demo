package io.terminus.trantor.demo.flow.impl;

import io.terminus.trantor.demo.flow.UpdateStaffFlow;
import io.terminus.trantor.demo.func.DisableEqusFunc;
import io.terminus.trantor.demo.func.EnableEquFunc;
import io.terminus.trantor.demo.func.UpdateStaffAndEquFunc;
import io.terminus.trantor.demo.func.UpdateStaffFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author liuyayue
 * @create 2021/4/26 8:49 下午
 */
@FlowImpl(name = "update staff flow impl")
public class UpdateStaffFlowImpl implements UpdateStaffFlow {

    private UpdateStaffFunc updateStaffFunc;

    private UpdateStaffAndEquFunc updateStaffAndEquFunc;

    private EnableEquFunc enableEquFunc;

    private DisableEqusFunc disableEqusFunc;

    @Override
    public BooleanResult execute(Staff staff) {
        //修改员工信息
        BooleanResult update = updateStaffFunc.execute(staff);
        //修改该员工之前的设备状态为可用
        enableEquFunc.execute(staff);
        //更新中间表
        updateStaffAndEquFunc.execute(staff);
        //修改该员工目前的设备状态为不可用
        disableEqusFunc.execute(staff);
        return update;
    }
}
