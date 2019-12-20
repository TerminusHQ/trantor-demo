package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.type.Attachment;
import io.terminus.trantor.api.annotation.typemeta.AttachmentMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "SKU", mainField = "name")
@Data
public class Sku extends BaseModel<String> {
    private static final long serialVersionUID = -2688464269000963351L;

    public static final String item_FIELD_NAME = "item";
    public static final String attrsJson_FIELD_NAME = "attrsJson";
    public static final String code_FIELD_NAME = "code";
    public static final String type_FIELD_NAME = "type";
    public static final String barCode_FIELD_NAME = "barCode";
    public static final String bitTag_FIELD_NAME = "bitTag";
    public static final String price_FIELD_NAME = "price";
    public static final String name_FIELD_NAME = "name";
    public static final String outerId_FIELD_NAME = "outerId";
    public static final String cspu_FIELD_NAME = "cspu";
    public static final String businessType_FIELD_NAME = "businessType";

    @TModelField
    @RelationMeta(name = "SkuItem")
    private Item item;
    @TModelField
    @RelationMeta(name = "SkuCspu")
    private Cspu cspu;
    @TModelField
    private String code;
    @TModelField
    private String barCode;
    @TModelField
    private String outerId;
    @TModelField
    private String name;
    @TModelField
    @AttachmentMeta(allowedTypes = {"jpg", "jpeg", "png", "gif"})
    private Attachment image;
    @TModelField
    private Long price;
    @TModelField
    private ItemType type;
    @TModelField
    private Integer businessType;
    @TModelField(type = TModelFieldType.Json)
    private String attrsJson;
    @TModelField
    private Long bitTag;
}
