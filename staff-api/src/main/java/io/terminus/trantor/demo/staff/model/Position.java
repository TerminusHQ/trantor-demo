package io.terminus.trantor.demo.staff.model;

import io.terminus.trantor.demo.staff.dict.PositionType;
import io.terminus.trantor.module.base.acl.ACLNode;
import io.terminus.trantor.module.base.acl.ACLNodeType;
import io.terminus.trantor.module.base.enums.OrgStatus;
import io.terminus.trantorframework.api.BaseModel;
import io.terminus.trantorframework.api.annotation.*;
import io.terminus.trantorframework.api.annotation.typemeta.DictionaryMeta;
import io.terminus.trantorframework.api.annotation.typemeta.TextMeta;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * @author liuyayue
 * @date 2021/4/21 8:18 下午
 */
@EqualsAndHashCode(callSuper = true)
@Model(
        name = "岗位",
        mainField = Position.name_field,
        indexes = {
                @Index(columns = Position.code_field, unique = true),
        },
        fieldGroups = {
                @FieldGroup(fieldName = {Position.id_field, Position.code_field, Position.name_field}),
                @FieldGroup(fieldName = {Position.code_field, Position.name_field}, type = FieldGroupType.SEARCHABLE),
                @FieldGroup(fieldName = {Position.code_field, Position.name_field}, type = FieldGroupType.SEARCH_SHOW),
        },
        config = @ModelConfig(
                enableSearch = true,
                enableImport = true,
                enableExport = true
        )
)
@Data
public class Position extends BaseModel<Long> implements ACLNode {
    public static final String key = "base_Position";
    private static final long serialVersionUID = 5899298492553180481L;
    @Field(name = "岗位编码")
    @TextMeta(rule = "STRING(POS)+TIMES(yyyy-MM-dd)+INCRE(1,6,0,0)")
    private String code;

    @Field(name = "岗位名称")
    @NotNull(message = "岗位名称不能为空")
    private String name;

    @Field(name = "岗位类型", defaultValue = PositionType.primary, nullable = false)
    @DictionaryMeta(value = PositionType.class)
    @NotNull(message = "岗位类型不能为空")
    private String type;

    @Field(name = "岗位详情", type = FieldType.RichText)
    private String remark;

    @Field(name = "状态", defaultValue = "Enable", nullable = false)
    private OrgStatus status;

    @Override
    public String bizId() {
        return this.id == null ? null : this.id.toString();
    }

    @Override
    public String bizName() {
        return this.name;
    }

    @Override
    public ACLNodeType bizType() {
        return ACLNodeType.position;
    }
}
