package io.terminus.trantor.demo.dict;

import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * @author liuyayue
 * @create 2021/4/25 10:59 上午
 */
@Dictionary(name = "办公设备类型")
public class EquipmentType {

    @DictionaryItem("笔记本")
    public static final String noteBook = "noteBool";

    @DictionaryItem("显示器")
    public static final String monitor = "monitor";

    @DictionaryItem("鼠标")
    public static final String mouse = "mouse";

    @DictionaryItem("键盘")
    public static final String keyboard = "keyboard";

}

