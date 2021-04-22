package io.terminus.trantor.demo.staff.ext.impl;

import io.terminus.trantor.demo.staff.model.Staff;
import io.terminus.trantor.demo.staff.ext.StaffNumberRuleExt;
import org.apache.commons.lang3.RandomStringUtils;

//@ExtensionImpl(name = "员工编码默认实现")
public class StaffNumberRuleExtImpl implements StaffNumberRuleExt {
    @Override
    public String execute(Staff staff) {
        String randomNumber = RandomStringUtils.randomAlphabetic(8);
        return "Staff:" + randomNumber;
    }
}
