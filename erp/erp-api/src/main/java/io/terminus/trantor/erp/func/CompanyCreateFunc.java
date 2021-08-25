package io.terminus.trantor.erp.func;

import io.terminus.trantor.erp.model.Company;
import io.terminus.trantorframework.api.annotation.Function;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
@Function(name = "create company function")
public interface CompanyCreateFunc {
    void execute(Company company);
}
