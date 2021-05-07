package io.terminus.trantor.custom.demo.model;

import io.terminus.trantor.demo.model.Position;
import io.terminus.trantorframework.api.annotation.ExtendModel;
import io.terminus.trantorframework.api.annotation.Field;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 模型扩展
 *
 * @author: Chen Gong
 * @date：2021/5/7 2:40 下午
 */
@Data
@ExtendModel(Position.class)
public class PositionExtend extends Position {

    @Field(name = "岗位扩展信息")
    @NotNull(message = "岗位扩展信息")
    private String extend;
}
