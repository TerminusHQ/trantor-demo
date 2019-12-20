package io.terminus.trantor.demo.user.model;


import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Xyf
 * @date 2019/04/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TModel(desc = "用户", mainField = "username",
        fieldGroups = {
                @FieldGroup(fieldName = {"username", "name", "address"}),
                @FieldGroup(type = FieldGroupType.SEARCHABLE, fieldName = User.name_field),
                @FieldGroup(type = FieldGroupType.SEARCH_SHOW, fieldName = User.name_field)
        },
        enableSearch = true
)
public class User extends BaseModel<String> {
    private static final long serialVersionUID = 4034704005484102406L;

    @TextMeta(rule = "STRING(Test)+TIMES(yyyy-MM-dd HH:mm:ss.SSS)+INCRE(1,4,0,100)+RANDOM(4,1)+FROM(username.lastString(1))")
    @TModelField
    private String code;

    @TModelField(
            desc = "用户名",
            name = "用户名",
            nullable = false)
    private String username;

    @TModelField(
            type = TModelFieldType.Password,
            desc = "密码",
            name = "密码",
            nullable = false)
    private String password;

    @TModelField(
            desc = "姓名",
            name = "姓名",
            nullable = false)
    private String name;

    @TModelField(
            desc = "年龄",
            name = "年龄")
    private Integer age;

    @TModelField(
            desc = "性别",
            name = "性别")
    @EnumMeta(labels = {@NamedLabel(name = "man", value = "男"), @NamedLabel(name = "woman", value = "女")})
    private Sex sex;

    @TModelField(
            desc = "是否锁定",
            name = "锁定")
    private Boolean locked;

    @TModelField(
            type = TModelFieldType.ToMany,
            name = "地址")
    @RelationMeta(name = "UserAddressRel", modelClass = Address.class)
    private List<Address> address;

    @TModelFieldTemplate
    private Template template;

    @TModelField(name = "单个地址")
    @RelationMeta(name = "OneAddressRel")
    private Address singleAddress;

    @TModelField(name = "省")
    @Reference(fromField = User.singleAddress_field, mappingField = Address.province_field)
    private String province;
}
