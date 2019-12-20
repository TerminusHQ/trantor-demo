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
 * Date: 2019-08-05
 */
@EqualsAndHashCode(callSuper = true)
@TModel(name = "后台类目扩展信息")
@Data
public class CategoryExtra extends BaseModel<String> {
    private static final long serialVersionUID = 766071757660582743L;

    @TModelField(name = "所属后台类目")
    @RelationMeta(name = "CategoryExtraBackendCategory")
    private BackendCategory backendCategory;

    @TModelField(name = "税率编码")
    private String rateCode;
    @TModelField(name = "税率")
    private Integer rate;
    @TModelField(name = "售后服务政策名称")
    private String serviceTitle;
    @TModelField(type = TModelFieldType.RichText, name = "售后服务政策")
    private String serviceContent;
}
