package io.terminus.trantor.demo.action;

import io.terminus.trantor.demo.dao.DepartmentRepository;
import io.terminus.trantor.demo.model.Department;
import io.terminus.trantor.sdk.autumn.param.Operators;
import io.terminus.trantor.sdk.datasource.tree.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.terminus.common.utils.Arguments;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ymf
 * 这里用来展示树形结构数据
 */
@Component
public class SchoolDeparementTreeAction implements TreeDataAction<Department, Long> {

    @Autowired
    DepartmentRepository dao;

    /**
     * 作用于父节点点击[+]展开子级数据时，返回子级数据；需要注意由于此处无分页，如果单级数据量非常大时，建议不要使用树形交互方式
     */
    @Override
    public TreeDataResult<Department> loadChildren(@Nullable Long parentId, TreeDataParams params) {
        List<Department> result = new ArrayList<>();

        if (parentId == null) {
            //获取顶级容器
            Optional<Department> response = dao.findOne(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.parent_field, Operators.EQ, null));

                query.selectAll();
                query.orderBy(Department.createdAt_field, false);
            });

            result.add(response.get());
        } else {
            //获取当前层级的下一级
            List<Department> response = dao.find(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.parent_field, depart -> {
                    depart.eq(Department.id_field, parentId);
                }));

                query.selectAll();
                query.orderBy(Department.createdAt_field, false);
            });
            //获取上一层级
            Optional<Department> parent = dao.findOne(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.id_field, Operators.EQ, parentId));

                query.selectAll();
            });
            //填充
            for (Department department : response) {
                department.setParent(parent.get());
            }

            result.addAll(response);
        }

        return new TreeDataResult<>(result);
    }

    /**
     * 用于树形容器和控件的搜索框提示。需返回模糊搜索的前几条结果，建议不超过十条。返回数据仅需包含 id 和显示名。
     */
    @Override
    public TreeSearchResult<Long> search(TreeDataParams params) {
        List<TreeItem<Long>> result = new ArrayList<>();
        //获取name字段含有输入关键信息
        List<Department> response = dao.find(query -> {
            query.where(conditionSet -> conditionSet.condition(Department.name_field, Operators.CONTAINS, params.getFuzzyValue()));

            query.selectAll();
            query.orderBy(Department.createdAt_field, false);
        });


        for (Department department : response) {
            TreeItem<Long> t = new TreeItem<>();
            t.setId(department.getId());
            t.setDisplayName(department.getName());

            result.add(t);
        }

        return new TreeSearchResult<>(result);
    }

    /**
     * 一般和 search 方法配套使用，用于从一条特定数据反向构建树，以便树形容器能正常展示数据。
     * 反向构建需要包含该条数据本身；该条数据的兄弟节点数据；该条数据的祖先链和祖先链上每个节点的兄弟节点数据。
     * 数据无需按树形进行组织，只需全部平铺为 List 即可。但需要保证每条数据都带有给定的 parentId 字段。Trantor 前端数据容器将根据返回数据组织成树。
     *
     * @param parentId 上一级ID
     * @param params   其他相关参数
     * @return 返回数据结果集
     */
    @Override
    public TreeDataResult<Department> reverseBuild(@Nullable Long parentId, TreeDataParams params) {

        List<Department> result = new ArrayList<>();

        Long temp=parentId;
        while (true) {

            //获取当前层级
            Long finalTemp = temp;
            Optional<Department> currentResponse = dao.findOne(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.id_field, Operators.EQ, finalTemp));
                query.select(select -> select.getObject(Department.parent_field));
                query.selectAll();
            });
            result.add(currentResponse.get());
            //获取上一级
            Optional<Department> before = dao.findOne(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.id_field, Operators.EQ, currentResponse.get().getParent().getId()));
                query.select(select -> select.getObject(Department.parent_field));
                query.selectAll();
            });

            if(Arguments.isNull(before.get().getParent())){

                break;
            }
            //获取当前层级的下一级
            List<Department> response = dao.find(query -> {
                query.where(conditionSet -> conditionSet.condition(Department.parent_field, depart -> {
                    depart.eq(Department.id_field, before.get().getParent().getId());
                }));

                query.select(select -> select.getObject(Department.parent_field));
                query.selectAll();
                query.orderBy(Department.createdAt_field, false);

            });
            temp= currentResponse.get().getParent().getId();
            result.addAll(response);
        }
        return new TreeDataResult<>(result);
    }

    /**
     * 方法用于树控件的数据回填（例如 ：加载更多，或者下拉框的场景）
     */
    @Override
    public TreeDataResult<Department> loadByIds(List<Long> longs, TreeDataParams params) {

        List<Department> response = dao.findByIds(longs);

        return new TreeDataResult<>(response);
    }
}