package makesense.ara.workflow.tests;

import java.util.Vector;

import makesense.ara.workflow.Task;

public class Letter extends Task {

	public void execute(Vector<Object> input) {
		
		System.out.println("A");
	}
	
	public Vector<Object> getOutput() {
		
		return null;
		
	}
}
