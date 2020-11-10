package io.terminus.trantor.demo.serveraction;

import io.terminus.platform.sdk.transaction.DSTransaction;
import io.terminus.trantor.api.annotation.RootModel;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.demo.dao.UserRepository;
import io.terminus.trantor.demo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
     * @param email 批量修改的邮箱
     */
    @TAction(modelClass = User.class)
    @DSTransaction
    public void batchUpdateName(@TParam("email") String email) {
        List<Long> ids = userRepository.findAll().stream().map(RootModel::getId).collect(Collectors.toList());
        User user = new User();
        user.setEmail(email);
        userRepository.updateManyIgnoreRelationSkipNull(ids, user);
    }
}