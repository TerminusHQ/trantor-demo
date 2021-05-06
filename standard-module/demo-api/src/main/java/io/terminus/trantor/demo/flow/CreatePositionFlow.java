package io.terminus.trantor.demo.flow;

import io.terminus.trantor.demo.model.Position;
import io.terminus.trantorframework.api.annotation.Flow;
import io.terminus.trantorframework.api.annotation.RouteRuleMatch;

/**
 * @author liuyayue
 * @create 2021/4/22 7:50 下午
 */
@Flow(name = "创建岗位 Flow")
@RouteRuleMatch("position.type")
//注解内的 position.type 为路由规则，符合 MVEL 表达式规范，其中 position 为入参名称， type 为入参对象类型 Staff 内的字段名称。
//其中postType仅支持Dictionary、Mult Dictionary、Boolean三种类型
public interface CreatePositionFlow {
    Position execute(Position position);
}
