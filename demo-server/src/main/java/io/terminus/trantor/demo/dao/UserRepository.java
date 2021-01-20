package io.terminus.trantor.demo.dao;

import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * 用户 dao, 须继承 TrantorDAO，默认已包含 CRUD 操作
 *
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/13
 */
@Repository
public class UserRepository extends TrantorDAO<User, Long> {
}
