package io.terminus.trantor.sfa.func;

import io.terminus.trantor.sfa.dictionary.PricingStatus;
import io.terminus.trantor.sfa.model.BizOpportunityBO;
import io.terminus.trantor.sfa.model.PricingBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;

import javax.validation.Valid;


/**
 * @author: Chen Gong
 * @date：2021/12/21 4:39 下午
 */
@FunctionImpl(name = "转化商机为报价单函数")
public class TransformOpportunityToPricingFuncImpl implements TransformOpportunityToPricingFunc {

    @Override
    public PricingBO execute(@Valid BizOpportunityBO opportunity) {
        PricingBO pricingBO = new PricingBO();
        pricingBO.setName(opportunity.getCustomer().getName());
        pricingBO.setStatus(PricingStatus.UNCONFIRMED);
        DS.create(pricingBO);
        return pricingBO;
    }

}
