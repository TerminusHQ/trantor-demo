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
public class ActivityUserAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<ChartDataResult.DashboardChartItem> result = new ArrayList<ChartDataResult.DashboardChartItem>();
        ChartDataResult.DashboardChartItem item = new ChartDataResult.DashboardChartItem();
        item.setGroup("2020-07-16");
        item.setLabel("活动页面成功支付人数");
        item.setValue(432l);
        result.add(item);

        ChartDataResult.DashboardChartItem item0 = new ChartDataResult.DashboardChartItem();
        item0.setGroup("2020-07-15");
        item0.setLabel("活动页面成功支付人数");
        item0.setValue(234l);
        result.add(item0);

        ChartDataResult.DashboardChartItem item00 = new ChartDataResult.DashboardChartItem();
        item00.setGroup("2020-07-14");
        item00.setLabel("活动页面成功支付人数");
        item00.setValue(768l);
        result.add(item00);

        ChartDataResult.DashboardChartItem item000 = new ChartDataResult.DashboardChartItem();
        item000.setGroup("2020-07-13");
        item000.setLabel("活动页面成功支付人数");
        item000.setValue(189l);
        result.add(item000);

        ChartDataResult.DashboardChartItem item0000 = new ChartDataResult.DashboardChartItem();
        item0000.setGroup("2020-07-12");
        item0000.setLabel("活动页面成功支付人数");
        item0000.setValue(189l);
        result.add(item0000);


        ChartDataResult.DashboardChartItem item1 = new ChartDataResult.DashboardChartItem();
        item1.setGroup("2020-07-16");
        item1.setLabel("活动页面下单人数");
        item1.setValue(2312l);
        result.add(item1);

        ChartDataResult.DashboardChartItem item2 = new ChartDataResult.DashboardChartItem();
        item2.setGroup("2020-07-15");
        item2.setLabel("活动页面下单人数");
        item2.setValue(3425l);
        result.add(item2);

        ChartDataResult.DashboardChartItem item3 = new ChartDataResult.DashboardChartItem();
        item3.setGroup("2020-07-14");
        item3.setLabel("活动页面下单人数");
        item3.setValue(1872l);
        result.add(item3);

        ChartDataResult.DashboardChartItem item4 = new ChartDataResult.DashboardChartItem();
        item4.setGroup("2020-07-13");
        item4.setLabel("活动页面下单人数");
        item4.setValue(1029l);
        result.add(item4);

        ChartDataResult.DashboardChartItem item5 = new ChartDataResult.DashboardChartItem();
        item5.setGroup("2020-07-12");
        item5.setLabel("活动页面下单人数");
        item5.setValue(898l);
        result.add(item5);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
