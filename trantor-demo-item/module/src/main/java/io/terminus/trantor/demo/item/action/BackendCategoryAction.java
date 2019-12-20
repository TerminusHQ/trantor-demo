package io.terminus.trantor.demo.item.action;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.demo.item.model.BackendCategory;
import io.terminus.trantor.demo.item.repository.BackendCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019-07-24
 */
@Component
@Slf4j
public class BackendCategoryAction {
    @Autowired
    private BackendCategoryRepository backendCategoryRepository;

    @TAction(modelClass = BackendCategory.class)
    @DSTransaction
    public BackendCategory save(final BackendCategory category, BackendCategory parent, String customField) {
        log.info("Server action got custom field, [{}], [{}]", customField, category.get_fields().get("customField"));

        BackendCategory parentInDB = (parent == null || parent.getId() == null) ? null : backendCategoryRepository.query(parent.getId());

        category.setParent(parentInDB);
        category.setLevel(parentInDB == null ? 0 : parentInDB.getLevel() + 1);
        BackendCategory result = backendCategoryRepository.insert(category);

        if (parentInDB != null && !parentInDB.getHasChildren()) {
            parentInDB.setHasChildren(true);
            backendCategoryRepository.update(parentInDB);
        }
        return result;
    }

    @TAction(modelClass = BackendCategory.class)
    @DSTransaction
    public void delete(String id, BackendCategory parent) {
        if (parent != null) {
            int siblingCount = backendCategoryRepository.countByParentId(parent.getId());
            if (siblingCount == 1) {
                parent.setHasChildren(false);
                backendCategoryRepository.update(parent);
            }
        }
        backendCategoryRepository.delete(id);
    }
}
