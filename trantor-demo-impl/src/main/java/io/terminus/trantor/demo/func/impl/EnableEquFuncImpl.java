package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.EnableEquFunc;
import io.terminus.trantor.demo.model.Equipment;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.demo.model.StaffAndEquipment;
import io.terminus.trantor.module.base.enums.OrgStatus;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/26 8:17 下午
 */
@Slf4j
@FunctionImpl(name = "enable euqipment`s status function impl")
public class EnableEquFuncImpl implements EnableEquFunc {
    @Override
    public IntResult execute(Staff staff) {

        List<StaffAndEquipment> staffAndEquipments = DS.findAll(StaffAndEquipment.class,
                "*,staff.*", "staff = ? ", staff.getId());

        List<Equipment> equipments = new ArrayList<>();

        Equipment equipment;
        for (StaffAndEquipment staffAndEquipment : staffAndEquipments){
            equipment = new Equipment();
            equipment.setId(staffAndEquipment.getEquipment().getId());
            equipment.setStatus(OrgStatus.Enable);
            equipments.add(equipment);
        }

        log.info("update staff: {}", equipments.toString());

        IntResult update = DS.update(equipments);

        if (Objects.isNull(update)) {
            throw new BusinessException("更改设备信息失败");
         }

        return update;
    }
}
