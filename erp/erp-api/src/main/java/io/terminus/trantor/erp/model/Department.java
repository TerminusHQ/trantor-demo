package io.terminus.trantor.erp.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.*;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author trantor@terminus.io
 * @date 2021/06/22
 */
@Data
@ToString(callSuper = true)
@Model(name = "部门模型", mainField = "name")
public class Department extends BaseModel<Long> {
    private static final long serialVersionUID = 5211638242173698941L;

    @Field(name = "部门名称", nullable = false)
    @NotNull(message = "部门名称不能为空")
    private String name;

    @Field(name = "部门编码")
    @TextMeta(rule = "STRING(DEP)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;

    @Field(name = "部门详情", type = FieldType.RichText)
    private String remark;

    @Field(name = "主管")
    @LinkMeta
    private Staff leader;

    @Field(name = "所属公司", nullable = false)
    @LinkMeta
    private Company company;

    @Field(name = "上级部门")
    @LinkMeta
    private Department parent;

    @Field(name = "下属员工", type = FieldType.LookupMany)
    @LookupMeta(linkField = StaffDepartmentRelation.department_field)
    @JunctionMeta(model = StaffDepartmentRelation.class, lookupField = StaffDepartmentRelation.staff_field)
    private List<Staff> staffList;

}
