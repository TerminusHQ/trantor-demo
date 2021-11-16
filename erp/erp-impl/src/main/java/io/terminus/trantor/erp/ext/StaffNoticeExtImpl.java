package io.terminus.trantor.erp.ext;

import io.terminus.trantor.erp.dict.PositionType;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.ExtensionImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/06/24
 */
@Slf4j
@RouteRuleValue({PositionType.PRIMARY, PositionType.MIDDLE})
@ExtensionImpl(name = "trantor staff notice extension Impl")
public class StaffNoticeExtImpl implements StaffNoticeExt {
    @Override
    public void execute(Staff staff) {
        log.info("this is a staff Notice the third system extension!");
    }
}
