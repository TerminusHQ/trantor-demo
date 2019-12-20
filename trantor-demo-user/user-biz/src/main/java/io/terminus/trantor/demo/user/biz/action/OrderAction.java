package io.terminus.trantor.demo.user.biz.action;

import cn.hutool.core.io.FileUtil;
import com.google.common.collect.Lists;
import io.terminus.platform.sdk.dao.DataStoreTemplate;
import io.terminus.trantor.api.annotation.TAction;
import io.terminus.trantor.api.annotation.params.TCollectionParam;
import io.terminus.trantor.api.annotation.params.TModelsParam;
import io.terminus.trantor.api.annotation.params.TParam;
import io.terminus.trantor.api.annotation.params.Valid;
import io.terminus.trantor.common.model.convert.ModelUtils;
import io.terminus.trantor.demo.user.CustomOrder;
import io.terminus.trantor.demo.user.biz.NewOrderDAO;
import io.terminus.trantor.demo.user.model.Address;
import io.terminus.trantor.demo.user.model.Order;
import io.terminus.trantor.demo.user.model.SkuOrder;
import io.terminus.trantor.sdk.oss.OSSClient;
import io.terminus.trantor.sdk.params.Load;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

/**
 * @author Xyf
 */
@Component
@RequiredArgsConstructor
public class OrderAction {
    private final DataStoreTemplate template;
    private final OSSClient ossClient;
    private final NewOrderDAO orderDAO;

    @TAction(modelClass = Order.class)
    public void test(@TModelsParam(SkuOrder.class) List<SkuOrder> skuOrders,
                     @Load Order order, @TParam BigDecimal total,
                     Address address) {
        System.out.println(skuOrders.toString() + order + total + address);
    }

    @TAction(modelClass = Order.class)
    public void testList(@TCollectionParam(Long.class) List<Long> id) {
        System.out.println(id.toString());
    }

    @SneakyThrows
    @TAction(modelClass = Order.class)
    public String upload() {
        File file = File.createTempFile("template", ".txt");
        FileUtil.writeString("test", file, StandardCharsets.UTF_8);
        return ossClient.upload("a.txt", file).orElse(null);
    }

    @TAction(modelClass = Order.class)
    public void download() {
        ossClient.download("a.txt").ifPresent(stream -> {
            try {
                System.out.println(IOUtils.toString(stream, StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @TAction(modelClass = Order.class)
    public CustomOrder custom(@Load CustomOrder customOrder) {
        System.out.println(customOrder.getActivity());
        return customOrder;
    }

    @TAction(modelClass = Order.class)
    public Order ref(@Valid Order o) {
        Order order = new Order();
        SkuOrder skuOrder = new SkuOrder();
        skuOrder.setOrder(order);
        order.setSkuOrders(Lists.newArrayList(skuOrder));
        Map<String, Object> map = ModelUtils.modelToMap(order, Order.class);
        orderDAO.create(order);
        return order;
    }
}
