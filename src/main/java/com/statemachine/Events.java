package com.statemachine;

public enum Events {
    SUBMIT,   // 提交申请
    TL_AGREE,     // WAITING_FOR_TL_APPROVE 审批
    TL_REJECT,       // WAITING_FOR_TL_APPROVE 驳回
    DM_AGREE,     // 部门经理审批
    DM_REJECT,      // 部门经理驳回
    HR_RECORD,      // WAITING_FOR_HR_RECORD 备案
}