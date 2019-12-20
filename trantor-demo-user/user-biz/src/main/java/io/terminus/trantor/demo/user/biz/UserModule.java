package io.terminus.trantor.demo.user.biz;

import io.terminus.trantor.api.ModuleDefinition;
import org.jetbrains.annotations.NotNull;

/**
 * @author Xyf
 */
public class UserModule extends ModuleDefinition {
    @NotNull
    @Override
    protected String getKey() {
        return "user2";
    }
}
