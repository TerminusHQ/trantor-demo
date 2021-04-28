package io.terminus.trantor.demo.flow;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author liuyayue
 * @create 2021/4/26 8:48 下午
 */
@Flow(name = "update staff flow")
public interface UpdateStaffFlow {
    BooleanResult execute(Staff staff);
}
