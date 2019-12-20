package io.terminus.trantor.demo.item.model;

import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-20
 */
public enum ItemType {
    @Label("实物商品")
    Real,
    @Label("虚拟商品")
    Virtual,
    @Label("服务商品")
    Service,
}
