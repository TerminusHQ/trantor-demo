package io.terminus.trantor.demo.flow.impl;


import io.terminus.trantor.demo.flow.CreateStaffFlow;
import io.terminus.trantor.demo.func.CreateStaffAndEquFunc;
import io.terminus.trantor.demo.func.CreateStaffFunc;
import io.terminus.trantor.demo.func.DisableEqusFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.demo.model.StaffAndEquipment;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FlowImpl;

import java.util.Collection;

/**
 * @author liuyayue
 * @create 2021/4/21 8:42 下午
 */
@FlowImpl(name = "create staff Flow impl")
public class CreateStaffFlowImpl implements CreateStaffFlow {

    private CreateStaffFunc createStaffFunc;

    private CreateStaffAndEquFunc createStaffAndEquFunc;
    
    private DisableEqusFunc disableEqusFunc;


    @Override
    public Staff execute(Staff staff) {
        // 调用function创建员工
        Staff itemBOResult = createStaffFunc.execute(staff);
        //判断员工的设备是否不为空
        if (staff.getEquipments()!=null){
            // 调用function创建中间表
            Collection<StaffAndEquipment> execute = createStaffAndEquFunc.execute(staff);
            // 调用function修改设备状态
            IntResult execute1 = disableEqusFunc.execute(staff);
        }
        return itemBOResult;
    }
}
