package io.terminus.trantor.demo;

import io.terminus.trantor.api.ModuleDefinition;

/**
 * 请替换为自己的
 *
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/8
 */
public class DemoModuleDefinition extends ModuleDefinition {
    /**
     * module key， 请保证全局唯一
     */
    public static final String DEMO_MODULE_KEY = "terminus_trantor_demo";

    @Override
    protected String getKey() {
        return DEMO_MODULE_KEY;
    }

    @Override
    protected String getName() {
        return "Trantor Demo";
    }

    @Override
    protected String getVersion() {
        return "1.0.0-SNAPSHOT";
    }

    @Override
    protected String getDesc() {
        return "Trantor Demo";
    }
}
