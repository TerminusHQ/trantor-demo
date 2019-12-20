package io.terminus.trantor.demo.item.action;

import io.terminus.trantor.demo.item.model.Item;
import io.terminus.trantor.sdk.datasource.DataProcessorAction;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: AnsonChan
 * Date: 2019/9/23
 */
@Component
public class CustomItemDataProcessorAction implements DataProcessorAction<Item, Item> {
    @Override
    public Collection<Item> process(Collection<Item> data) {
        return data.stream()
                .peek(item -> item.setName(item.getName() + "_processed"))
                .collect(Collectors.toList());
    }
}
