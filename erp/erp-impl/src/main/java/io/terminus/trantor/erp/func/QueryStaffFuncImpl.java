package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

@FunctionImpl(name = "query staff func impl")
public class QueryStaffFuncImpl implements QueryStaffFunc {
    @Override
    public Staff execute(Staff staff) {
        return DS.findById(Staff.class,staff.getId());
    }
}
