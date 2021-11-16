package io.terminus.trantor.erp.model;

import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.FieldType;
import io.terminus.trantorframework.api.annotation.Model;
import io.terminus.trantorframework.api.annotation.ModelConfig;
import io.terminus.trantorframework.api.annotation.typemeta.LinkMeta;

import javax.validation.constraints.NotNull;

@Model(
        name = "Position",
        config = @ModelConfig(
                enableSearch = true
        )
)
public class Position extends BaseModel<Long> {

        @Field(name = "职位名称", nullable = false)
        @NotNull(message = "部门名称不能为空")
        private String positionName;

        @Field(name = "所属部门", nullable = false)
        @NotNull(message = "部门不能为空")
        @LinkMeta
        private Department department;

        @Field(name = "岗位描述", type = FieldType.MultiText)
        private String positionDesc;
}
