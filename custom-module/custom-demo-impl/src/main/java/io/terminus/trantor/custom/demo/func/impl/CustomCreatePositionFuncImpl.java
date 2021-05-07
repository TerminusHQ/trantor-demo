package io.terminus.trantor.custom.demo.func.impl;

import com.alibaba.fastjson.JSON;
import io.terminus.trantor.demo.func.CreatePositionFunc;
import io.terminus.trantor.demo.model.Position;
import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.exception.BusinessException;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 
 * @author: Chen Gong
 * @date：2021/5/7 3:59 下午
 */
@FunctionImpl(name = "create position extend function impl")
@Slf4j
public class CustomCreatePositionFuncImpl implements CreatePositionFunc {
    @Override
    public Position execute(Position position) {
        log.info("position:{}", JSON.toJSONString(position));
        IntResult id = DS.create(position);
        Position positionResult = DS.findById(Position.class, id.getValue().longValue());
        if (Objects.isNull(positionResult)) {
            throw new BusinessException("保存岗位信息失败");
        }
        return positionResult;
    }
}
