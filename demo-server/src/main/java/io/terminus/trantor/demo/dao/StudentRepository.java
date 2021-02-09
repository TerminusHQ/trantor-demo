package io.terminus.trantor.demo.dao;

import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;


/**
 * @author yaomingfeng
 */
@Repository
public class StudentRepository extends TrantorDAO<Student, Long> {
}
