package io.terminus.trantor.demo.flow;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author liuyayue
 * @create 2021/4/21 8:32 下午
 */
@Flow(name = "创建员工Flow")
public interface CreateStaffFlow {
    Staff execute(Staff staff);
}
