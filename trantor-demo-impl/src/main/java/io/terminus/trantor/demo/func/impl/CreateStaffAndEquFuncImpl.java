package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.CreateStaffAndEquFunc;
import io.terminus.trantor.demo.model.Equipment;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.demo.model.StaffAndEquipment;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/26 7:25 下午
 */
@FunctionImpl(name = "create StaffAndEquFunc impl")
public class CreateStaffAndEquFuncImpl implements CreateStaffAndEquFunc {

    @Override
    public Collection<StaffAndEquipment> execute(Staff staff) {
        List<Equipment> equipments = staff.getEquipments();
        List<StaffAndEquipment> staffAndEquipments = new ArrayList<>();

        for (Equipment equipment:equipments){
            staffAndEquipments.add(new StaffAndEquipment(staff,equipment,equipment.getType()));
        }
        List<IntResult> intResults = DS.create(staffAndEquipments);
        List<Long> ids = new ArrayList<>();
        for (StaffAndEquipment staffAndEquipment : staffAndEquipments){
            ids.add(staffAndEquipment.getId());
        }
        List<StaffAndEquipment> byIds = DS.findByIds(StaffAndEquipment.class, ids);

        if (Objects.isNull(byIds)) {
            throw new BusinessException("保存岗位信息失败");
        }
        return byIds;
    }
}
