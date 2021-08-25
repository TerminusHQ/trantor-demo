package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author trantor@terminus.io
 * @date 2021/06/25
 */
@RouteRuleMatch("staff.positionType")
@Flow(name = "trantor staff Create Flow ")
public interface StaffCreateFlow {
    void execute(Staff staff);
}
