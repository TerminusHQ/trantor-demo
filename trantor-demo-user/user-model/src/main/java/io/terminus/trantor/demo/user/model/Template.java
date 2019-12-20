package io.terminus.trantor.demo.user.model;

import io.terminus.trantor.api.annotation.TModelField;
import io.terminus.trantor.api.annotation.typemeta.RelationMeta;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Xyf
 */
@Data
public class Template implements Serializable {
    private static final long serialVersionUID = 36860781092262196L;
    @TModelField
    private String innerStr;
    @TModelField
    @RelationMeta(name = "UserToLongId")
    private LongId longId;
}
