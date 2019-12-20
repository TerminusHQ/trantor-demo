package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/22
 */
@TDict
public class ItemTypeDict {
    @Label("实物商品")
    public static final String Real = "Real";
    @Label("虚拟商品")
    public static final String Virtual = "Virtual";
    @Label("服务商品")
    public static final String Service = "Service";
}
