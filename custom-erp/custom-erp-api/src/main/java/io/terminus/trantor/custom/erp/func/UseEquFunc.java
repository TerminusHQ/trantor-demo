package io.terminus.trantor.custom.erp.func;

import io.terminus.trantor.custom.erp.model.EquipmentExtend;
import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * 修改设备使用状态
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
@Function(name = "修改设备使用状态为使用中")
public interface UseEquFunc {
    void execute(Equipment equipment);
}
