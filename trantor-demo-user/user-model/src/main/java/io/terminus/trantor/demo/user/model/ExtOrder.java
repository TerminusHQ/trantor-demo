package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.custom.api.annotation.ExtendTModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ExtendTModel(Order.class)
public class ExtOrder extends Order {
    @TModelField
    private String extFields;
}
