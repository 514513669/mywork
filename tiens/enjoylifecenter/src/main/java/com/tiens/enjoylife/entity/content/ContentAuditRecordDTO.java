package com.tiens.enjoylife.entity.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 内容审核记录保存入参
 *
 * @author baikq
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentAuditRecordDTO {


    /**
     * 内容id
     */
    private Long contentId;
    /**
     * 审核状态 2.待审核 3.审批不通过（驳回）4.审批通过
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;
}
