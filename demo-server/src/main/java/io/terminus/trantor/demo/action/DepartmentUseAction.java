package io.terminus.trantor.demo.action;

import io.terminus.trantor.sdk.datasource.ChartDataAction;
import io.terminus.trantor.sdk.datasource.ChartDataParams;
import io.terminus.trantor.sdk.datasource.ChartDataResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: husc 2020-07-21 上午11:31
 */
@Component
public class DepartmentUseAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<ChartDataResult.DashboardChartItem> result = new ArrayList<ChartDataResult.DashboardChartItem>();
        ChartDataResult.DashboardChartItem item = new ChartDataResult.DashboardChartItem();
        item.setLabel("天津");
        item.setValue(23l);
        result.add(item);

        ChartDataResult.DashboardChartItem item1 = new ChartDataResult.DashboardChartItem();
        item1.setLabel("北京");
        item1.setValue(5l);
        result.add(item1);

        ChartDataResult.DashboardChartItem item2 = new ChartDataResult.DashboardChartItem();
        item2.setLabel("重庆");
        item2.setValue(25l);
        result.add(item2);

        ChartDataResult.DashboardChartItem item3 = new ChartDataResult.DashboardChartItem();
        item3.setLabel("安徽");
        item3.setValue(23l);
        result.add(item3);

        ChartDataResult.DashboardChartItem item4 = new ChartDataResult.DashboardChartItem();
        item4.setLabel("四川");
        item4.setValue(50l);
        result.add(item4);

        ChartDataResult.DashboardChartItem item5 = new ChartDataResult.DashboardChartItem();
        item5.setLabel("上海");
        item5.setValue(32l);
        result.add(item5);

        ChartDataResult.DashboardChartItem item6 = new ChartDataResult.DashboardChartItem();
        item6.setLabel("南京");
        item6.setValue(17l);
        result.add(item6);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
