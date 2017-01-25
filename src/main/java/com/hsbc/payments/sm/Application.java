package com.hsbc.payments.sm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;



@SpringBootApplication
public class Application implements CommandLineRunner {
//	@Autowired
//	private StateMachine<States, Events> stateMachine;
	@Autowired
	@Qualifier("machine1")
	StateMachine<String, String> stateMachine1;

	@Autowired
	@Qualifier("machine2")
	StateMachine<String, String> stateMachine2;
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	public void run(String... arg0) throws Exception {
		InMemoryStateMachinePersist stateMachinePersist = new InMemoryStateMachinePersist();
		StateMachinePersister<String, String, String> persister = new DefaultStateMachinePersister(stateMachinePersist);

		stateMachine1.start();

		stateMachine1.sendEvent(PaymentProcessEvents.START.name());
		stateMachine1.sendEvent(PaymentProcessEvents.ACCEPTED.name());

		persister.persist(stateMachine1, "myid");
		persister.restore(stateMachine2, "myid");
		System.out.println("Restored State: "+ stateMachine2.getState().getId());
		stateMachine2.sendEvent(PaymentProcessEvents.VALIDATED.name());
		System.out.println("State Progress: "+ stateMachine2.getState().getId());
	}

}