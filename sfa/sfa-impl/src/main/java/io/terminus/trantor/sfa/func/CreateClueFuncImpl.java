package io.terminus.trantor.sfa.func;

import io.terminus.trantor.module.base.model.result.IntResult;
import io.terminus.trantor.sfa.model.ClueBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.context.TContext;
import io.terminus.trantorframework.sdk.sql.DS;

import javax.validation.Valid;


/**
 *
 * @author: Chen Gong
 * @date：2021/12/21 4:39 下午
 */
@FunctionImpl(name = "创建线索函数")
public class CreateClueFuncImpl implements CreateClueFunc {

    @Override
    public ClueBO execute(@Valid ClueBO clue) {
        clue.setCreatedBy(TContext.getCurrentUser());
        IntResult intResult =  DS.create(clue);

        clue.setId(intResult.getValue().longValue());
        return clue;
    }
}
