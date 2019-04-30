package com.imalvisc.user.aop;

import com.imalvisc.user.exception.RespException;
import com.imalvisc.user.resp.RespMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName ExceptionHandler
 * @Description 全局异常处理器
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-30 13:48
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionAOP {

    /**
     * 通用异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespMessage<Object> exception(Exception e) {
        log.error("系统异常: ", e);
        return RespMessage.fail(e.getMessage());
    }

    /**
     * 业务异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = RespException.class)
    @ResponseBody
    public RespMessage<Object> respException(RespException e) {
        log.error("业务异常: ", e);
        return RespMessage.fail(e.getCode(), e.getMsg());
    }

}
