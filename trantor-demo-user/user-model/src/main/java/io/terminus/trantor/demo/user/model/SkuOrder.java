package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.*;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(name = "子订单")
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class SkuOrder extends BaseModel<String> {
    private static final long serialVersionUID = -7518040638237509631L;

    @TModelField(name = "订单")
    @RelationMeta(name = "OrderToSkuOrderRel")
    private Order order;
}
