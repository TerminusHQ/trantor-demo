package io.terminus.trantor.demo.model;

import io.terminus.trantor.demo.dict.EquipmentType;
import io.terminus.trantor.module.base.enums.OrgStatus;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldGroup;
import io.terminus.trantorframework.api.annotation.FieldGroupType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuyayue
 * @create 2021/4/25 11:03 上午
 */
@Data
@ToString(callSuper = true)
@Model(name = "办公设备模型",
        mainField = "type",
        fieldGroups = {
                @FieldGroup(fieldName = {Equipment.code_field, Equipment.type_field,Equipment.status_field}),
                @FieldGroup(fieldName = {Equipment.code_field, Equipment.type_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Equipment.code_field, Equipment.type_field}, type = FieldGroupType.SEARCH_SHOW),
        })
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends BaseModel<Long> {

    @Field(name = "设备编码")
    @TextMeta(rule = "STRING(Equ)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;

    @Field(name = "设备类型", nullable = false)
    @DictionaryMeta(value = EquipmentType.class)
    private String type;

    @Field(name = "状态", defaultValue = "Enable", nullable = false)
    private OrgStatus status;

    @Field(name = "公司")
    @RelationMeta(name = "EquipmentCompany")
    @NotNull(message = "公司不能为空")
    private Company company;


    @Field(name = "办公设备")
    @LookupMeta(linkField = StaffAndEquipment.equipment_field)
    @JunctionMeta(model = StaffAndEquipment.class, lookupField = StaffAndEquipment.staff_field)
    private List<Staff> staffs;

}
