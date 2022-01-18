package io.terminus.trantor.sfa.func;

import io.terminus.trantor.sfa.model.ClueBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

import javax.validation.Valid;

/**
 * @author: Chen Gong
 * @date：2021/12/21 4:39 下午
 */
@FunctionImpl(name = "更新线索函数")
public class UpdateClueFuncImpl implements UpdateClueFunc {
    @Override
    public void execute(@Valid ClueBO clue) {
        DS.update(clue);
    }
}
