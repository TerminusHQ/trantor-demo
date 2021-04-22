package io.terminus.trantor.demo.staff.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.RelationMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liuyayue
 * @date 2021/4/21 8:18 下午
 */
@Data
@ToString(callSuper = true)
@Model(
        name = "员工"
)
public class Staff extends BaseModel<Long> {
    @Field(name = "员工名称")
    private String staffName;

    @TextMeta(rule = "STRING(STAFF)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    @Field(name = "员工编号")
    private String staffNumber;

    @Field(name = "岗位")
    @NotNull(message = "岗位不能为空")
    @RelationMeta(name = "StaffPosition")
    private Position position;

    @Field(name = "部门")
    @RelationMeta(name = "StaffDepartment")
    @NotNull(message = "部门不能为空")
    private Department department;

    @Field(name = "手机号", type = FieldType.Phone, nullable = false)
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @Field(name = "邮箱", type = FieldType.Email)
    private String email;


}
