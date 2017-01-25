package hcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;

import java.util.Map;

public class SimpleQueue {

	public static void main(String[] args) {
		System.out.println("in main");

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();

		String processHeader="hsbc"+":"+"payments"+":";

		Map<String, String> processSteps = hz.getMap("processSteps");
		processSteps.put(processHeader+"acceptance", processHeader+"validate");
		processSteps.put(processHeader+"validate", processHeader+"finalize");
		processSteps.put(processHeader+"finalize", processHeader+"end");


		System.out.println("next step after validate: " + processSteps.get(processHeader+"validate"));
	}
}
