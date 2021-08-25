package io.terminus.trantor.custom.erp.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * 办公设备类型
 * @author trantor@terminus.io
 * @date 2021/6/21
 **/
@Dictionary(name = "设备使用状态")
public class EquipmentUseStatus {

    @DictionaryItem("空闲")
    public static final String free = "free";

    @DictionaryItem("使用中")
    public static final String inUse = "inUse";

    @DictionaryItem("损坏")
    public static final String damage = "damage";

}

