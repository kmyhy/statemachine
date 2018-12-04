package com.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class LeaveRequest {
    public String applicant;
    public String reason;
    public String date;
    public int days;
//    public boolean tlAgree;
//    public boolean dmAgree;
//    public boolean hrAgree;
    public String leaveId;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public LeaveRequest(){
        this.leaveId = UUID.randomUUID().toString();
    }

    public void print(){
        logger.info("====请假申请====");
        logger.info("申请人：{}",applicant);
        logger.info("事由：{}",reason);
        logger.info("开始时间：{}",date);
        logger.info("天数：{}",days);
//        logger.info("TL是否同意：{}",tlAgree);
//        logger.info("部门经理是否同意：{}",dmAgree);
//        logger.info("WAITING_FOR_HR_RECORD 是否备案：{}",hrAgree);
        logger.info("uuid:{}",leaveId);
        logger.info("======================");
    }
}
