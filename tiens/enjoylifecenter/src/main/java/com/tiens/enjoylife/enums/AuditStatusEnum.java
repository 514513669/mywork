package com.tiens.enjoylife.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核状态
 *
 * @author baikq
 */
@Getter
public enum AuditStatusEnum {

    /**
     * 审批不通过（驳回）
     */
    REJECT(3, "审批不通过（驳回）"),
    /**
     * 审批通过
     */
    PASS(4, "审批通过");
    private final int code;
    private final String desc;

    private AuditStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(int code) {
        for (AuditStatusEnum temp : AuditStatusEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getDesc();
            }
        }
        return null;
    }

    private static final Map<Integer, AuditStatusEnum> CODES = new HashMap<>();

    static {
        for (AuditStatusEnum v : AuditStatusEnum.values()) {
            CODES.put(v.getCode(), v);
        }
    }


    public static AuditStatusEnum getAuditStatusEnum(Object type) {
        int code;
        if (type instanceof String) {
            code = Integer.parseInt(type.toString());
        } else if (type instanceof Integer) {
            code = (Integer) type;
        } else {
            return null;
        }
        for (AuditStatusEnum typeEnum : AuditStatusEnum.values()) {
            if (code == typeEnum.getCode()) {
                return typeEnum;
            }
        }
        return null;
    }
}
