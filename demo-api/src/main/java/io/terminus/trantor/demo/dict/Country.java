package io.terminus.trantor.demo.dict;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Icon;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * 通过@TDict注解来标明这是一个字典类，name标签标明字典类的名称
 * 通过实现ItemDisplaySortRule接口来排序（下拉框展示的顺序）
 */
@TDict(
        name = "国家",
        desc = "我是字典类的描述"
)
public class Country implements ItemDisplaySortRule {

    @Label(value = "中国", iconColor = Icon.Color.Blue, icon = Icon.bell)
    public static final String China = "China";

    @Label("美国")
    public static final String American = "American";

}
