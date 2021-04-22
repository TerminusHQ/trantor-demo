package io.terminus.trantor.demo.staff.flow.impl;


import io.terminus.trantor.demo.staff.flow.CreateStaffFlow;
import io.terminus.trantor.demo.staff.func.CreateStaffFunc;
import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author liuyayue
 * @create 2021/4/21 8:42 下午
 */
@FlowImpl(name = "创建员工Flow实现")
public class CreateStaffFlowImpl implements CreateStaffFlow {

    private CreateStaffFunc createStaffFunc;

    @Override
    public Staff execute(Staff staff) {
        // 调用function创建员工
        Staff itemBOResult = createStaffFunc.execute(staff);
        return itemBOResult;
    }
}
