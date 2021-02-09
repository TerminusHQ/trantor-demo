package io.terminus.trantor.demo.dao;


import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.sdk.autumn.dao.TrantorDAO;
import org.springframework.stereotype.Repository;

/**
 * @author ymf
 * @date 2021/1/20 10:49 上午
 */
@Repository
public class ClassesRepository extends TrantorDAO<Classes, Long> {
}
