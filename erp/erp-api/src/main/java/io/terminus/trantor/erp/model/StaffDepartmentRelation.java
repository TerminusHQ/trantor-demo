package io.terminus.trantor.erp.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Index;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;

/**
 * @author trantor@terminus.io
 * @date 2021/06/22
 **/
@Model(name = "员工-部门-关联关系", indexes = {
        @Index(columns = StaffDepartmentRelation.staff_field),
        @Index(columns = StaffDepartmentRelation.department_field)
})
public class StaffDepartmentRelation extends BaseModel<Long> {

    @Field(name = "员工")
    @LinkMeta
    private Staff staff;

    @Field(name = "部门")
    @LinkMeta
    private Department department;
}
