package io.terminus.trantor.demo.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Xyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderDTO extends Order {
    private String extra;
}
