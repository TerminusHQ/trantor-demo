package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Flow(name = "update staff flow")
public interface StaffUpdateFlow {
    void execute(Staff staff);
}
