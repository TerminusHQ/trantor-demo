package io.terminus.trantor.custom.erp.func;

import io.terminus.trantor.custom.erp.model.InheritorEquipment;
import io.terminus.trantor.erp.func.EquipmentCreateFunc;
import io.terminus.trantor.erp.model.Equipment;
import io.terminus.trantor.module.base.model.BusinessMessage;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import io.terminus.trantorframework.sdk.util.ModelUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 */
@Slf4j
@FunctionImpl
public class EquipmentCreateInheritorFunc implements EquipmentCreateFunc {
    @Override
    public void execute(Equipment equipment) {
        InheritorEquipment inheritorEquipment = ModelUtils.convert(equipment, InheritorEquipment.class);
        log.info("inheritorTestModel:{}", inheritorEquipment);


        BusinessMessage msg = null;
        try{
            IntResult intResult = DS.create(inheritorEquipment);;
            Long id = intResult.getValue().longValue();
            log.info("create inheritorEquipment:{} success Item1", id);
        }catch (Exception e){
            log.error("create inheritorEquipment error , exception: {}", e.getMessage());
        }
    }
}
