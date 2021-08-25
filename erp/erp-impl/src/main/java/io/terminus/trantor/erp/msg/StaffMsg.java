package io.terminus.trantor.erp.msg;

import io.terminus.trantorframework.api.annotation.Message;

/**
 * @author trantor@terminus.io
 * @date 2021/6/22
 */
public interface StaffMsg {

    @Message("invalid phone format")
    String EX_PHONE_INVALID = "Staff.PhoneInvalid";

}
