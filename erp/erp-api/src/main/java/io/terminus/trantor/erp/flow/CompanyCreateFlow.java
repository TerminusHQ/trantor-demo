package io.terminus.trantor.erp.flow;

import io.terminus.trantor.erp.model.Company;
import io.terminus.trantorframework.api.annotation.Flow;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Flow(name = "create company flow")
public interface CompanyCreateFlow {
    void execute(Company company);
}
