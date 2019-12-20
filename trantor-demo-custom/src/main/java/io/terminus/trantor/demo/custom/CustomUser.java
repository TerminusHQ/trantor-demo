package io.terminus.trantor.demo.custom;

import io.terminus.trantor.custom.api.annotation.ExtendTModel;
import io.terminus.trantor.module.base.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ExtendTModel(User.class)
public class CustomUser extends User {
    private static final long serialVersionUID = 1037780069112277156L;

//    @TModelField
//    private String test;
}
