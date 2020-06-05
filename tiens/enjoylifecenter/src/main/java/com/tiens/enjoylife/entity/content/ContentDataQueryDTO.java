package com.tiens.enjoylife.entity.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 内容多条件查询类
 *
 * @author baikq@tiens.com
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDataQueryDTO implements Serializable {


    /**
     * 内容编号
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间（开始时间）
     */
    private String releaseStartTime;

    /**
     * 发布时间（结束时间）
     */
    private String releaseEndTime;

    /**
     * 内容分类：
     */
    private Integer contentCategoryId;

    /**
     * 内容类型：1.音频内容 2.图文内容
     */
    private Integer contentTypeId;

    /**
     * 记录状态：1.新建（草稿）2.待审核 3.审核不通过（驳回）
     * 4.审核通过 5.未开始展示 6.展示中 7.上架  8.下架  9.已删除
     */
    private Integer status;


    /**
     * 创建日期（开始日期）
     */
    private String createdStartTime;

    /**
     * 创建日期（结束日期）
     */
    private String createdEndTime;

    /**
     * 分页参数（第几页）
     */
    private Integer pageNum = 0;

    /**
     * 分页参数（每页显示个数）
     */
    private Integer pageSize = 10;

}
