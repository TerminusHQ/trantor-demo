package io.terminus.trantor.demo.model;


import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.RelationMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author liuyayue
 * @date 2021/4/21 8:18 下午
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

    @Field(name = "上级部门")
    @RelationMeta(name = "DepartmentParent")
    private Department parent;

    @Field(name = "主管")
    @RelationMeta(name = "DepartmentManager")
    private Staff manager;

    @Field(name = "所属公司")
    @RelationMeta(name = "DepartmentCompany")
    private Company company;


    @Field(name = "部门详情", type = FieldType.RichText)
    private String remark;

}
