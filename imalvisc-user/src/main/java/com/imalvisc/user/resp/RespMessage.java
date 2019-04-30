package com.imalvisc.user.resp;

import com.imalvisc.user.enums.RespCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName RespMessage
 * @Description 请求响应包装类
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-30 11:53
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RespMessage<T> {

    /**
     * 响应代码
     */
    private int code;

    /**
     * 响应描述
     */
    private String msg;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 业务处理成功响应
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T> success(T t) {
        return new RespMessage<>(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getMsg(), t);
    }

    /**
     * 业务处理失败响应
     *
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T> fail(int code, String msg) {
        return new RespMessage<>(code, msg, null);
    }

    /**
     * 业务处理失败响应
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespMessage<T> fail(String msg) {
        return new RespMessage<>(RespCode.FAIL.getCode(), msg, null);
    }

}
