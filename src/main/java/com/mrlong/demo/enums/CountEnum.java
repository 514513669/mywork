package com.mrlong.demo.enums;


import lombok.Getter;

/**
 * @author liulong
 * @version 1.0
 * @date 2020/5/24 2:54 下午
 */
@Getter
public enum CountEnum {

    /**
     * ABCDEF
     */
    A(1, "A"),
    B(2, "B"),
    C(3, "C"),
    D(4, "D"),
    E(5, "E"),
    F(6, "F");

    final private int code;
    final private String msg;

    CountEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CountEnum getCountEnum(int code) {
        for (CountEnum countEnum : CountEnum.values()) {
            if (countEnum.getCode() == code) {
                return countEnum;
            }
        }
        return null;
    }

}
