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
 * The Task class is an abstract to allow defining specific task
 * The execute() method is invoked when the workflow is about executing
 * this task
 * @author mphuget
 * @since 1.0
 */
public abstract class Task extends Node {

	public abstract void execute(Vector<Object> input);
	public abstract Vector<Object> getOutput();
	
} //Task class
