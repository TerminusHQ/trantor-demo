package io.terminus.trantor.demo.action;

import io.terminus.trantor.module.base.model.DashboardChartItem;
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
public class UserLoginAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<DashboardChartItem> result = new ArrayList<DashboardChartItem>();
        DashboardChartItem item = new DashboardChartItem();
        item.setLabel("2020-07-16");
        item.setValue(432l);
        result.add(item);

        DashboardChartItem item1 = new DashboardChartItem();
        item1.setLabel("2020-07-15");
        item1.setValue(2312l);
        result.add(item1);

        DashboardChartItem item2 = new DashboardChartItem();
        item2.setLabel("2020-07-14");
        item2.setValue(332l);
        result.add(item2);

        DashboardChartItem item3 = new DashboardChartItem();
        item3.setLabel("2020-07-13");
        item3.setValue(154l);
        result.add(item3);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
