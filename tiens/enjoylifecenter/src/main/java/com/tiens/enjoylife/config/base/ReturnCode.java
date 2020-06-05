package com.tiens.enjoylife.config.base;

import lombok.Getter;

/**
 * 错误码和错误信息定义
 *
 * @author liulong
 * @date 2020-06-03
 */
@Getter
public enum ReturnCode {
    /**
     * 成功标识
     */
    SUCCESS("0", "成功"),

    /**
     * 失败标识
     */
    FAIL("1", "失败");

    private final String errorCode;
    private final String errorDesc;

    ReturnCode(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

}
