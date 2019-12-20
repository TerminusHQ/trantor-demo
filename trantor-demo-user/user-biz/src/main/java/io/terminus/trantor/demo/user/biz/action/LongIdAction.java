package io.terminus.trantor.demo.user.biz.action;

import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.demo.user.biz.repo.LongIdRepo;
import io.terminus.trantor.demo.user.model.LongId;
import io.terminus.trantor.sdk.autumn.Selectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xyf
 */
@Component
public class LongIdAction {

    @Autowired
    private LongIdRepo longIdRepo;

    @TAction(modelClass = LongId.class)
    public List<LongId> findAll() {
        return longIdRepo.find(Selectable::selectAll);
    }
}
