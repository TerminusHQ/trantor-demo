package io.terminus.trantor.demo.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.JunctionMeta;
import io.terminus.trantorframework.api.annotation.typemeta.LookupMeta;
import io.terminus.trantorframework.api.annotation.typemeta.RelationMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuyayue
 * @date 2021/4/21 8:18 下午
 */
@Data
@ToString(callSuper = true)
@Model(
        name = "员工",
        mainField = "staffName",
        fieldGroups = {
                @FieldGroup(fieldName = {Staff.staffNumber_field, Staff.staffName_field}),
                @FieldGroup(fieldName = {Staff.staffNumber_field, Staff.staffName_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Staff.staffNumber_field, Staff.staffName_field}, type = FieldGroupType.SEARCH_SHOW),
        }
)
public class Staff extends BaseModel<Long> {
    @Field(name = "员工名称")
    private String staffName;

    @TextMeta(rule = "STRING(STAFF)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    @Field(name = "员工编号")
    private String staffNumber;

    @Field(name = "岗位")
    @NotNull(message = "岗位不能为空")
    @RelationMeta(name = "StaffPosition")
    private Position position;

    @Field(name = "部门")
    @RelationMeta(name = "StaffDepartment")
    @NotNull(message = "部门不能为空")
    private Department department;

    @Field(name = "所属公司")
    @RelationMeta(name = "StaffCompany")
    private Company company;


    @Field(name = "手机号", type = FieldType.Phone, nullable = false)
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @Field(name = "邮箱", type = FieldType.Email)
    private String email;

    @Field(name = "办公设备")
    @LookupMeta(linkField = StaffAndEquipment.staff_field)
    @JunctionMeta(model = StaffAndEquipment.class, lookupField = StaffAndEquipment.equipment_field)
    private List<Equipment> equipments;
}

