/*
 * This file is part of Ara toolkit.

    Ara is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Ara is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Ara.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * The Workflow class simulates a UML activity diagram to represent which
 * operations have to be done on a stream
 * Note: some concepts from UML Activity diagram are absent since useless
 * here
 */
package makesense.ara.workflow;

import java.util.Vector;

public class Workflow extends Thread {

	// the initial node in the workflow, it should be of type InitialNode
	private Node initial;

	//the current output for tasks
	private Vector<Object> output = null;
	
	public Workflow(Node initial) {

		this.initial = initial;
		output = new Vector<Object>();

	} // constructor

	/**
	 * executes the workflow
	 */
	public void run() {

		Node current = initial;

		while (!(current instanceof FinalNode)) {

			if (current instanceof ControlNode) {

				if (current instanceof DecisionNode) {
					
				} //if
				
				else if (current instanceof ForkNode) {
					
					//retrieve the list of outgoing edges for this fork node
					Vector<Edge> edges = ((ForkNode)current).getEdges();
					
					//for every edge, create a new Workflow and run it as a Thread
					for (Edge edge : edges) {
						
						Node nextNode = edge.getEndNode();
						
						//we are obliged to create an initial node 
						InitialNode initialNode = new InitialNode();
						
						//and an edge from this initial node to the next node
						Edge fromInitial = new Edge(nextNode);
						initialNode.setEdge(fromInitial);
						
						//then we create the workflow
						Workflow wfw = new Workflow(initialNode);
						
						//and execute it
						wfw.start();						
						
					} //for
					
					//we need to stop the current workflow to only consider
					//new workflows coming from the fork
					current = new FinalNode();
					
					
				} //if
				
				else if (current instanceof JoinNode) {
					
				} //if
				
				else if (current instanceof LoopNode) {
					
				} //if
				
				//MergeNode condition is deleted since there is nothing special to do
				//for this node
				
			} // if

			else if (current instanceof Task) {

				//execute the task
				((Task)current).execute(output);
				
				//retrieve output for next tasks
				output = ((Task)current).getOutput();
				
			} // else

			if (current instanceof Task || 
				current instanceof InitialNode ||
				current instanceof MergeNode) {
				
				Edge edge = current.getEdge();
				current = edge.getEndNode();
				
			} //if

		} // while

	} // run()

} // Workflow class
