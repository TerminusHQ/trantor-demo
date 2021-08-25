package io.terminus.trantor.erp.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author trantor@terminus.io
 * @date 2021/06/22
 */
@Data
@ToString(callSuper = true)
@Model(name = "办公设备模型")
@AllArgsConstructor
@NoArgsConstructor
public class Equipment extends BaseModel<Long> {

    @Field(name = "设备编码")
    @TextMeta(rule = "STRING(Equ)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;

    @Field(name = "归属公司")
    @NotNull(message = "公司不能为空")
    @LinkMeta
    private Company company;

    @Field(name = "借用员工")
    @LinkMeta
    private Staff staff;

}
