package io.terminus.trantor.custom.erp.flow;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;
/**
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
@Flow(name = "删除员工flow")
public interface StaffDeleteFlow {
    void execute(Staff staff);
}
