package io.terminus.trantor.demo.user;

import io.terminus.trantor.demo.user.model.Order;
import lombok.Data;

/**
 * @author Xyf
 */
@Data
public class CustomOrder extends Order {
    private static final long serialVersionUID = -2847558739846405552L;

    private String activity;
}
