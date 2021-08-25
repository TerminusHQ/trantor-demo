package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;

@Flow(name = "StaffCreateByPlugin", desc = "Staff Create flow By Plugin")
public interface StaffCreateFlowByPlugin {
    void execute(Staff staff);
}
