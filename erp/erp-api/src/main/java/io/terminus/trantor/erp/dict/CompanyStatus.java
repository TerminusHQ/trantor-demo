package io.terminus.trantor.erp.dict;

import io.terminus.trantorframework.api.annotation.DictType;
import io.terminus.trantorframework.api.annotation.Dictionary;
import io.terminus.trantorframework.api.annotation.DictionaryItem;

/**
 * @author trantor@terminus.io
 * @date 2021/6/21
 */
@Dictionary(name = "公司营业状态", type = DictType.Int)
public interface CompanyStatus {
    @DictionaryItem(value = "启用")
    Integer enable = 1;
    @DictionaryItem(value = "停用")
    Integer disable = 0;
}
