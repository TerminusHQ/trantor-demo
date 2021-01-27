package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;

/**
 * @author ymf
 * @date 2021/1/21 8:38 下午
 */
@TModel(name = "学校部门模型", mainField = "name")
public class Department extends BaseModel<Long> {

    private static final long serialVersionUID = 5211638242173698941L;
    @TModelField(name = "部门名称", nullable = false)
    private String name;

    @TModelField(name = "部门编码")
    private String code;

    @TModelField(name = "上级部门")
    @RelationMeta(name = "DepartmentParent")
    private Department parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }
}
