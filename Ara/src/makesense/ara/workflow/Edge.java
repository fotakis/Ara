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

/**
 * The Edge class represents the relationship between two nodes, it 
 * allows to go through the workflow
 * @author mphuget
 * @since 1.0
 */
public class Edge {

	//second node
	private Node endNode;
	
	/**
	 * Set the endAssociation of the edge
	 * @param end the other end of the association
	 */
	public Edge(Node end) {
		
		endNode = end;
		
	} //constructor

	/**
	 * Return the other end of the association
	 * @return a Node
	 */
	public Node getEndNode() {
		
		return endNode;
		
	} //getEndNode
	
} //Edge class
