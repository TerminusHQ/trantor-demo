package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.demo.model.StaffAndEquipment;
import io.terminus.trantorframework.api.annotation.Function;

import java.util.Collection;

/**
 * @author liuyayue
 * @create 2021/4/26 7:23 下午
 */
@Function(name = "创建 StaffAndEquipment Flow")
public interface CreateStaffAndEquFunc {
    Collection<StaffAndEquipment> execute(Staff staff);
}
