package com.statemachine;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LeaveStateMachinePersist implements StateMachinePersist<States,Events,String> {

    // 用 map 来模拟持久化存储，可替换成数据库
    static Map<String, States> cache = new HashMap<>(16);


    @Override
    public void write(StateMachineContext<States, Events> stateMachineContext, String s) {
        cache.put(s, stateMachineContext.getState());
    }

    @Override
    public StateMachineContext<States, Events> read(String s) {
        return cache.containsKey(s) ?
                new DefaultStateMachineContext<>(cache.get(s),null,null,null,null,"请假流程") :
                new DefaultStateMachineContext<>(States.WAITING_FOR_SUBMIT,null,null,null,null,"请假流程");

    }
}
