package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/26 8:52 下午
 */
@Function(name = "update staffAndEquipment function")
public interface UpdateStaffAndEquFunc {
    void execute(Staff staff);
}
