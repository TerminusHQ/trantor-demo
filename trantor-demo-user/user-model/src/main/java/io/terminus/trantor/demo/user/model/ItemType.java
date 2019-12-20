package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * @author Xyf
 */
@TDict
public class ItemType {

    @Label(value = "普通商品")
    public static final String COMMON = "common";
}
