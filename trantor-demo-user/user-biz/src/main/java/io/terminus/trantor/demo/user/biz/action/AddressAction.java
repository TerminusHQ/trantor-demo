package io.terminus.trantor.demo.user.biz.action;

import com.google.common.collect.Lists;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.demo.user.biz.repo.AddressRepo;
import io.terminus.trantor.demo.user.model.Address;
import io.terminus.trantor.demo.user.model.User;
import io.terminus.trantor.sdk.autumn.Selectable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xyf
 */
@Component
public class AddressAction {

    @Autowired
    private AddressRepo addressRepo;

    @TAction(modelClass = Address.class)
    public Address create() {
        Address address = new Address();
        address.setProvince("zhejiang");
        address.setCity("hangzhou");
        User user = new User();
        user.setUsername("abc");
        address.setUserJson(Lists.newArrayList(user));
        return addressRepo.create(address);
    }

    @TAction(modelClass = Address.class)
    public List<Address> listAll() {
        List<Address> addresses = addressRepo.find(Selectable::selectAll);
        return addresses;
    }
}
