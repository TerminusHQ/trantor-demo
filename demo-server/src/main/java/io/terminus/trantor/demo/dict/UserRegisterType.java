package io.terminus.trantor.demo.dict;

import io.terminus.trantor.api.annotation.TDict;
import io.terminus.trantor.api.annotation.typemeta.Label;

/**
 * Description:
 *
 * @author: husc 2020-07-23 下午3:03
 */
@TDict(name = "注册类型")
public class UserRegisterType {

    @Label("网页")
    public static final String Web= "web";

    @Label("App")
    public static final String App= "App";

    @Label("小程序")
    public static final String SmallMicro= "SmallMicro";
}
