package io.terminus.trantor.demo.staff.flow.impl;


import io.terminus.trantor.demo.staff.flow.GetStaffFlow;
import io.terminus.trantor.demo.staff.func.GetStaffFunc;
import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author liuyayue
 * @create 2021/4/21 8:48 下午
 */
@FlowImpl(name = "get 商品Flow实现")
public class GetStaffFlowImpl implements GetStaffFlow {

    private GetStaffFunc getStaffFunc;

    @Override
    public Staff execute(Staff staff) {
        Staff result = getStaffFunc.execute(staff);
        return result;
    }
}
