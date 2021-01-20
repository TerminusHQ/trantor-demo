package io.terminus.trantor.demo.dict;

import io.terminus.trantor.api.annotation.ItemDisplaySortRule;
import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.TDictType;
import io.terminus.trantor.api.annotation.typemeta.Label;


/**
 * 通过@TDict注解来标明这是一个字典类，name标签标明字典类的名称
 * 通过实现ItemDisplaySortRule接口来排序（下拉框展示的顺序）
 * 字典类型为Integer
 */
@TDict(
        name = "性别",
        desc = "性别枚举",
        type= TDictType.Int
)
public class SexEnum implements ItemDisplaySortRule {


    @Label("男生")
    public static final Integer Boy = 0;

    @Label("女生")
    public static final Integer Girl = 1;

    @Label("保密")
    public static final Integer Secrecy = 2;
}
