package io.terminus.trantor.demo.staff.func.impl;

import io.terminus.trantor.demo.staff.func.DelStaffFunc;
import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantor.module.base.model.result.BooleanResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/21 9:00 下午
 */
@FunctionImpl(name = "删除员工 function实现")
@Slf4j
public class DelStaffFuncImpl implements DelStaffFunc {

    @Override
    public BooleanResult execute(Staff staff) {
        log.info("del staff: {}", staff.toString());
        BooleanResult delete = DS.delete(staff);

        if (Objects.isNull(delete) || !delete.getValue()) {
            throw new BusinessException("删除员工失败");
        }
        return delete;
    }
}
