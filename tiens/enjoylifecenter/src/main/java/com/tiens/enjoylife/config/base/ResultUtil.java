package com.tiens.enjoylife.config.base;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 提示码
 *
 * @author liulong
 * @date 2020-06-03
 */
public class ResultUtil {
    public static AbstractResult<?> defaultSuccess() {
        return new AbstractResult<>(new ReMessage(ReturnCode.SUCCESS.getErrorCode(), ReturnCode.SUCCESS.getErrorDesc()),
                null);
    }

    public static AbstractResult<?> defaultSuccess(Object o) {
        return new AbstractResult<>(new ReMessage(ReturnCode.SUCCESS.getErrorCode(), ReturnCode.SUCCESS.getErrorDesc()),
                o);
    }

    public static AbstractResult<?> defaultSuccess(ReturnCode returnCode) {
        return new AbstractResult<>(new ReMessage(ReturnCode.SUCCESS.getErrorCode(), returnCode.getErrorDesc()),
                null);
    }

    public static AbstractResult<?> defaultFailure() {
        return new AbstractResult<>(new ReMessage(ReturnCode.FAIL.getErrorCode(), ReturnCode.FAIL.getErrorDesc()),
                null);
    }

    public static AbstractResult<?> defaultFailure(String errorInfo) {
        return new AbstractResult<>(new ReMessage(ReturnCode.FAIL.getErrorCode(), errorInfo),
                null);
    }

    public static AbstractResult<?> defaultFailure(String errorCode, String errorInfo) {
        return new AbstractResult<>(new ReMessage(errorCode, errorInfo),
                null);
    }

    public static AbstractResult<?> defaultFailure(ReturnCode resultCode) {
        return new AbstractResult<>(new ReMessage(ReturnCode.FAIL.getErrorCode(), resultCode.getErrorDesc()),
                null);
    }

    public static AbstractResult<?> defaultFailure(Object object) {
        return new AbstractResult<>(new ReMessage(ReturnCode.FAIL.getErrorCode(), ReturnCode.FAIL.getErrorDesc()),
                object);
    }

    public static AbstractResult<?> defaulGridSuccess(int count, int pages, Object object) {
        Map<String, Object> maps = new ConcurrentHashMap<>(3);
        maps.put("total", count);
        maps.put("pages", pages);
        maps.put("rows", object);
        return new AbstractResult<>(new ReMessage(ReturnCode.SUCCESS), maps);
    }
}
