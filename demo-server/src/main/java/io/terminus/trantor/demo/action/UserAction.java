package io.terminus.trantor.demo.action;

import com.google.common.base.Strings;
import io.terminus.trantor.demo.model.User;
import io.terminus.trantor.metaStore.meta.application.Application;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import io.terminus.trantor.sdk.query.QueryValues;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: husc 2020-07-21 上午11:21
 */
@Slf4j
@Component
public class UserAction implements MultiDataAction<User> {

    public MultiDataResult<User> load(QueryValues queryValues, MultiDataParams multiDataParams) {

        List<User> result = new ArrayList<User>();
        User user = new User();
        user.setName("张三");
        user.setEmail("77777@qq.com");
        user.setPhone("18522937356");
        result.add(user);

        User user1= new User();
        user1.setName("李四");
        user1.setEmail("7123432@qq.com");
        user1.setPhone("13786244743");
        result.add(user1);

        User user2 = new User();
        user2.setName("王五");
        user2.setEmail("63562883@qq.com");
        user2.setPhone("15276359845");
        result.add(user2);


        return new MultiDataResult<User>(result, (long) result.size());
    }
}
