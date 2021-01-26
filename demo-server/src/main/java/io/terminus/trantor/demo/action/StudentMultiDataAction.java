package io.terminus.trantor.demo.action;


import io.terminus.trantor.api.TContext;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengong
 * @date 2021/1/19 8:34 下午
 * @desc  这里演示dataAction 返回多条数据的场景
 */
@Component
public class StudentMultiDataAction implements MultiDataAction<Student> {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public MultiDataResult<Student> load(MultiDataParams multiDataParams) {

        // 获取业务维度id，对应班级的id
        Integer id = TContext.getFrontendContext().getCurrentBusinessDimensionId();

        List<Student> response = studentRepo.find(query -> {
            query.where(conditionSet -> {
                conditionSet.condition(Student.classes_field, classes -> {
                    classes.eq(Classes.id_field, id);
                });
            });
            query.selectAll();
            query.orderBy(Student.createdAt_field, false);
        });

        return new MultiDataResult(response, (long) response.size());
    }
}
