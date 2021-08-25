package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@FunctionImpl(name = "delete staff Function impl")
public class StaffDeleteFuncImpl implements StaffDeleteFunc {
    @Override
    public void execute(Staff staff) {
        DS.delete(staff);
    }
}