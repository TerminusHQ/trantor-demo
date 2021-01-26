package io.terminus.trantor.demo.chartdataaction;

import io.terminus.trantor.demo.dao.ClassesRepository;
import io.terminus.trantor.demo.dao.StudentRepository;
import io.terminus.trantor.demo.model.Classes;
import io.terminus.trantor.demo.model.Student;
import io.terminus.trantor.module.base.model.DashboardChartItem;
import io.terminus.trantor.sdk.datasource.ChartDataAction;
import io.terminus.trantor.sdk.datasource.ChartDataParams;
import io.terminus.trantor.sdk.datasource.ChartDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 仪表盘显示每个班级的学生数量
 * @author yaomingfeng
 */
@Component
public class HistogramDemoChartDataAction implements ChartDataAction {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassesRepository classesRepository;

    @Override
    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult histogramChartDataResult = new ChartDataResult();
        List<DashboardChartItem> data = new ArrayList<>();

        List<Classes> currClasses = classesRepository.find(classClassesQuery ->{});

        for (Classes current: currClasses) {
            DashboardChartItem item1 = new DashboardChartItem();
            item1.setLabel(current.getName());

            List<Student> response = studentRepository.find(query -> {
                        query.where(conditionSet -> {
                            conditionSet.condition(Student.classes_field, classes -> {
                                classes.eq(Classes.id_field, current.getId());
                            });
                        });
                    });
            item1.setValue(Long.valueOf(response.size()));
            data.add(item1);
        }

        histogramChartDataResult.setData(data);
        return histogramChartDataResult;
    }
}
