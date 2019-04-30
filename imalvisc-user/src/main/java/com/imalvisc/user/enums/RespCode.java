package com.imalvisc.user.enums;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RespCode
 * @Description 请求响应代码
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-30 11:48
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
public enum RespCode {

    SUCCESS(1, "成功"),
    FAIL(0, "失败");

    private int code;

    private String msg;

    RespCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
