package com.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.transition.Transition;

public class StateMachineEventListener1 extends StateMachineListenerAdapter<States, Events> {
    @Autowired
    private StateMachine<States, Events> stateMachine;
//    @Override
//    public void stateMachineStarted(StateMachine<States, Events> stateMachine) {
//
//        Message message = MessageBuilder
//                .withPayload(Events.SUBMIT)
//                .setHeader("request", request).build();
//
//        stateMachine.sendEvent(message);
//    }
    @Override
    public void transitionEnded(Transition<States, Events> transition) {

    }
    @Override
    public void transition(Transition<States,Events> transition){

    }

}
