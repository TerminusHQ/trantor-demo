package io.terminus.trantor.demo.action;


import io.terminus.common.model.Paging;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.datasource.MultiDataAction;
import io.terminus.trantor.sdk.datasource.MultiDataParams;
import io.terminus.trantor.sdk.datasource.MultiDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

        int pageNo = multiDataParams.getPaging() != null ? multiDataParams.getPaging().getNo() : 1;
        int pageSize = multiDataParams.getPaging() != null ? multiDataParams.getPaging().getSize() : 10;

        Paging<Student> solutions = studentRepo.page(conditionSet -> {

        }, pageNo, pageSize);

        return new MultiDataResult<>(solutions.getData(), solutions.getTotal());
    }
}
