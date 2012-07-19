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
					
				} //if
				
				else if (current instanceof JoinNode) {
					
				} //if
				
				else if (current instanceof LoopNode) {
					
				} //if
				
				else if (current instanceof MergeNode) {
					
				} //if
				
			} // if

			else if (current instanceof Task) {

				//execute the task
				((Task)current).execute(output);
				
				//retrieve output for next tasks
				output = ((Task)current).getOutput();
				
			} // else

			Edge edge = current.getEdge();
			current = edge.getEndNode();

		} // while

	} // run()

} // Workflow class
