package io.terminus.trantor.demo.staff.func;

import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/21 8:39 下午
 */
@Function(name = "get 员工 function")
public interface GetStaffFunc {
    Staff execute(Staff staff);
}
