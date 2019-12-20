package io.terminus.trantor.demo.item.repository;

import io.terminus.platform.sdk.builder.DSCondition;
import io.terminus.platform.sdk.dao.BaseDAOSupport;
import io.terminus.platform.sdk.dao.DataStoreTemplate;
import io.terminus.platform.sdk.dto.QueryConnectionDto;
import io.terminus.trantor.demo.item.model.FrontendCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/10
 */
@Repository
public class FrontendCategoryRepository extends BaseDAOSupport<FrontendCategory> {
    @Autowired
    public FrontendCategoryRepository(DataStoreTemplate dataStoreTemplate) {
        super(dataStoreTemplate);
    }

    public int countByParentId(String parentId) {
        return this.query(new QueryConnectionDto().where(new DSCondition("parent").join(new DSCondition("id").eq(parentId))));
    }
}
