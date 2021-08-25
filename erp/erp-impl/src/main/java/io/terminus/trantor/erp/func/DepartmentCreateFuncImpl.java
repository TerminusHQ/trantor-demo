package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Department;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@FunctionImpl(name = "create department function impl")
public class DepartmentCreateFuncImpl implements DepartmentCreateFunc {

    @Override
    public void execute(Department department) {
        log.info("creating department, department info: {}", department);
        try {
            DS.create(department);
        } catch (Exception e) {
            log.error("failed to create department: ", e);
        }
    }
}
