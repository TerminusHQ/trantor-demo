package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.CreateStaffAndEquFunc;
import io.terminus.trantor.demo.func.DelStaffAndEquFunc;
import io.terminus.trantor.demo.func.UpdateStaffAndEquFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;

/**
 * @author liuyayue
 * @create 2021/4/26 8:54 下午
 */
@FunctionImpl(name = "update staffAndEquFunction impl")
public class UpdateStaffAndEquFuncImpl implements UpdateStaffAndEquFunc {

    private DelStaffAndEquFunc delStaffAndEquFunc;

    private CreateStaffAndEquFunc createStaffAndEquFunc;

    @Override
    public void execute(Staff staff) {
        delStaffAndEquFunc.execute(staff);
        createStaffAndEquFunc.execute(staff);
    }
}
