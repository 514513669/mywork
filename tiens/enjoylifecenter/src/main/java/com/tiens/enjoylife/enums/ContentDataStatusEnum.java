package com.tiens.enjoylife.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 记录状态
 *
 * @author baikq
 */
@Getter
public enum ContentDataStatusEnum {

    /**
     * 1.新建（草稿）2.待审核 3.审批不通过（驳回）4.审核通过 5.未开始展示 6.展示中 7.上架  8.下架  9.已删除
     */
    DRAFT(1, "草稿"),
    NO_AUDIT(2, "待审核"),
    REJECT(3, "审批不通过（驳回）"),
    PASS(4, "审批通过"),
    NO_SHOW(5, "未开始展示"),
    SHOWED(6, "展示中"),
    UP(7, "上架"),
    DOWN(8, "下架"),
    DELETED(8, "已删除");

    private final int code;
    private final String desc;

    ContentDataStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(int code) {
        for (ContentDataStatusEnum temp : ContentDataStatusEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getDesc();
            }
        }
        return null;
    }

    private static final Map<Integer, ContentDataStatusEnum> CODES = new HashMap<>();

    static {
        for (ContentDataStatusEnum v : ContentDataStatusEnum.values()) {
            CODES.put(v.getCode(), v);
        }
    }


    public static ContentDataStatusEnum getAuditStatusEnum(Object type) {
        int code;
        if (type instanceof String) {
            code = Integer.parseInt(type.toString());
        } else if (type instanceof Integer) {
            code = (Integer) type;
        } else {
            return null;
        }
        for (ContentDataStatusEnum typeEnum : ContentDataStatusEnum.values()) {
            if (code == typeEnum.getCode()) {
                return typeEnum;
            }
        }
        return null;
    }
}
