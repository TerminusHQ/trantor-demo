package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.func.StaffCreateFunc;
import io.terminus.trantor.erp.func.StaffValidationFunc;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FlowImpl;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@FlowImpl(name = "StaffCreateByPlugin", desc = "Staff Create flow impl By Plugin")
public class StaffCreateFlowByPluginImpl implements StaffCreateFlowByPlugin {
    private final StaffCreateFunc staffCreateFunc;
    private final StaffValidationFunc staffValidationFunc;

    @Override
    public void execute(Staff staff) {

    }
}
