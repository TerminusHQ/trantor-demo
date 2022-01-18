package io.terminus.trantor.sfa.func;

import io.terminus.trantor.sfa.dictionary.PricingStatus;
import io.terminus.trantor.sfa.model.PricingBO;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;


import javax.validation.Valid;


/**
 * @author: Chen Gong
 * @date：2021/12/21 4:39 下午
 */
@FunctionImpl(name = "报价单确认函数")
public class PricingConfirmFuncImpl implements PricingConfirmFunc {
    @Override
    public void execute(@Valid PricingBO pricing) {
        pricing.setStatus(PricingStatus.CONFIRMED);

        DS.update(pricing);
    }
}
