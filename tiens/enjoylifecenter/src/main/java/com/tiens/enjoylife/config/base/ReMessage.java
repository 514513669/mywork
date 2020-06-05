package com.tiens.enjoylife.config.base;

import lombok.Data;

/**
 * 返回信息
 *
 * @author liulong
 * @date 2020-06-03
 */
@Data
public class ReMessage {

    private String returnCode;
    private String returnMessage;
    private String returnUserMessage;

    public String getReturnCode() {
        return returnCode;
    }

    public ReMessage(String returnCode, String returnMessage) {
        this.returnCode = returnCode;
        this.returnMessage = returnMessage;
        this.returnUserMessage = returnMessage;
    }

    public ReMessage() {
    }

    public ReMessage(ReturnCode errObj) {
        this.returnCode = errObj.getErrorCode();
        this.returnMessage = errObj.getErrorDesc();
        this.returnUserMessage = returnMessage;
    }
}
