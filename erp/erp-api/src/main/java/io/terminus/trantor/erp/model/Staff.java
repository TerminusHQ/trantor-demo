package io.terminus.trantor.erp.model;

import io.terminus.trantor.erp.dict.PositionType;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.*;
import io.terminus.trantorframework.api.type.Currency;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author trantor@terminus.io
 * @date 2021/06/22
 */
@Data
@ToString(callSuper = true)
@Model(
        name = "员工模型",
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

    @Field(name = "手机号", type = FieldType.Phone, nullable = false)
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @Field(name = "邮箱", type = FieldType.Email)
    private String email;

    @Field(name = "出生日期", type = FieldType.Date)
    private Date birthday;

    /**
     * 非持久化字段，年龄通过 birthday 实时计算
     */
    @Transient
    @Field(name = "年龄")
    private Integer age;

    @Field(name = "住址", type = FieldType.Text)
    private String liveAddress;

    /**
     * 薪资, 主要为了引入 Currency 类型字段
     */
    @Field(name = "薪资", type = FieldType.Currency)
    private Currency salary;

    @Field(name = "岗位类型")
    @NotNull(message = "岗位类型不能为空")
    @DictionaryMeta(value = PositionType.class)
    private String positionType;

    @Field(name = "所属公司", nullable = false, type = FieldType.Link)
    @NotNull(message = "公司不能为空")
    @LinkMeta
    private Company company;

    /**
     * 多对多，员工可能属于多个虚拟组织，如纵向划分职能部门后，还有横向的架构评审委员会等虚拟部门
     */
    @Field(name = "部门", type = FieldType.LookupMany)
    @NotNull(message = "部门不能为空")
    @LookupMeta(linkField = StaffDepartmentRelation.staff_field)
    @JunctionMeta(model = StaffDepartmentRelation.class, lookupField = StaffDepartmentRelation.department_field)
    private List<Department> departments;

    /**
     * 一对一，一人一台笔记本电脑，一个笔记本同时只能所属一个员工
     */
    @Field(name = "办公设备")
    @LookupMeta
    private Equipment equipment;
}

