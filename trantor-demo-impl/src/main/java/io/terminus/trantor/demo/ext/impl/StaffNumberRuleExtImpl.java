package io.terminus.trantor.demo.ext.impl;

import io.terminus.trantor.demo.ext.StaffNumberRuleExt;
import io.terminus.trantor.demo.model.Staff;
import org.apache.commons.lang3.RandomStringUtils;

//@ExtensionImpl(name = "员工编码默认实现")
public class StaffNumberRuleExtImpl implements StaffNumberRuleExt {
    @Override
    public String execute(Staff staff) {
        String randomNumber = RandomStringUtils.randomAlphabetic(8);
        return "Staff:" + randomNumber;
    }
}
