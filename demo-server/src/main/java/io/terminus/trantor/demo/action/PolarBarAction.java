package io.terminus.trantor.demo.action;

import io.terminus.trantor.sdk.datasource.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Description:
 *
 * @author: husc 2020-07-21 上午11:31
 */
@Slf4j
@Component
public class PolarBarAction implements GaugeDataAction {

    public GaugeDataResult load(GaugeDataParams gaugeDataParams) {
        GaugeDataResult result = new GaugeDataResult();

        GaugeDataResult.GaugeDataItem item = new GaugeDataResult.GaugeDataItem();
        item.setMax(100l);
        item.setMin(0l);
        item.setValue(78l);

        result.setData(item);
        return result;
    }
}
