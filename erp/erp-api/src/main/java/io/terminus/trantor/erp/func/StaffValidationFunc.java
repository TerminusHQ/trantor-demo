package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Function(name = "staff validation function")
public interface StaffValidationFunc {
    void execute(Staff staff);
}
