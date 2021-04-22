package io.terminus.trantor.demo.staff.func.impl;

import io.terminus.trantor.demo.staff.func.GetStaffFunc;
import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;

/**
 * @author liuyayue
 * @create 2021/4/21 8:56 下午
 */
@FunctionImpl(name = "get 员工 function实现")
public class GetStaffFuncImpl implements GetStaffFunc {

    @Override
    public Staff execute(Staff staff) {
        return staff;
    }
}
