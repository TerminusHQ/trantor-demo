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
public class UserChartAction implements ChartDataAction {

    public ChartDataResult load(ChartDataParams chartDataParams) {
        ChartDataResult chartDataResult = new ChartDataResult();
        List<ChartDataResult.ChartDataItem> result = new ArrayList<ChartDataResult.ChartDataItem>();
        ChartDataResult.ChartDataItem item = new ChartDataResult.ChartDataItem();
        item.setGroup("2020-07-16");
        item.setLabel("水果");
        item.setValue(432l);
        result.add(item);

        ChartDataResult.ChartDataItem item1 = new ChartDataResult.ChartDataItem();
        item1.setGroup("2020-07-15");
        item1.setLabel("药品");
        item1.setValue(2312l);
        result.add(item1);

        ChartDataResult.ChartDataItem item2 = new ChartDataResult.ChartDataItem();
        item2.setGroup("2020-07-14");
        item2.setLabel("肉禽");
        item2.setValue(332l);
        result.add(item2);

        ChartDataResult.ChartDataItem item3 = new ChartDataResult.ChartDataItem();
        item3.setGroup("2020-07-13");
        item3.setLabel("蔬菜");
        item3.setValue(154l);
        result.add(item3);


        chartDataResult.setData(result);
        return chartDataResult;
    }
}
