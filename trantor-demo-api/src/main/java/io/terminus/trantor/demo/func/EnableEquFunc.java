package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/26 8:16 下午
 */
@Function(name = "enable equipment`s status function")
public interface EnableEquFunc {
    IntResult execute(Staff staff);
}
