package com.hsbc.payments.sm;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;

@Configuration
@EnableStateMachine(name = "machine1")
public class Config1 extends Config {

}
