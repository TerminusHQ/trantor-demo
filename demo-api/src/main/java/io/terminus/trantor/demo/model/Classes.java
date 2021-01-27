package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.*;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import io.terminus.trantor.api.dimension.BusinessDimensionData;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * @author ymf
 * @desc 班级模型需要实现BusinessDimensionData接口 并且实现其方法
 */
@TModel(
        name = "班级模型",
        mainField = Classes.name_field,
        indexes = {
                @Index(columns = Classes.classesNo_field, unique = true),
        }
)
public class Classes extends BaseModel<Long> implements BusinessDimensionData {

    private static final long serialVersionUID = -5487034784262603444L;

    @TModelField(name = "名称")
    private String name;

    @TModelField(name = "班级编号")
    private String classesNo;


    @Override
    public @NotNull Long getId() {
        return this.id;
    }

    /**
     * 业务维度下拉展示名称
     *
     * @return name
     */
    @Override
    public String getTitle() {
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassesNo() {
        return classesNo;
    }

    public void setClassesNo(String classesNo) {
        this.classesNo = classesNo;
    }

}
