package com.tiens.enjoylife.entity.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 内容音频记录列表
 *
 * @author baikq
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentTrackListDTO {
    /**
     * 音频id
     */
    private Long trackId;

    /**
     * 声音标题(声音名称)
     */
    private String trackTitle;

    /**
     * 声音时长，单位秒
     */
    private Integer duration;


}
