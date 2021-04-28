package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.UpdateStaffFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author liuyayue
 * @create 2021/4/27 10:51 上午
 */
@FunctionImpl(name = "update staff function impl")
public class UpdateStaffFuncImpl implements UpdateStaffFunc {
    @Override
    public BooleanResult execute(Staff staff) {
        BooleanResult update = DS.update(staff);
        if(!update.getValue()){
            throw new BusinessException("更改员工信息失败");
        }
        return update;
    }
}
