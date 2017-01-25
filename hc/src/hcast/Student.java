package hcast;

import java.io.Serializable;

public class Student implements Serializable {
	String gc=null, name=null;
	
	public Student(String name){
		this.name=name;
	}

	public String getGc() {
		return gc;
	}

	public void setGc(String gc) {
		this.gc = gc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.name;
	}
}
