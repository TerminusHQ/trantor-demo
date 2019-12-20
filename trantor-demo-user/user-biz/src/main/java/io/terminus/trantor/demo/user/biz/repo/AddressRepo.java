package io.terminus.trantor.demo.user.biz.repo;

import io.terminus.trantor.demo.user.model.Address;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * @author Xyf
 */
@Repository
public class AddressRepo extends TrantorDAO<Address, String> {
}
