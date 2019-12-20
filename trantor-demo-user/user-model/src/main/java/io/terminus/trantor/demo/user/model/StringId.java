package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.IDRule;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TModel(idRule = @IDRule(rule = "ABC-[0001]"))
public class StringId extends BaseModel<String> {
    @TModelField
    private String myField;
}
