package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Department;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Function(name = "create department function")
public interface DepartmentCreateFunc {
    void execute(Department department);
}
