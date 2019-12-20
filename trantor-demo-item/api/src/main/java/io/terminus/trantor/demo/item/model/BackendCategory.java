package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "后台类目", mainField = "name")
@Data
public class BackendCategory extends BaseModel<String> {
    private static final long serialVersionUID = -2470048164289824775L;

    public static final String parent_FIELD_NAME = "parent";
    public static final String level_FIELD_NAME = "level";
    public static final String hasChildren_FIELD_NAME = "hasChildren";
    public static final String name_FIELD_NAME = "name";
    public static final String hasSPU_FIELD_NAME = "hasSPU";

    @TModelField(name = "父类目")
    @RelationMeta(name = "BackendCategoryParent")
    private BackendCategory parent;
    @TModelField(name = "名称", nullable = false)
    private String name;
    @TModelField(name = "层级")
    private Integer level;
    @TModelField
    private Boolean hasChildren = false;
    @TModelField
    private Boolean hasSPU = false;
}
