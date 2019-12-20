package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;
import io.terminus.trantor.api.annotation.TModelField;
import lombok.Data;

/**
 * @author Xyf
 */
@Data
@TModel
public class LongId extends BaseModel<Long> {
    private static final long serialVersionUID = -3209866591099672696L;

    @TModelField
    private String test;
}
