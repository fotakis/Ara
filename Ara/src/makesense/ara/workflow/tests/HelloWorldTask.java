package makesense.ara.workflow.tests;

import java.util.Vector;

import makesense.ara.workflow.Task;

public class HelloWorldTask extends Task {

	public void execute(Vector<Object> input) {
		
		System.out.println("Hello World!");
		
	}
	
	public Vector<Object> getOutput() {
		
		return null;
		
	}
}
