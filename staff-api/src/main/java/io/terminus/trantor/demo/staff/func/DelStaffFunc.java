package io.terminus.trantor.demo.staff.func;

import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/21 8:38 下午
 */
@Function(name = "删除员工 function")
public interface DelStaffFunc {
    BooleanResult execute(Staff staff);
}
