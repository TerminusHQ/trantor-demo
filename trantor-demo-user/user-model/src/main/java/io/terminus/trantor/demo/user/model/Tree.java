package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;

/**
 * @author Xyf
 */
@Data
@TModel
public class Tree extends BaseModel<String> {
    @TModelField
    @RelationMeta(name = "TreeSelfRel", modelClass = Tree.class)
    private Tree parent;

    @TModelField
    private String name;
}
