package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;

/**
 * @author ymf
 * @date 2021/1/19 10:33 上午
 */
@TModel(name = "教师模型")
public class Teacher extends BaseModel<Long> {

    private static final long serialVersionUID = 2209884803300659565L;

    @TModelField(name = "教师姓名")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
