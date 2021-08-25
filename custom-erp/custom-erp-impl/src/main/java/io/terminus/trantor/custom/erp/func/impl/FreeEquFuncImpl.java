package io.terminus.trantor.custom.erp.func.impl;

import io.terminus.trantor.custom.erp.dict.EquipmentUseStatus;
import io.terminus.trantor.custom.erp.func.FreeEquFunc;
import io.terminus.trantor.custom.erp.model.EquipmentExtend;
import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.sdk.util.ModelUtils;

import java.util.Objects;

/**
 * 修改设备使用状态为空闲
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
public class FreeEquFuncImpl implements FreeEquFunc {
    @Override
    public void execute(Equipment equipment) {
        if(!Objects.isNull(equipment)) {
            //通过ModelUtils工具类可以把父模型转换成扩展后的模型
            EquipmentExtend equipmentExtend = ModelUtils.convert(equipment, EquipmentExtend.class);
            equipmentExtend.setStatus(EquipmentUseStatus.free);
            BooleanResult update = DS.update(equipment);
        }
    }
}
