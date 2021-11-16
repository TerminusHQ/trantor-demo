package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Function(name = "create Equipment function")
public interface EquipmentCreateFunc {
    void execute(Equipment equipment);
}
