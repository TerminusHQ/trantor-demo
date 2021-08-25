package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@RouteRuleMatch("staff.positionType")
@Function(name = "staff positionType check function")
public interface StaffPositionTypeFunc {
    void execute(Staff staff);
}
