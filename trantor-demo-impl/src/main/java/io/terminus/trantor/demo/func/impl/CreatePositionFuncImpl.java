package io.terminus.trantor.demo.func.impl;

import io.terminus.trantor.demo.func.CreatePositionFunc;
import io.terminus.trantor.demo.model.Position;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @author liuyayue
 * @create 2021/4/22 8:00 下午
 */
@FunctionImpl(name = "create position function impl")
@Slf4j
public class CreatePositionFuncImpl implements CreatePositionFunc {
    @Override
    public Position execute(Position position) {
        log.info("create position: {}", position.toString());
        IntResult id = DS.create(position);
        Position positionResult = DS.findById(Position.class, id.getValue().longValue());
        if (Objects.isNull(positionResult)) {
            throw new BusinessException("保存岗位信息失败");
        }
        return positionResult;
    }
}
