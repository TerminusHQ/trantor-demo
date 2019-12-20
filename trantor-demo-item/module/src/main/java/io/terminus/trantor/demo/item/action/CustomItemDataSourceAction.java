package io.terminus.trantor.demo.item.action;

import io.terminus.trantor.demo.item.model.Item;
import io.terminus.trantor.demo.item.model.ItemTypeDict;
import io.terminus.trantor.sdk.datasource.SingleDataAction;
import io.terminus.trantor.sdk.query.QueryValues;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/9/21
 */
@Component
public class CustomItemDataSourceAction implements SingleDataAction<Item> {
    @Override
    public Item load(QueryValues queryValues) {
        Item item = new Item();
        item.setName("custom item");
        item.setType(ItemTypeDict.Real);
        item.setVideoUrl("not a video url");
        return item;
    }
}
