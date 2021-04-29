package io.terminus.trantor.demo.model;

import io.terminus.trantor.demo.dict.EquipmentType;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Index;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liuyayue
 * @create 2021/4/26 2:57 下午
 */
@Data
@ToString(callSuper = true)
@Model(
        name = "员工和设备关系模型"
//        indexes = {
//        @Index(columns = {StaffAndEquipment.staff_field,StaffAndEquipment.type_field}, unique = true),
//        }
)
@AllArgsConstructor
@NoArgsConstructor
public class StaffAndEquipment extends BaseModel<Long> {
    @Field(name = "员工")
    @LinkMeta
    private Staff staff;

    @Field(name = "设备")
    @LinkMeta
    private Equipment equipment;

    @Field(name = "设备类型", nullable = false)
    @DictionaryMeta(value = EquipmentType.class)
    private String type;

}
