package com.tiens.enjoylife.config.base;

import lombok.Data;

/**
 * 返回值
 *
 * @author liulong
 * @date 2020-06-03
 */
@Data
public class AbstractResult<T> {
    private final ReMessage result;
    private final T data;

    public AbstractResult(ReMessage result, T data) {
        this.result = result;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AbstractResult{" +
                "result=" + result +
                ", data=" + data +
                '}';
    }
}
