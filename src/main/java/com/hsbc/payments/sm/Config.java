package com.hsbc.payments.sm;

import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

public class Config extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
        states
            .withStates()
                .initial(PaymentStates.INITIAL.name())
                .state(PaymentStates.ACCEPT.name())
                .state(PaymentStates.VALIDATE.name())
                .state(PaymentStates.REPAIRABLE.name())
                .state(PaymentStates.ERROR.name())
                .state(PaymentStates.FINALIZE.name());
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
        transitions
            .withExternal()
                .source(PaymentStates.INITIAL.name())
                .target(PaymentStates.ACCEPT.name())
                .event(PaymentProcessEvents.START.name());
        transitions
        .withExternal()
            .source(PaymentStates.ACCEPT.name())
            .target(PaymentStates.VALIDATE.name())
            .event(PaymentProcessEvents.ACCEPTED.name());
        transitions
        .withExternal()
            .source(PaymentStates.VALIDATE.name())
            .target(PaymentStates.REPAIRABLE.name())
            .event(PaymentProcessEvents.REPAIRABLE_ERRORED.name());
        transitions
        .withExternal()
            .source(PaymentStates.VALIDATE.name())
            .target(PaymentStates.FINALIZE.name())
            .event(PaymentProcessEvents.VALIDATED.name());

        
    }
}
