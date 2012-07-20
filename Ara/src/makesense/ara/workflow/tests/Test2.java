package makesense.ara.workflow.tests;

import makesense.ara.workflow.Edge;
import makesense.ara.workflow.FinalNode;
import makesense.ara.workflow.ForkNode;
import makesense.ara.workflow.InitialNode;
import makesense.ara.workflow.MergeNode;
import makesense.ara.workflow.Workflow;

public class Test2 {

	public Test2() {
		InitialNode node = new InitialNode();
		HelloWorldTask t = new HelloWorldTask();
		Edge edge = new Edge(t);
		node.setEdge(edge);
		
		ForkNode fork = new ForkNode();
		edge = new Edge(fork);
		t.setEdge(edge);
		
		Number n = new Number();
		Letter l = new Letter();
		Edge toNumber = new Edge(n);
		Edge toLetter = new Edge(l);
		
		fork.addEdge(toNumber);
		fork.addEdge(toLetter);
		
		MergeNode merge = new MergeNode();
		edge = new Edge(merge);
		n.setEdge(edge);
		l.setEdge(edge);
		
		GoodbyeTask gb = new GoodbyeTask();
		edge = new Edge(gb);
		
		merge.setEdge(edge);
		
		FinalNode end = new FinalNode();
		edge = new Edge(end);

		gb.setEdge(edge);
		
		Workflow wfw = new Workflow(node);
		wfw.start();
		
		
	}
	public static void main(String[] args) {
		new Test2();
	}
}
