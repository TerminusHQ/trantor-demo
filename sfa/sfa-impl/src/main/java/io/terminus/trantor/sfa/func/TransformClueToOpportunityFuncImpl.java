package io.terminus.trantor.sfa.func;

import io.terminus.trantor.sfa.dictionary.OperationStatus;
import io.terminus.trantor.sfa.model.BizOpportunityBO;
import io.terminus.trantor.sfa.model.ClueBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.context.TContext;
import io.terminus.trantorframework.sdk.sql.DS;


import javax.validation.Valid;


/**
 * @author: Chen Gong
 * @date：2021/12/21 4:39 下午
 */
@FunctionImpl(name = "转化线索为商机函数")
public class TransformClueToOpportunityFuncImpl implements TransformClueToOpportunityFunc {
    @Override
    public BizOpportunityBO execute(@Valid ClueBO clue) {
        if (OperationStatus.TRANSFORMED.equals(clue.getStatus()) || OperationStatus.CLOSED.equals(clue.getStatus())) {
            return null;
        }
        clue.setStatus(OperationStatus.TRANSFORMED);
        DS.update(clue);
        BizOpportunityBO opportunity = new BizOpportunityBO();
        opportunity.setCreatedBy(TContext.getCurrentUser());
        opportunity.setCustomer(clue.getCustomer());
        opportunity.setName(clue.getName());
        DS.create(opportunity);
        return opportunity;
    }
}
