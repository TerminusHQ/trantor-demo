package io.terminus.trantor.demo.dao;

import io.terminus.trantor.demo.model.Department;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;


/**
 * @author yaomingfeng
 */
@Repository
public class DepartmentRepository extends TrantorDAO<Department, Long> {
}
