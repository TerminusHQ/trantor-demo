package io.terminus.trantor.demo.staff.ext;


import io.terminus.trantor.demo.staff.model.Staff;

/**
 *
 */
//@Extension(name = "设置员工编码扩展点")
public interface StaffNumberRuleExt {

    String execute(Staff staff);
}
