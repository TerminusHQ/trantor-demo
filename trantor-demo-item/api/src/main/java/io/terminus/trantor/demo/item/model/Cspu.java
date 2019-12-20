package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "CSPU", mainField = "code")
@Data
public class Cspu extends BaseModel<String> {
    private static final long serialVersionUID = -5491784572517322534L;

    public static final String attrsJson_FIELD_NAME = "attrsJson";
    public static final String code_FIELD_NAME = "code";
    public static final String type_FIELD_NAME = "type";
    public static final String barCode_FIELD_NAME = "barCode";
    public static final String spu_FIELD_NAME = "spu";
    public static final String outerId_FIELD_NAME = "outerId";

    @TModelField
    @RelationMeta(name = "CspuSpu")
    private Spu spu;
    @TModelField
    private String outerId;
    @TModelField
    private String code;
    @TModelField
    private String barCode;
    @TModelField
    private ItemType type;
    @TModelField(type = TModelFieldType.Json)
    private String attrsJson;
}
