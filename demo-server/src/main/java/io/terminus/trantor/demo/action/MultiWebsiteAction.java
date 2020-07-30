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
public class MultiWebsiteAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<DashboardChartItem> result = new ArrayList<DashboardChartItem>();
        DashboardChartItem item = new DashboardChartItem();
        item.setGroup("周一");
        item.setLabel("邮件营销");
        item.setValue(432l);
        result.add(item);

        DashboardChartItem item0 = new DashboardChartItem();
        item0.setGroup("周二");
        item0.setLabel("邮件营销");
        item0.setValue(234l);
        result.add(item0);

        DashboardChartItem item00 = new DashboardChartItem();
        item00.setGroup("周三");
        item00.setLabel("邮件营销");
        item00.setValue(768l);
        result.add(item00);

        DashboardChartItem item000 = new DashboardChartItem();
        item000.setGroup("周四");
        item000.setLabel("邮件营销");
        item000.setValue(189l);
        result.add(item000);

        DashboardChartItem item0000 = new DashboardChartItem();
        item0000.setGroup("周五");
        item0000.setLabel("邮件营销");
        item0000.setValue(189l);
        result.add(item0000);


        DashboardChartItem item1 = new DashboardChartItem();
        item1.setGroup("周一");
        item1.setLabel("联盟广告");
        item1.setValue(564l);
        result.add(item1);

        DashboardChartItem item11 = new DashboardChartItem();
        item11.setGroup("周二");
        item11.setLabel("联盟广告");
        item11.setValue(782l);
        result.add(item11);

        DashboardChartItem item111 = new DashboardChartItem();
        item111.setGroup("周三");
        item111.setLabel("联盟广告");
        item111.setValue(2182l);
        result.add(item111);

        DashboardChartItem item1111 = new DashboardChartItem();
        item1111.setGroup("周四");
        item1111.setLabel("联盟广告");
        item1111.setValue(2323l);
        result.add(item1111);

        DashboardChartItem item11111 = new DashboardChartItem();
        item11111.setGroup("周五");
        item11111.setLabel("联盟广告");
        item11111.setValue(765l);
        result.add(item11111);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
