package hcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class QDispersal implements Runnable {
	HazelcastInstance hz=null;
	String name=null;
	
	public QDispersal(HazelcastInstance hz, String name) {
		this.hz=hz;
		this.name=name;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		IQueue<Student> q = hz.getQueue("LINE_TO_GAMES");
		while(!q.isEmpty()){
			try {
				System.out.println(q.take() + " is leaving in house " + name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
