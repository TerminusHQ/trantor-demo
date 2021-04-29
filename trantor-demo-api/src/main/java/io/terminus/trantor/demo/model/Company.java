package io.terminus.trantor.demo.model;

import io.terminus.trantor.module.base.acl.ACLNodeType;
import io.terminus.trantor.module.base.acl.SingleACLNode;
import io.terminus.trantor.module.base.dictionary.Country;
import io.terminus.trantor.module.base.dictionary.Currency;
import io.terminus.trantor.module.base.dictionary.Language;
import io.terminus.trantor.module.base.enums.CompanyStatus;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.RelationMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author liuyayue
 * @date 2021/4/21 8:18 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Model(
        name = "公司模型",
        mainField = Company.name_field,
        indexes = {
                @Index(columns = Company.code_field, unique = true),
        },
        fieldGroups = {
                @FieldGroup(fieldName = {Company.id_field, Company.code_field, Company.name_field}),
                @FieldGroup(fieldName = {Company.code_field, Company.name_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Company.code_field, Company.name_field}, type = FieldGroupType.SEARCH_SHOW),
        },
        config = @ModelConfig(
                enableSearch = true,
                enableImport = true,
                enableExport = true
        )
)
public class Company extends BaseModel<Long> {
    public static final String key = "base_Company";
    private static final long serialVersionUID = -523791539293507763L;
    @Field(name = "公司编码")
    @TextMeta(rule = "STRING(CO)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;
    @Field(name = "公司名称", nullable = false)
    @NotNull(message = "公司名称不能为空")
    private String name;
    @Field(name = "公司简称")
    private String shortName;
    @Field(name = "公司缩写")
    private String abbreviation;
    @Field(name = "上级公司")
    @RelationMeta(name = "CompanyParent")
    private Company parent;
    @Field(name = "地址")
    private String address;
    @Field(name = "公司详情", type = FieldType.RichText)
    private String remark;
    @Field(name = "状态", defaultValue = "Enable", nullable = false)
    private CompanyStatus status;


}
