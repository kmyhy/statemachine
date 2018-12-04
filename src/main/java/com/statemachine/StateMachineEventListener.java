//package com.statemachine;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.statemachine.StateMachine;
//import org.springframework.statemachine.listener.StateMachineListenerAdapter;
//import org.springframework.statemachine.transition.Transition;
//
//import java.util.Scanner;
//
//public class StateMachineEventListener extends StateMachineListenerAdapter<States, Events> {
//    private StateMachine<States,Events> stateMachine;
//    private LeaveRequest request;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    StateMachineEventListener(StateMachine<States,Events> stateMachine,LeaveRequest request){
//        this.stateMachine = stateMachine;
//        this.request = request;
//    }
////    @Override
////    public void stateMachineStarted(StateMachine<States, Events> stateMachine) {
////
////        Message message = MessageBuilder
////                .withPayload(Events.SUBMIT)
////                .setHeader("request", request).build();
////
////        stateMachine.sendEvent(message);
////    }
//    @Override
//    public void transitionEnded(Transition<States, Events> transition) {
//
//        Scanner scanner = new Scanner(System.in);
//        String input;
//        if(transition.getTarget().getId() == States.WAITING_FOR_SUBMIT){// 状态机开始或者 WAITING_FOR_TL_APPROVE 驳回
//            logger.info("{}提交了一个请假申请：",request.applicant);
//            request.print();
//            logger.info("是否提交？（按 y 提交)");
//            scanner.next();
//            stateMachine.sendEvent(Events.SUBMIT);
//            return;
//        }
//
//        if(transition.getTrigger().getEvent() == Events.SUBMIT ||
//                transition.getTrigger().getEvent() == Events.DM_REJECT) {// 提交申请/TL驳回
//
//            logger.info("{}申请{}请假{}天，WAITING_FOR_TL_APPROVE 是否同意(y/n):",request.applicant,request.date,request.days);
//
//            input = scanner.nextLine();
//
//            if(input.toLowerCase().equals("y")){
//                request.tlAgree = true;
//                Message message = MessageBuilder
//                        .withPayload(Events.TL_AGREE)
//                        .setHeader("request",request).build();
//                stateMachine.sendEvent(message);
//            }else{
//                request.tlAgree = false;
//                Message message = MessageBuilder
//                        .withPayload(Events.TL_REJECT)
//                        .setHeader("request",request).build();
//                stateMachine.sendEvent(message);
//            }
//
//            return;
//        }
//        if(transition.getTrigger().getEvent() == Events.TL_AGREE){// 部门经理审批
//            logger.info("{}申请{}请假{}天，部门经理是否同意(y/n):",request.applicant,request.date,request.days);
//
//            input = scanner.nextLine();
//
//            if(input.toLowerCase().equals("y")){
//                request.dmAgree = true;
//                Message message = MessageBuilder
//                        .withPayload(Events.DM_AGREE)
//                        .setHeader("request",request).build();
//                stateMachine.sendEvent(message);
//            }else{
//                request.dmAgree = false;
//                Message message = MessageBuilder
//                        .withPayload(Events.DM_REJECT)
//                        .setHeader("request",request).build();
//                stateMachine.sendEvent(message);
//            }
//
//            return;
//        }
//        if(transition.getTrigger().getEvent() == Events.DM_AGREE) {
//            logger.info("部门经理已同意，WAITING_FOR_HR_RECORD 请备案(按 y 备案)：");
//
//            scanner.next();
//
//            request.hrAgree = true;
//            stateMachine.sendEvent(Events.HR_RECORD);
//            logger.info("WAITING_FOR_HR_RECORD 已备案，流程结束");
//            request.print();
//            return;
//        }
//    }
//}
