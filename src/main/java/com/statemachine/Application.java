//
//package com.statemachine;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.statemachine.StateMachine;
//
//import java.util.Scanner;
//
//@SpringBootApplication
//public class Application implements CommandLineRunner {
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
//	}
//
//	@Autowired
//	private StateMachine<States, Events> stateMachine;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//        Scanner scanner = new Scanner(System.in);
//
//        LeaveRequest req = createRequest();
//
//        StateMachineEventListener listener = new StateMachineEventListener(stateMachine,req);
//        stateMachine.addStateListener(listener);
//
//        stateMachine.start();
//
//        logger.info("程序结束");
//	}
//
//	// 创建一个请假申请
//	private LeaveRequest createRequest(){
//
//        LeaveRequest req = new LeaveRequest();
//
//        req.applicant = "员工1";
//        req.reason = "生病";
//        req.date = "2018年12月2日";
//        req.days = 1;
//
//        return req;
//    }
//
//}
//
//
