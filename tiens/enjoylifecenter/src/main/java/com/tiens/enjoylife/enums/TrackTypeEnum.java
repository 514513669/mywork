package com.tiens.enjoylife.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 音频类型
 *
 * @author baikq
 */
@Getter
public enum TrackTypeEnum {

    /**
     * 专辑
     */
    ALBUMS(1, "专辑"),

    /**
     * 听单
     */
    COLUMN(2, "听单");

    private final int code;
    private final String desc;

    TrackTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescByCode(int code) {
        for (TrackTypeEnum temp : TrackTypeEnum.values()) {
            if (temp.getCode() == code) {
                return temp.getDesc();
            }
        }
        return null;
    }

    private static final Map<Integer, TrackTypeEnum> CODES = new HashMap<>();

    static {
        for (TrackTypeEnum v : TrackTypeEnum.values()) {
            CODES.put(v.getCode(), v);
        }
    }


    public static TrackTypeEnum getAuditStatusEnum(Object type) {
        int code;
        if (type instanceof String) {
            code = Integer.parseInt(type.toString());
        } else if (type instanceof Integer) {
            code = (Integer) type;
        } else {
            return null;
        }
        for (TrackTypeEnum typeEnum : TrackTypeEnum.values()) {
            if (code == typeEnum.getCode()) {
                return typeEnum;
            }
        }
        return null;
    }

}
