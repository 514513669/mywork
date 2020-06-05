package com.tiens.enjoylife.config;

import cn.hutool.core.lang.UUID;
import com.tiens.enjoylife.config.base.AbstractResult;
import com.tiens.enjoylife.config.base.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 类描述: 全局异常拦截处理器
 * 1.处理异常
 * 2.未知异常统一返回服务器错误
 * 3.已经catch到的异常不会被捕获
 * 4.异常的体系结构中，哪个异常与目标方法抛出的异常血缘关系越紧密，就会被哪个捕捉到。
 *
 * @author liulong
 * @version 1.0
 * @date 2020/3/12 22:13
 * @see ExceptionHandler：统一处理某一类异常，从而能够减少代码重复率和复杂度
 * @see ControllerAdvice：异常集中处理，更好的使业务逻辑与异常处理剥离开
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public AbstractResult<?> allServiceExceptionHandel(Exception e) {
        String logId = UUID.randomUUID().toString();
        String formErrorMsg = String.format("系统发生异常，日志号【%s】, 错误信息：【%s】", logId, e);
        log.error(formErrorMsg, e);
        return ResultUtil.defaultFailure(formErrorMsg);
    }

}
