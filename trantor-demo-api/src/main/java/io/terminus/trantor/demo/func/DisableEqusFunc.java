package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/25 11:21 上午
 */
@Function(name = "更改设备信息 function")
public interface DisableEqusFunc {
    IntResult execute(Staff staff);
}
