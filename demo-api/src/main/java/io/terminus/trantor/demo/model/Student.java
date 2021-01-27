package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.*;
import io.terminus.trantor.demo.dict.SexEnum;

import javax.validation.constraints.NotNull;


/**
 * @author ymf
 * @date 2021/1/19 10:31 上午
 */
@TModel(
        name = "学生模型",
        mainField = Student.name_field,
        indexes = {
                @Index(columns = Student.mobile_field)
        }
)
public class Student extends BaseModel<Long> {

    private static final long serialVersionUID = -4434701696846600802L;


    @TModelField(name = "姓名", nullable = false)
    @NotNull(message = "姓名不可为空")
    private String name;

    @TModelField(name = "手机号", type = TModelFieldType.Phone)
    private String mobile;

    @TModelField(name = "邮箱", type = TModelFieldType.Email)
    private String email;

    @TModelField(name = "性别")
    @DictionaryMeta(clazz = SexEnum.class)
    private Integer sex;

    @TModelField(name = "所属班级")
    @RelationMeta(name = "Classes")
    private Classes classes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
