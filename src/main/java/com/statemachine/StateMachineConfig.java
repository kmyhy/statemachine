package com.statemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import java.util.EnumSet;


@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LeaveStateMachinePersist leaveStateMachinePersist;

    @Bean
    public StateMachinePersister<States,Events,String> stateMachinePersist(){
        return new DefaultStateMachinePersister<>(leaveStateMachinePersist);
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states)
            throws Exception {
        states
            .withStates()
                .initial(States.WAITING_FOR_SUBMIT)
                .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(States.WAITING_FOR_SUBMIT).target(States.WAITING_FOR_TL_APPROVE)
                .event(Events.SUBMIT)
                .and()
            .withExternal()
                .source(States.WAITING_FOR_TL_APPROVE).target(States.WAITING_FOR_DM_APPROVE)
                .event(Events.TL_AGREE)
                .and()
            .withExternal()
                .source(States.WAITING_FOR_TL_APPROVE).target(States.WAITING_FOR_SUBMIT)
                .event(Events.TL_REJECT)
                .and()
            .withExternal()
                .source(States.WAITING_FOR_DM_APPROVE).target(States.WAITING_FOR_HR_RECORD)
                .event(Events.DM_AGREE)
                .and()
            .withExternal()
                .source(States.WAITING_FOR_DM_APPROVE).target(States.WAITING_FOR_SUBMIT)
                .event(Events.DM_REJECT)
                .and()
            .withExternal()
                .source(States.WAITING_FOR_HR_RECORD).target(States.END)
                .event(Events.HR_RECORD);
    }

//    @Override
//    public void configure(StateMachineConfigurationConfigurer<States, Events> config)
//            throws Exception {
//        config
//                .withConfiguration()
//                .listener(new StateMachineEventListener());
//    }


    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration().machineId("请假流程");
    }

}
