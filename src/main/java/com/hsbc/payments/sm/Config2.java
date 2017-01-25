package com.hsbc.payments.sm;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;

@Configuration
@EnableStateMachine(name = "machine2")
public class Config2 extends Config {

}
