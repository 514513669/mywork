package com.tiens.enjoylife.entity.content;

import com.tiens.enjoylife.enums.ContentDataStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 内容详情
 *
 * @author baikq@tiens.com
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDataDetailDTO implements Serializable {

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
     * 图片链接
     */
    private String imageUrl;


    /**
     * 简介
     */
    private String shortIntro;

    /**
     * 详情
     */
    private String richIntro;

    /**
     * 记录状态：1.新建（草稿）  2.待审核 3.审批不通过（驳回） 4.未开始展示 5.展示中 6.下架 7.已删除
     */
    private Integer status;

    /**
     * 记录状态描述
     */
    private String statusDesc;

    /**
     * 版权声明
     */
    private String copyright;

    /**
     * 内容音频记录集合
     */
    private List<ContentTrackListDTO> tracks;

    /**
     * 声音类型：1.专辑 2.听单
     */
    private Integer trackType;

    /**
     * 如果内容类型为音频内容并且声音类型为专辑，专辑id不为空
     */
    private Long albumsId;
    /**
     * 如果内容类型为音频内容并且声音类型为专辑，听单id不为空
     */
    private Long columnId;

    /**
     * 内容审核记录集合
     */
    private List<ContentAuditRecordListDTO> auditRecords;

    public String getStatusDesc() {
        return ContentDataStatusEnum.getDescByCode(status);
    }

    public void setStatusDesc(String statusDesc) {
        statusDesc = ContentDataStatusEnum.getDescByCode(status);
        this.statusDesc = statusDesc;
    }

}
