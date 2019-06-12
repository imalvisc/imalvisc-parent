package com.imalvisc.user.aop;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONUtil;
import com.imalvisc.user.enums.RespCode;
import com.imalvisc.user.exception.RespException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author imalvisc
 * @version v1.0
 * @ClassName ControllerAOP
 * @Description Controller通用切面
 * @motto 学会编程而不是学会编码！
 * @date 2019-04-29 17:01
 * @Copyright Guangzhou CheXingYi Information Technology Co., Ltd.
 */
@Slf4j
@Component
@Aspect
public class ControllerAOP {

    /**
     * 切点
     */
    @Pointcut("execution(public * com.imalvisc.user.controller..*.*(..))")
    public void pointCut() {
    }

    /**
     * 环绕处理
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "pointCut()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request =
                ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            //处理参数验证错误影响
            Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
            if (ArrayUtil.isNotEmpty(parameterTypes)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i].isAssignableFrom(BindingResult.class)) {
                        BindingResult bindingResult = (BindingResult) joinPoint.getArgs()[i];
                        if (bindingResult.hasErrors()) {
                            StringBuilder builder = new StringBuilder();
                            List<ObjectError> allErrors = bindingResult.getAllErrors();
                            for (ObjectError objectError : allErrors) {
                                builder.append(objectError.getDefaultMessage()).append(",");
                            }
                            String message = builder.toString();
                            if (message.length() > 1) {
                                message = message.substring(0, message.length() - 1);
                            }
                            throw new RespException(RespCode.FAIL.getCode(), message);
                        }
                    }
                }
            }
            //执行代理对象方法
            result = joinPoint.proceed();
        } finally {
            //打印请求信息
            log.info("\n请求接口: {}\n远程IP: {}\n请求参数: {}\n执行结果: {}\n消耗时间(ms): {}",
                    request.getRequestURL(),
                    ServletUtil.getClientIP(request),
                    getMethodParams(joinPoint),
                    JSONUtil.toJsonStr(result),
                    System.currentTimeMillis() - start);
        }
        return result;
    }

    /**
     * 获取切点参数信息
     *
     * @param joinPoint
     * @return
     */
    private String getMethodParams(ProceedingJoinPoint joinPoint) {
        Map<String, Object> result = new LinkedHashMap<>();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?>[] parameterTypes = signature.getParameterTypes();
        String[] parameterNames = signature.getParameterNames();
        if (ArrayUtil.isNotEmpty(parameterNames)) {
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < parameterNames.length; i++) {
                //过滤某些通用入参
                if (!parameterTypes[i].isAssignableFrom(HttpServletRequest.class)
                        && !parameterTypes[i].isAssignableFrom(HttpServletResponse.class)
                        && !parameterTypes[i].isAssignableFrom(HttpSession.class)
                        && !parameterTypes[i].isAssignableFrom(BindingResult.class)
                        && !parameterTypes[i].isAssignableFrom(ModelMap.class)) {
                    result.put(parameterNames[i], args[i]);
                }
            }
        }
        return JSONUtil.toJsonStr(result);
    }

}
