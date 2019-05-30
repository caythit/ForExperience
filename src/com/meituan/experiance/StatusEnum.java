package com.meituan.experiance;

/**
 * 实现描述：状态枚举
 *
 * @author liuweikai
 * @version v1.0.0
 * @see
 * @since 2019/5/30
 */
public enum StatusEnum {
    UNDO("UNDO", "未开始"),
    // 仅开始做，并未提交
    TRYING("TRYING", "尝试做"),
    // 提交过多次 但因一些特殊情况未通过 放弃作答
    WRONG_ANSWER("WRONG_ANSWER", "答案错误"),
    ACCEPTTED("ACCEPTTED", "被接受");

    private String status;
    private String statusDesc;

    StatusEnum(String status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
