//package io.terminus.trantor.demo.user.biz;
//
//import io.terminus.trantor.demo.user.model.Order;
//import io.terminus.trantor.sdk.StandardActions;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @author Xyf
// */
//@Component
//public class CustomOrderAction extends StandardActions<Order, String> {
//
//    @Resource
//    private NewOrderDAO newUserDAO;
//
//    @Override
//    public Order create(Order modelData) {
//        return newUserDAO.create(modelData, select -> {
//            select.getAll();
//            select.getObject("skuOrders", skuOrders -> skuOrders.select("id", "price", "activity"));
//        });
//    }
//
//    @Override
//    public Order update(Order modelData) {
//        return newUserDAO.update(modelData);
//    }
//
//    @Override
//    public Boolean delete(String idValue) {
//        newUserDAO.delete(idValue);
//        return true;
//    }
//
//    @Override
//    public Boolean removeRelation(Order modelData) {
//        return true;
//    }
//}
