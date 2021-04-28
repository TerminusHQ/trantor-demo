package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.CreateStaffFunc;
import io.terminus.trantor.demo.model.Staff;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/21 8:52 下午
 */
@FunctionImpl(name = "创建员工 function实现")
@Slf4j
public class CreateStaffFuncImpl implements CreateStaffFunc {

    @Override
    public Staff execute(Staff staff) {
        log.info("create staff: {}", staff.toString());

        IntResult id = DS.create(staff);
        Staff staffResult = DS.findById(Staff.class, id.getValue().longValue());
        if (Objects.isNull(staffResult)) {
            throw new BusinessException("保存员工信息失败");
        }
        return staffResult;
    }
}
