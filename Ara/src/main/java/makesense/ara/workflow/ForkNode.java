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
package makesense.ara.workflow;

import java.util.Vector;

/**
 * The ForkNode class corresponds to the fork node in UML Activity Diagram, that is
 * creating as many threads as there are outgoing edges from this node
 * @author mphuget
 * @since 1.0
 */
public class ForkNode extends ControlNode {
	
	//the outgoing edges from this fork node
	private Vector<Edge> edges = null;
	
	/**
	 * constructor
	 */
	public ForkNode() {
		
		edges = new Vector<Edge>();
		
	} //constructor

	/**
	 * add an edge to the list of outgoing edges for this fork node
	 * @param edge the edge to add
	 */
	public void addEdge(Edge edge) {
		
		edges.addElement(edge);
		
	} //addEdge()
	
	/**
	 * return the list of outgoing edges for this fork node
	 * @return the list of edges
	 */
	public Vector<Edge> getEdges() {
		
		return edges;
		
	} //getEdges()
	
} //ForkNode class
