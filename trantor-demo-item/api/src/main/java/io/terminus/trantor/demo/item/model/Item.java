package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.type.Attachment;
import io.terminus.trantor.api.annotation.typemeta.AllowedTypes;
import io.terminus.trantor.api.annotation.typemeta.AttachmentMeta;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "商品", mainField = "name")
@Data
public class Item extends BaseModel<String> {
    private static final long serialVersionUID = -1677854816851477624L;

    public static final String shopName_FIELD_NAME = "shopName";
    public static final String type_FIELD_NAME = "type";
    public static final String otherAttributes_FIELD_NAME = "otherAttributes";
    public static final String bitTag_FIELD_NAME = "bitTag";
    public static final String skuAttributes_FIELD_NAME = "skuAttributes";
    public static final String name_FIELD_NAME = "name";
    public static final String spu_FIELD_NAME = "spu";
    public static final String businessType_FIELD_NAME = "businessType";
    public static final String category_FIELD_NAME = "category";
    public static final String brand_FIELD_NAME = "brand";
    public static final String advertise_FIELD_NAME = "advertise";

    @TModelField(name = "SPU")
    @RelationMeta(name = "ItemSpu")
    private Spu spu;
    @TModelField(name = "所属类目")
    @RelationMeta(name = "ItemCategory")
    private BackendCategory category;
    @TModelField(name = "店铺")
    private String shopName;
    @TModelField(name = "品牌")
    @RelationMeta(name = "ItemBrand")
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

    public String getVideoUrl() {
        return videoUrl;
    }

    @TModelField(name = "商品类型")
    @DictionaryMeta(clazz = ItemTypeDict.class)
    private String type;

    public String getType() {
        return type;
    }

    @TModelField
    private Integer businessType;
    @TModelField(type = TModelFieldType.Json)
    private String skuAttributes;
    @TModelField(type = TModelFieldType.Json)
    private String otherAttributes;
    @TModelField
    private Long bitTag;
}
