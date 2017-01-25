package com.hsbc.payments.sm;

import java.util.HashMap;
import java.util.Map;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.support.DefaultStateMachineContext;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class InMemoryStateMachinePersist implements StateMachinePersist<String, String, String> {
	static HazelcastInstance hz = null;
	static Map<String, String> processSteps = null;
	private final HashMap<String, StateMachineContext<String, String>> contexts = new HashMap();

	static {
		hz = Hazelcast.newHazelcastInstance();

		// String processHeader = "hsbc" + ":" + "payments" + ":";

		processSteps = hz.getMap("processSteps");
		// processSteps.put(processHeader + "acceptance", processHeader +
		// "validate");
		// processSteps.put(processHeader + "validate", processHeader +
		// "finalize");
		// processSteps.put(processHeader + "finalize", processHeader + "end");

	}

	public void write(StateMachineContext<String, String> context, String contextObj) throws Exception {
		contexts.put(contextObj, context);
		processSteps.put(contextObj, context.getState());
//		processSteps.put("EVENT", context.getEvent());
	}

	public StateMachineContext<String, String> read(String contextObj) throws Exception {
		StateMachineContext<String, String> ctxP = contexts.get(contextObj);
		String curStep = processSteps.get(contextObj);
		System.out.println("Current step is " + curStep);
		DefaultStateMachineContext<String, String> ctx = new DefaultStateMachineContext<String, String>(curStep,
				null, null, null);
		return ctx;
	}
}