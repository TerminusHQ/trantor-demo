package io.terminus.trantor.demo.action;

import io.terminus.trantor.api.TContext;
import io.terminus.trantor.api.annotation.RootModel;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TCollectionParam;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.autumn.param.Operators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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


    @TAction(modelClass = Student.class)
    public void batchsave(@TCollectionParam(Student.class) List<Student> students) {

        studentRepo.saveWithRelationSkipNull(students);
    }


    @TAction(modelClass = Student.class)
    public void update(@TParam Student student) {

        studentRepo.updateConnectRelationSkipNull(student);
    }

    @TAction(modelClass = Student.class)
    public void batchupdate(@TCollectionParam(Student.class) List<Student> students) {

        studentRepo.updateConnectRelationSkipNull(students);
    }

    @TAction(modelClass = Student.class)
    public void batchdelete(@TCollectionParam(Student.class) List<Student> students) {

        List<Long> ids = students.stream().map(RootModel::getId).collect(Collectors.toList());

        studentRepo.delete(ids);
    }

    @TAction(modelClass = Student.class)
    public void deleteByCondition(String name, String id) {
        studentRepo.delete(student -> {
            student.condition(Student.name_field, Operators.CONTAINS, name);
            student.condition(Student.id_field, Operators.EQ, id);
        });
    }
}