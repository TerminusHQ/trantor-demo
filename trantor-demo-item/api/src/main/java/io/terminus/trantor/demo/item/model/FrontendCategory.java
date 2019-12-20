package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.type.Attachment;
import io.terminus.trantor.api.annotation.typemeta.AllowedTypes;
import io.terminus.trantor.api.annotation.typemeta.AttachmentMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/9
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "前台类目", mainField = "name")
@Data
public class FrontendCategory extends BaseModel<String> {
    private static final long serialVersionUID = -4462935154998060081L;

    @TModelField(name = "父类目")
    @RelationMeta(name = "FrontendCategoryParent")
    private FrontendCategory parent;
    @TModelField(name = "名称", nullable = false)
    @NotNull
    private String name;
    @TModelField(name = "层级")
    private Integer level;
    @TModelField
    private Boolean hasChildren = false;
    @TModelField
    @AttachmentMeta(allowedTypes = AllowedTypes.IMAGE, maxSize = 1024)
    private Attachment logo;
    @TModelField(name = "绑定后台类目")
    @RelationMeta(name = "FrontendCategoryBackendCategories", modelClass = BackendCategory.class)
    private List<BackendCategory> backendCategories;
}
