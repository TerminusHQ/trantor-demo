package io.terminus.trantor.demo.action;

import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户模型自定义 server action
 *
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2020/7/13
 */
@Component
public class StudentServerAction {

    @Autowired
    private StudentRepository studentRepo;

    @TAction(modelClass = Student.class)
    public void delete(@TParam Student student) {
        studentRepo.delete(student.getId());
    }

    @TAction(modelClass = Student.class)
    public void save(@TParam Student student) {
        studentRepo.saveWithRelationSkipNull(student);
    }

}