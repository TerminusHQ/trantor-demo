package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Staff;
import io.terminus.trantor.erp.msg.StaffMsg;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@FunctionImpl(name = "staff validation function impl")
public class StaffValidationFuncImpl implements StaffValidationFunc {

    final String regex = "^1[3-9]\\d{9}$";
    Pattern pattern = Pattern.compile(regex);

    @Override
    public void execute(Staff staff) {
        if (staff != null && StringUtils.isEmpty(staff.getMobile())) {
            log.info("staff mobile is empty");
            throw new BusinessException(StaffMsg.EX_PHONE_INVALID);
        }

        if (!pattern.matcher(staff.getMobile()).matches()) {
            log.info("staff mobile is invalid format");
            throw new BusinessException(StaffMsg.EX_PHONE_INVALID);
        }
    }
}
