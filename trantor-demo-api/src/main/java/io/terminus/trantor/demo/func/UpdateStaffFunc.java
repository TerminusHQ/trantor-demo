package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/27 10:49 上午
 */
@Function(name = "update staff function")
public interface UpdateStaffFunc {
    BooleanResult execute(Staff staff);
}
