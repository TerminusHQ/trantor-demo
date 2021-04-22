package io.terminus.trantor.demo.staff.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;
import io.terminus.trantorframework.api.annotation.typemeta.Label;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/9/3
 */
@Dictionary(name = "岗位类型")
public class PositionType {

    @DictionaryItem("高级")
    public static final String High = "high";

    @DictionaryItem("中级")
    public static final String middle = "middle";

    @DictionaryItem("初级")
    public static final String primary = "primary";

}
