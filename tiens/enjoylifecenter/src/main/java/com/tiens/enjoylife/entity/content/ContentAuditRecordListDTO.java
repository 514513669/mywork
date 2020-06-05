package com.tiens.enjoylife.entity.content;

import com.tiens.enjoylife.enums.AuditStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 内容审核记录列表
 *
 * @author baikq
 * @date 2020-06-04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentAuditRecordListDTO {
    /**
     * 审核记录id
     */
    private Long id;

    /**
     * 审核状态描述
     */
    private String statusDesc;

    /**
     * 审核状态
     */
    private Integer status;

    /**
     * 审核备注
     */
    private String remark;

    /**
     * 操作人
     */
    private String creator;

    /**
     * 操作时间
     */
    private Date createTime;


    public String getStatusDesc() {
        return AuditStatusEnum.getDescByCode(status);
    }

    public void setStatusDesc(String statusDesc) {
        statusDesc = AuditStatusEnum.getDescByCode(status);
        this.statusDesc = statusDesc;
    }

}
