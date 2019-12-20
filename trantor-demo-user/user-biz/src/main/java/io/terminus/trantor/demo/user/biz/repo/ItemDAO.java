package io.terminus.trantor.demo.user.biz.repo;

import io.terminus.platform.sdk.dao.BaseDAOSupport;
import io.terminus.platform.sdk.dao.DataStoreTemplate;
import io.terminus.trantor.demo.user.model.Item;
import org.springframework.stereotype.Repository;

/**
 * @author Xyf
 */
@Repository
public class ItemDAO extends BaseDAOSupport<Item> {
    public ItemDAO(DataStoreTemplate dataStoreTemplate) {
        super(dataStoreTemplate);
    }
}
