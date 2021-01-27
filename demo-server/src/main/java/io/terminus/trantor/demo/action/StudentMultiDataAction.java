package io.terminus.trantor.demo.action;


import io.terminus.common.utils.Arguments;
import io.terminus.trantor.api.TContext;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.autumn.param.Operators;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import io.terminus.trantor.sdk.query.QueryValues;
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

    public StudentMultiDataAction(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public MultiDataResult<Student> load(MultiDataParams multiDataParams) {

        // 获取业务维度id，对应班级的id
        Integer id = TContext.getFrontendContext().getCurrentBusinessDimensionId();

        List<Student> response = studentRepo.find(query -> {
            query.where(conditionSet -> {
                conditionSet.condition(Student.classes_field, classes -> {
                    classes.eq(Classes.id_field, id);
                });
                QueryValues searchValues = multiDataParams.getSearchValues();
                if(searchValues.size()!=0){
                    if(!Arguments.isNullOrEmpty(searchValues.getOneValue(Student.name_field)) ){
                        conditionSet.condition(Student.name_field, Operators.EQ,searchValues.getOneValue(Student.name_field));
                    }
                    if(!Arguments.isNullOrEmpty(searchValues.getOneValue(Student.mobile_field))){
                        conditionSet.condition(Student.mobile_field,Operators.EQ,searchValues.getOneValue(Student.mobile_field));
                    }
                }
            });

            query.selectAll();
            query.orderBy(Student.createdAt_field, false);
        });

        return new MultiDataResult(response, (long) response.size());
    }
}
