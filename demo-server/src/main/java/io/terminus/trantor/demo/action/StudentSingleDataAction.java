package io.terminus.trantor.demo.action;

import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.datasource.SingleDataAction;
import io.terminus.trantor.sdk.datasource.SingleDataParams;
import io.terminus.trantor.sdk.datasource.SingleDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chengong
 * @date 8:50 下午
 * @desc  这里演示dataAction 返回单条数据的场景
 */
@Component
public class StudentSingleDataAction implements SingleDataAction<Student> {
    @Autowired
    private StudentRepository studentRepo;

    @Override
    public SingleDataResult<Student> load(SingleDataParams singleDataParams) {
        Integer id = singleDataParams.getQueryValues().getOneValue("id");
        Student student = studentRepo.findById(Long.valueOf(id)).get();
        return new SingleDataResult(student);
    }
}
