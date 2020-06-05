package com.tiens.enjoylife.entity.content;

import com.tiens.enjoylife.enums.ContentDataStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 内容列表显示对象
 *
 * @author baikq@tiens.com
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDataListDTO implements Serializable {


    /**
     * 内容编号
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 内容分类id：
     */
    private Integer contentCategoryId;

    /**
     * 内容分类
     */
    private String contentCategoryDesc;

    /**
     * 内容类型iD：1.音频内容 2.图文内容
     */
    private Integer contentTypeId;

    /**
     * 内容类型描述
     */
    private Integer contentTypeDesc;


    /**
     * 记录状态：1.新建（草稿）2.待审核 3.审批不通过（驳回）
     * 4.审核通过 5.未开始展示 6.展示中 7.上架  8.下架  9.已删除
     */
    private Integer status;

    /***
     * 状态描述
     */
    private String statusDesc;


    /**
     * 音频数量
     */
    private Integer trackCount;


    /**
     * 点击次数
     */
    private Long clickCount;

    public String getStatusDesc() {
        return ContentDataStatusEnum.getDescByCode(status);
    }

    public void setStatusDesc(String statusDesc) {
        statusDesc = ContentDataStatusEnum.getDescByCode(status);
        this.statusDesc = statusDesc;
    }

}
