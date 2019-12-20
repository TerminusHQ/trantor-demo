package io.terminus.trantor.demo.item;

import io.terminus.trantor.api.ModuleDefinition;
import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/23
 */
public class ItemModule extends ModuleDefinition {
    @NotNull
    @Override
    protected String getKey() {
        return "item";
    }
}
