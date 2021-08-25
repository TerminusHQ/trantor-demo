package io.terminus.trantor.custom.erp.model;


import io.terminus.trantor.custom.erp.dict.EquipmentUseStatus;
import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantorframework.api.annotation.ExtendModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import lombok.Data;

/**
 * 设备模型扩展
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
@Data
@ExtendModel(Equipment.class)
public class EquipmentExtend extends Equipment {

    @Field(name = "设备使用状态", nullable = false)
    @DictionaryMeta(value = EquipmentUseStatus.class)
    private String status;
}
