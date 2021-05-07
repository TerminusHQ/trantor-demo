package io.terminus.trantor.custom.demo.dict;

import io.terminus.trantor.demo.dict.PositionType;
import io.terminus.trantorframework.api.annotation.DictionaryItem;
import io.terminus.trantorframework.api.annotation.ExtendDictionary;

/**
 * 岗位扩展
 *
 * @author: Chen Gong
 * @date：2021/5/7 1:57 下午
 */
@ExtendDictionary
public class PositionTypeExtend extends PositionType {

    @DictionaryItem("中高级")
    public static final String middle_High = "middle_High";
}
