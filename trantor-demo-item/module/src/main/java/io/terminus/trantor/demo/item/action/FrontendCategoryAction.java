package io.terminus.trantor.demo.item.action;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.demo.item.model.FrontendCategory;
import io.terminus.trantor.demo.item.repository.FrontendCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/8/10
 */
@Component
public class FrontendCategoryAction {
    @Autowired
    private FrontendCategoryRepository frontendCategoryRepository;

    @TAction(modelClass = FrontendCategory.class)
    @DSTransaction
    public FrontendCategory save(final FrontendCategory category, FrontendCategory parent) {
        FrontendCategory parentInDB = (parent == null || parent.getId() == null) ? null : frontendCategoryRepository.query(parent.getId());

        category.setParent(parentInDB);
        category.setLevel(parentInDB == null ? 0 : parentInDB.getLevel() + 1);
        FrontendCategory result = frontendCategoryRepository.insert(category);

        if (parentInDB != null && !parentInDB.getHasChildren()) {
            parentInDB.setHasChildren(true);
            frontendCategoryRepository.update(parentInDB);
        }
        return result;
    }

    @TAction(modelClass = FrontendCategory.class)
    @DSTransaction
    public void delete(String id, FrontendCategory parent) {
        if (parent != null) {
            int siblingCount = frontendCategoryRepository.countByParentId(parent.getId());
            if (siblingCount == 1) {
                parent.setHasChildren(false);
                frontendCategoryRepository.update(parent);
            }
        }
        frontendCategoryRepository.delete(id);
    }
}
