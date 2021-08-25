package io.terminus.trantor.erp.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * @author trantor@terminus.io
 * @date 2021/6/21
 */
@Dictionary(name = "岗位类型")
public interface PositionType {

    @DictionaryItem("高级")
    String HIGH = "high";

    @DictionaryItem("中级")
    String MIDDLE = "middle";

    @DictionaryItem("初级")
    String PRIMARY = "primary";
}
