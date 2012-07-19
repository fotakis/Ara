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
 * The Node class is used to gather all the control nodes and task classes
 * Its interest is in storing the edge going out this Node 
 * @author mphuget
 * @since 1.0
 */
public class Node {

	//contains the edge going out this node
	protected Edge edge;
	
	/**
	 * returns the edge for this node
	 * @return an Edge
	 */
	public Edge getEdge() {
		
		return edge;
		
	} //getEdge()

	/**
	 * sets the edge for this node
	 * @param edge an Edge
	 */
	public void setEdge(Edge edge) {
		
		this.edge = edge;
		
	} //setEdge()
	
} //Node class
