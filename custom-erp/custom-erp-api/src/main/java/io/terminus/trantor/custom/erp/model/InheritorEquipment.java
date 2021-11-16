package io.terminus.trantor.custom.erp.model;

import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;

/**
 * @author trantor@terminus.io
 */
@Data
@InheritModel(name = "设备继承模型",
        indexes = {@Index(name = "item_code_index",columns ={Equipment.code_field},unique = true)}
)
public class InheritorEquipment extends Equipment {

    @Field
    @OverrideField
    @TextMeta(rule = "STRING(InheritorEqu)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;
}
