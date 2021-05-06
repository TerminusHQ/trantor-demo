package io.terminus.trantor.demo.func;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/21 8:36 下午
 */
@Function(name = "创建员工 function")
public interface CreateStaffFunc {
    Staff execute(Staff staff);
}
