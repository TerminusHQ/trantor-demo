package io.terminus.trantor.demo.flow;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author liuyayue
 * @create 2021/4/21 8:34 下午
 */
@Flow(name = "get staff")
public interface GetStaffFlow {
    Staff execute(Staff staff);
}
