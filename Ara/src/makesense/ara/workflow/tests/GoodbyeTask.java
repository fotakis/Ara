package makesense.ara.workflow.tests;

import java.util.Vector;

import makesense.ara.workflow.Task;

public class GoodbyeTask extends Task {

	public void execute(Vector<Object> input) {
		
		System.out.println("Good bye!");
		
	}
	
	public Vector<Object> getOutput() {
		
		return null;
		
	}
}
