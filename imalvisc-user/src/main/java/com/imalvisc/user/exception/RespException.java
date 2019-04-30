package com.imalvisc.user.exception;

import com.imalvisc.user.enums.RespCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RespException
 * @Description 请求响应异常
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-30 11:44
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RespException extends RuntimeException {

    private int code;

    private String msg;

    public RespException() {
        super();
    }

    public RespException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public RespException(RespCode respCode) {
        super();
        this.code = respCode.getCode();
        this.msg = respCode.getMsg();
    }

}
