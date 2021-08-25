package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.ext.StaffNoticeExt;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@RequiredArgsConstructor
@FunctionImpl(name = "create staff function impl")
public class StaffCreateFuncImpl implements StaffCreateFunc {
    private final StaffNoticeExt staffNoticeExt;
    @Override
    public void execute(Staff staff) {
        log.info("creating staff, staff info: {}", staff);
        try {
            DS.create(staff);
        } catch (Exception e) {
            log.error("failed to create staff: ", e);
        }

        // 创建员工后通知第三方系统扩展点
        staffNoticeExt.execute(staff);
    }
}
