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
public class WebsiteAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<ChartDataResult.DashboardChartItem> result = new ArrayList<ChartDataResult.DashboardChartItem>();
        ChartDataResult.DashboardChartItem item = new ChartDataResult.DashboardChartItem();
        item.setLabel("2020-07-16");
        item.setValue(432l);
        result.add(item);

        ChartDataResult.DashboardChartItem item0 = new ChartDataResult.DashboardChartItem();
        item.setLabel("2020-07-15");
        item0.setValue(234l);
        result.add(item0);

        ChartDataResult.DashboardChartItem item00 = new ChartDataResult.DashboardChartItem();
        item00.setLabel("2020-07-14");
        item00.setValue(768l);
        result.add(item00);

        ChartDataResult.DashboardChartItem item000 = new ChartDataResult.DashboardChartItem();
        item000.setLabel("2020-07-13");
        item000.setValue(189l);
        result.add(item000);

        ChartDataResult.DashboardChartItem item0000 = new ChartDataResult.DashboardChartItem();
        item0000.setLabel("2020-07-12");
        item0000.setValue(189l);
        result.add(item0000);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
