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
@RouteRuleValue(PositionType.HIGH)
@ExtensionImpl(name = "trantor High staff Notice Extension Impl")
public class HighStaffNoticeExtImpl implements StaffNoticeExt {
    @Override
    public void execute(Staff staff) {
        log.info("this is a high position staff's extension! ");
    }
}
