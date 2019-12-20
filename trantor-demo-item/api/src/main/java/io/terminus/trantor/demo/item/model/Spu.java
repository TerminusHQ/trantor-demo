package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.type.Attachment;
import io.terminus.trantor.api.annotation.typemeta.AllowedTypes;
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
@TModel(name = "SPU", mainField = "name")
@Data
public class Spu extends BaseModel<String> {
    private static final long serialVersionUID = -4163766558239163701L;

    public static final String code_FIELD_NAME = "code";
    public static final String type_FIELD_NAME = "type";
    public static final String otherAttributes_FIELD_NAME = "otherAttributes";
    public static final String skuAttributes_FIELD_NAME = "skuAttributes";
    public static final String name_FIELD_NAME = "name";
    public static final String outerId_FIELD_NAME = "outerId";
    public static final String category_FIELD_NAME = "category";
    public static final String brand_FIELD_NAME = "brand";
    public static final String advertise_FIELD_NAME = "advertise";

    @TModelField(name = "外部编码")
    private String outerId;
    @TModelField(name = "编码")
    private String code;
    @TModelField(name = "类目")
    @RelationMeta(name = "SpuCategory")
    private BackendCategory category;
    @TModelField(name = "品牌")
    @RelationMeta(name = "SpuBrand")
    private Brand brand;
    @TModelField(name = "名称")
    private String name;
    @TModelField(name = "关键词")
    private String advertise;
    @TModelField(name = "商品主图")
    @AttachmentMeta(allowedTypes = AllowedTypes.IMAGE, maxSize = 1024)
    private Attachment mainImage;
    @TModelField(name = "视频链接")
    private String videoUrl;
    @TModelField(name = "类型")
    private ItemType type;
    @TModelField(type = TModelFieldType.Json)
    private String skuAttributes;
    @TModelField(type = TModelFieldType.Json)
    private String otherAttributes;
}
