package hcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ISet;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

import java.util.Map;

public class SimpleHcast {

	public static void main(String[] args) throws Exception {
		System.out.println("in main");

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		
		IQueue<Student> q = hz.getQueue("LINE_TO_GAMES");
		
		q.addItemListener(new ItemListener<Student>() {
			
			@Override
			public void itemRemoved(ItemEvent<Student> arg0) {
//				System.out.println(arg0.getItem().name + " left the queue");
				
			}
			
			@Override
			public void itemAdded(ItemEvent<Student> arg0) {
				System.out.println(arg0.getItem().name + " entered the queue");
				
			}
		}, true);
		
		q.add(new Student("Kavya"));
		q.add(new Student("Devanshi"));
		q.add(new Student("Akshaya"));
		q.add(new Student("Suhaani"));
		q.add(new Student("Akshata"));
		q.add(new Student("Aashaya"));
		q.add(new Student("Diya"));
		q.add(new Student("Sanjana"));
		q.add(new Student("Chetana"));
		q.add(new Student("Sheetal"));
		q.add(new Student("Sneha"));
		q.add(new Student("Anvi"));
		q.add(new Student("Akshada"));
		q.add(new Student("Akshata B"));
		q.add(new Student("Manasvita"));
		q.add(new Student("Srishti"));
		q.add(new Student("Manya"));
		//
		Thread.sleep(1000);
		System.out.println(">>>>>>>>>>>House wise dispersal Prepare!!!");
		QDispersal qdCauvery = new QDispersal(hz, "Cauvery");
		QDispersal qdGanga = new QDispersal(hz, "Ganga");
		QDispersal qdKrishna = new QDispersal(hz, "Krishna");
		QDispersal qdNarmada = new QDispersal(hz, "Narmada");
		//
		Thread t1=new Thread(qdCauvery);
		Thread t2=new Thread(qdGanga);
		Thread t3=new Thread(qdKrishna);
		Thread t4=new Thread(qdNarmada);

		System.out.println(">>>>>>>>>> House wise Disperse!!!");
		t1.start();t2.start();t3.start();t4.start();

	}
}
