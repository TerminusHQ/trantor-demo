package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.DelStaffAndEquFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.demo.model.StaffAndEquipment;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;

import java.util.List;
import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/26 7:59 下午
 */
@FunctionImpl(name = "del StaffAndEquipment Function impl")
public class DelStaffAndEquFuncImpl implements DelStaffAndEquFunc {
    @Override
    public IntResult execute(Staff staff) {
        List<StaffAndEquipment> staffAndEquipments = DS.findAll(StaffAndEquipment.class, "*", "staff = ? ",
        staff.getId());
        IntResult delete = DS.delete(staffAndEquipments);
        if (Objects.isNull(delete) ) {
            throw new BusinessException("删除员工设备关系失败");
        }
        return delete;
    }
}
