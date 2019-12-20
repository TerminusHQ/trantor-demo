package io.terminus.trantor.demo.user.biz;

import io.terminus.trantor.demo.user.model.Order;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * @author Xyf
 */
@Repository
public class NewOrderDAO extends TrantorDAO<Order, String> {
}
