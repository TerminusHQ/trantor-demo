package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;
import io.terminus.trantor.api.annotation.typemeta.DictionaryMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(name = "商品", mainField = "name")
@NoArgsConstructor
@AllArgsConstructor
public class Item extends BaseModel<String> {
    private static final long serialVersionUID = -4366379037078757183L;

    @TModelField(name = "商品名称")
    private String name;
    @TModelField(name = "商品价格")
    private BigDecimal price;
    @TModelField(name = "商品类型", type = TModelFieldType.Dictionary)
    @DictionaryMeta(clazz = ItemType.class)
    private String type;
}
