package io.terminus.trantor.demo.ext;


import io.terminus.trantor.demo.model.Staff;

/**
 *
 */
//@Extension(name = "设置员工编码扩展点")
public interface StaffNumberRuleExt {

    String execute(Staff staff);
}
