package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@FunctionImpl(name = "create staff function impl")
public class EquipmentCreateFuncImpl implements EquipmentCreateFunc {
    @Override
    public void execute(Equipment equipment) {
        log.info("creating staff, staff info: {}", equipment);
        try {
            DS.create(equipment);
        } catch (Exception e) {
            log.error("failed to create equipment: ", e);
        }
    }
}
