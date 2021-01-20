package io.terminus.trantor.demo.dict;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Icon;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * 通过@TDict注解来标明这是一个字典类，name标签标明字典类的名称
 * 通过实现ItemDisplaySortRule接口来排序（下拉框展示的顺序）
 * 字典类型为String
 */
@TDict(
        name = "课程枚举",
        desc = "所有课程枚举"
)
public class SubjectEnum implements ItemDisplaySortRule {

    //通过@Label注解对每一个类型进行标注,iconColor：字典类型的颜色；icon字典类型的图标
    @Label(value = "语文", iconColor = Icon.Color.Blue, icon = Icon.bell)
    public static final String Chinese = "Chinese";

    @Label("数学")
    public static final String Mathematics = "Mathematics";

    @Label("英语")
    public static final String English = "English";

}
