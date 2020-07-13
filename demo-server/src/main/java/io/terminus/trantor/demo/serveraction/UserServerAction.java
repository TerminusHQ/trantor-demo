package io.terminus.trantor.demo.serveraction;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TCollectionParam;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.demo.dao.UserRepository;
import io.terminus.trantor.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户模型自定义 server action
 *
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/13
 */
@Slf4j
@Component
public class UserServerAction {
    @Autowired
    private UserRepository userRepository;

    /**
     * 批量修改用户邮箱
     *
     * @param id 待修改用户 id 列表
     * @param email 批量修改的邮箱
     */
    @TAction(modelClass = User.class)
    @DSTransaction
    public void batchUpdateName(@TCollectionParam(Long.class) List<Long> id, @TParam("email") String email) {
        User user = new User();
        user.setEmail(email);
        userRepository.updateManyIgnoreRelationSkipNull(id, user);
    }
}