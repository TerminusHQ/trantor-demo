package io.terminus.trantor.demo.flow;

import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author liuyayue
 * @create 2021/4/21 8:33 下午
 */
@Flow(name = "删除员工flow")
public interface DelStaffFlow {
    BooleanResult execute(Staff staff);

}
