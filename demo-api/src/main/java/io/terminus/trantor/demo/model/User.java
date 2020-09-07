package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/8
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(name = "用户信息")
public class User extends BaseModel<Long> {
    private static final long serialVersionUID = 1L;

    @TModelField(name = "用户名", nullable = false)
    private String name;

    @TModelField(name = "邮箱")
    private String email;

    @TModelField(name = "电话")
    private String phone;
}
