package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Department;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@FunctionImpl(name = "delete department function impl")
public class DepartmentDeleteFuncImpl implements DepartmentDeleteFunc {

    @Override
    public void execute(Department department) {
        DS.delete(department);
    }
}