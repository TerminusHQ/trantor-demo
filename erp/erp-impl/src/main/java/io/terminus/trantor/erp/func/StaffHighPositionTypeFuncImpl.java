package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.dict.PositionType;
import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.api.annotation.RouteRuleValue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@RouteRuleValue({PositionType.HIGH})
@FunctionImpl(name = "High positionType staff Function impl")
public class StaffHighPositionTypeFuncImpl implements StaffPositionTypeFunc {
    @Override
    public void execute(Staff staff) {
        log.info("excellent staff: {}", staff.getStaffName());
    }
}
