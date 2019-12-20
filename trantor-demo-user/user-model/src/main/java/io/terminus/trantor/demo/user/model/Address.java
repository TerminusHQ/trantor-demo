package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.typemeta.JsonMeta;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Xyf
 * @date 2019/05/10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(desc = "地址", mainField = "city")
@NoArgsConstructor
public class Address extends BaseModel<String> {
    private static final long serialVersionUID = 7470367591055587738L;

    @TModelField(
            type = TModelFieldType.ToMany,
            name = "用户"
    )
    @RelationMeta(name = "UserAddressRel", modelClass = User.class)
    private List<User> userList;

    @TModelField(name = "省")
    private String province;

    @TModelField(name = "城市")
    private String city;

    @TModelField(type = TModelFieldType.Json)
    @JsonMeta(arrayClass = User.class)
    private List<User> userJson;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }
}
