package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.Index;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.type.Attachment;
import io.terminus.trantor.api.annotation.typemeta.AllowedTypes;
import io.terminus.trantor.api.annotation.typemeta.AttachmentMeta;
import io.terminus.trantor.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "品牌", mainField = "name", indexes = @Index(columns = "uniqueName", unique = true))
@Data
public class Brand extends BaseModel<String> {
    private static final long serialVersionUID = 1172487469302949652L;

    public static final String description_FIELD_NAME = "description";
    public static final String enCap_FIELD_NAME = "enCap";
    public static final String uniqueName_FIELD_NAME = "uniqueName";
    public static final String enName_FIELD_NAME = "enName";
    public static final String name_FIELD_NAME = "name";

    @TModelField
    private String name;
    @TModelField
    private String uniqueName;
    @TModelField
    private String enName;
    @TModelField
    private String enCap;
    @TModelField
    @AttachmentMeta(allowedTypes = AllowedTypes.IMAGE, maxSize = 1024)
    private Attachment logo;
    @TModelField
    @TextMeta(length = 1000)
    private String description;
}
