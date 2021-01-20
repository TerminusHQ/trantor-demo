package io.terminus.trantor.demo.model;

import io.terminus.trantor.api.annotation.BaseModel;
import io.terminus.trantor.api.annotation.TModel;

/**
 * @author ymf
 * 学生卡信息，这里用来描述学生卡与学生之间一对一的关系
 */
@TModel(name = "学生校园卡")
public class StudentCard extends BaseModel<Long> {
    private static final long serialVersionUID = 8278850590518272963L;
}
