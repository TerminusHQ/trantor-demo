package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Company;
import io.terminus.trantorframework.api.annotation.FunctionImpl;
import io.terminus.trantorframework.sdk.sql.DS;
import lombok.extern.slf4j.Slf4j;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Slf4j
@FunctionImpl(name = "create company function impl")
public class CompanyCreateFuncImpl implements CompanyCreateFunc {
    @Override
    public void execute(Company company) {
        log.info("creating company, company info: {}", company);
        try {
            DS.create(company);
        } catch (Exception e) {
            log.error("failed to create company: ", e);
        }
    }
}
