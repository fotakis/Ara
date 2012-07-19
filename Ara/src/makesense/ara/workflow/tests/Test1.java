package makesense.ara.workflow.tests;

import makesense.ara.workflow.Edge;
import makesense.ara.workflow.FinalNode;
import makesense.ara.workflow.InitialNode;
import makesense.ara.workflow.Workflow;

public class Test1 {

	public Test1() {
		InitialNode node = new InitialNode();
		HelloWorldTask t = new HelloWorldTask();
		Edge edge = new Edge(t);
		node.setEdge(edge);
		GoodbyeTask t1 = new GoodbyeTask();
		edge = new Edge(t1);
		t.setEdge(edge);
		FinalNode end = new FinalNode();
		edge = new Edge(end);
		t1.setEdge(edge);
		
		Workflow wfw = new Workflow(node);
		wfw.start();
		
	}
	public static void main(String[] args) {
		new Test1();
	}
}
