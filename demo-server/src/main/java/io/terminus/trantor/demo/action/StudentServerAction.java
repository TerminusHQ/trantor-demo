package io.terminus.trantor.demo.action;

import io.terminus.trantor.api.TContext;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 学生相关 server action
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

        Integer id = TContext.getFrontendContext().getCurrentBusinessDimensionId();
        Classes classes = new Classes();
        classes.setId(Long.valueOf(id));
        student.setClasses(classes);
        studentRepo.saveWithRelationSkipNull(student);
    }



}