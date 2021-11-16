package io.terminus.trantor.erp.ext;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Extension;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author trantor@terminus.io
 * @date 2021/06/24
 */
@RouteRuleMatch("staff.positionType")
@Extension(name = "trantor staff notice Extention")
public interface StaffNoticeExt {
    void execute(Staff staff);
}
