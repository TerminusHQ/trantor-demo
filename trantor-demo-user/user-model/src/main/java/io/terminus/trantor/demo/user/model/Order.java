package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(name = "订单", partition = @Partition(strategy = Partition.Strategy.Hash, field = "id", quantity = 1))
public class Order extends BaseModel<String> {
    private static final long serialVersionUID = -31906507409566556L;

    @TModelField(name = "子订单")
    @RelationMeta(name = "OrderToSkuOrderRel", modelClass = SkuOrder.class)
    private List<SkuOrder> skuOrders;

    @TModelFieldTemplate
    private Inner inner;

    @TModelField(type = TModelFieldType.DateTime)
    private Date time;

    @Data
    public static class Inner {
        @NotNull(message = "name con not be null")
        @TModelField
        private String name;
    }
}
