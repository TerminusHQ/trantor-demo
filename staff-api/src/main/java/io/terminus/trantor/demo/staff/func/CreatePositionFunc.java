package io.terminus.trantor.demo.staff.func;

import io.terminus.trantor.demo.staff.model.Position;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author liuyayue
 * @create 2021/4/22 7:55 下午
 */
@Function(name = "创建岗位 function")
public interface CreatePositionFunc {
    Position execute(Position position);
}
