package makesense.ara.workflow.tests;

import java.util.Vector;

import makesense.ara.workflow.Task;

public class Number extends Task {

	public void execute(Vector<Object> input) {
		
		System.out.println("1");
	}
	
	public Vector<Object> getOutput() {
		
		return null;
		
	}
}
