package com.tiens.enjoylife.config;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 为controller打印输入输出
 *
 * @author admin
 * @date 2019-05-20
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    private static final int LOG_LENGTH = 2000;

    /**
     * Controller日志统一打印
     * 请求method前打印内容
     * 输出日志
     */
    @Around("execution(public * com.tiens.enjoylife.controller.*.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        Object[] args = pjp.getArgs();
        List<Object> list = new ArrayList<>();
        for (Object obj : args) {
            if (obj instanceof MultipartFile) {
                continue;
            }

            if (obj instanceof MultipartRequest) {
                continue;
            }
            list.add(obj);
        }
        //接口全称
        Signature signature = pjp.getSignature();
        //记录入参
        log.info("http invoke requestParams【{}】【请求参数】 [{}]", signature, JSONUtil.toJsonStr(list));
        long startTime = System.currentTimeMillis();

        try {
            // 调用目标方法
            result = pjp.proceed(args);
        } finally {
            String toJsonStr = JSONUtil.toJsonStr(result);
            if (toJsonStr.length() > LOG_LENGTH) {
                log.info("http invoke response【{}】【返回结果】 [{}] coast time {} ms", signature, toJsonStr.substring(0, LOG_LENGTH), System.currentTimeMillis() - startTime);
            } else {
                log.info("http invoke response【{}】【返回结果】 [{}] coast time {} ms", signature, toJsonStr, System.currentTimeMillis() - startTime);
            }
        }
        return result;
    }

}
