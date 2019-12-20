package io.terminus.trantor.demo.user.biz.action;

import com.google.common.collect.Lists;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.common.model.convert.ModelUtils;
import io.terminus.trantor.demo.user.biz.repo.UserDAO;
import io.terminus.trantor.demo.user.model.Address;
import io.terminus.trantor.demo.user.model.Sex;
import io.terminus.trantor.demo.user.model.User;
import io.terminus.trantor.sdk.autumn.Selectable;
import io.terminus.trantor.sdk.autumn.param.Operators;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAction {

    private final UserDAO userDAO;

    @TAction(modelClass = User.class)
    public User create(User user) {
        user = userDAO.create(user, select -> {
            select.getAll();
            select.getObject(User.template_longId_field, Selectable::selectAll);
        });
        return user;
    }

    @TAction(modelClass = User.class)
    public User update(User user) {
        log.info("update user, id: [{}]", user.getId());
        return user;
    }

    @TAction(modelClass = User.class)
    public User ref() {
        User user = new User();
        user.setName("user");
        Address address = new Address();
        address.setCity("city");
//        user.setAddress(Lists.newArrayList(address));
        user.setSingleAddress(address);
        address.setUserList(Lists.newArrayList(user));
        Map<String, Object> map = ModelUtils.modelToMap(user, User.class);
        User u = ModelUtils.mapToModel(User.class, map);
        userDAO.create(u);
        return u;
    }

//    @TAction(modelClass = User.class)
//    public User testCustom() {
//        User user = new User();
//        user.setUsername("a");
//        user.setName("a");
//        user.setPassword("a");
//        Address address1 = new Address();
//        address1.setCity("c1");
//        Address address2 = new Address();
//        address2.setCity("c2");
//        user.set(ExtUser.extAddress_field, address1);
//        user.set(ExtUser.extAddressList_field, Lists.newArrayList(address2));
//        user = userDAO.create(user);
//
//        user = userDAO.findById(user.getId(), select -> {
//            select.getAll();
//            select.getObject(ExtUser.extAddress_field, Selectable::selectAll);
//            select.getObject(ExtUser.extAddressList_field, Selectable::selectAll);
//        }).orElse(null);
//        return user;
//    }
//
//    @TAction(modelClass = User.class)
//    public User testCustomMap() {
//        User user = new User();
//        user.setUsername("a");
//        user.setName("a");
//        user.setPassword("a");
//        Map<String, Object> address1 = new HashMap<>();
//        address1.put("city", "c1");
//        Map<String, Object> address2 = new HashMap<>();
//        address2.put("city", "c2");
//        user.set(ExtUser.extAddress_field, address1);
//        user.set(ExtUser.extAddressList_field, Lists.newArrayList(address2));
//        user = userDAO.create(user);
//        return user;
//    }


    @TAction(modelClass = User.class)
    public User testList() {
        List<User> user = userDAO.find(q -> {
            q.where(conditionSet -> conditionSet.condition(User.sex_field, Operators.EQ, Sex.man));
            q.selectAll();
        });
        return user.get(0);
    }
}
