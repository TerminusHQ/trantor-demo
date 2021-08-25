package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.func.CompanyCreateFunc;
import io.terminus.trantor.erp.model.Company;
import io.terminus.trantorframework.api.annotation.FlowImpl;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@FlowImpl(name = "create company flow impl")
public class CompanyCreateFlowImpl implements CompanyCreateFlow {
    private CompanyCreateFunc companyCreateFunc;
    @Override
    public void execute(Company company) {
        companyCreateFunc.execute(company);
    }
}
