package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/21 8:38 下午
 */
@Function(name = "删除员工设备关系 function")
public interface DelStaffAndEquFunc {
    IntResult execute(Staff staff);
}
