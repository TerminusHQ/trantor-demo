package io.terminus.trantor.demo.custom;

import io.terminus.trantor.api.ModuleDefinition;
import org.jetbrains.annotations.NotNull;

/**
 * @author Xyf
 */
public class CUSTOMModule extends ModuleDefinition {
    @NotNull
    @Override
    protected String getKey() {
        return "custom";
    }
}
