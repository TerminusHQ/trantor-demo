package io.terminus.trantor.demo.dao;

import io.terminus.trantor.demo.model.User;
import io.terminus.trantor.sdk.autumn.Selectable;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 dao, 须继承 TrantorDAO，默认已包含 CRUD 操作
 *
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/13
 */
@Repository
public class UserRepository extends TrantorDAO<User, Long> {
    public List<User> findAll() {
        return find(Selectable::selectAll);
    }
}
