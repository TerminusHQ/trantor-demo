package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Function(name = "update staff function")
public interface StaffUpdateFunc {
    void execute(Staff staff);
}
