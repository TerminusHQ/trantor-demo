package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.TModelFieldType;

/**
 * model定义信息
 */
@TModel(name = "用户信息")
public class User extends BaseModel<Long> {
    private static final long serialVersionUID = 1L;

    @TModelField(name = "用户名")
    private String name;

    @TModelField(name = "邮箱", type = TModelFieldType.Email)
    private String email;

    @TModelField(name = "电话", type = TModelFieldType.Phone)
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
