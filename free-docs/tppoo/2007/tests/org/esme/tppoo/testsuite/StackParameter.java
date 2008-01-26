/*
* ESME SUDRIA
* Copyright 2007, Esme SUDRIA and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.esme.tppoo.testsuite;

/**
 * @author Romain PELISSE, pelisse@esme.fr
 *
 */
public class StackParameter {

	private int maxMailBoxes;
	private int maxMessages;
	private int maxMessgesPerMailBoxes;
	private boolean persitence;


	/**
	 * Empty constructor, always handy.
	 */
	public StackParameter(){}

	/**
	 * Quick constructors, to build a complete instance, without calling setters.
	 *
	 * @param maxMessages
	 * @param maxMaiboxes
	 * @param maxMssgPerMB
	 * @param persit
	 */
	public StackParameter(int maxMessages, int maxMaiboxes, int maxMssgPerMB, boolean persit) {
		this.maxMessages = maxMessages;
		this.maxMailBoxes = maxMaiboxes;
		this.maxMessgesPerMailBoxes = maxMssgPerMB;
		this.persitence = persit;
	}

	public String toString() {
		return "[MaxMailBoxes:" + maxMailBoxes + ",MaxMessages:" + maxMessages + ",MaxMssgPerMailBoxes:"
				+ maxMessgesPerMailBoxes + "]";
	}
	/**
	 * @return the maxMailBoxes
	 */
	public int getMaxMailBoxes() {
		return maxMailBoxes;
	}
	/**
	 * @param maxMailBoxes the maxMailBoxes to set
	 */
	public void setMaxMailBoxes(int maxMailBoxes) {
		this.maxMailBoxes = maxMailBoxes;
	}
	/**
	 * @return the maxMessages
	 */
	public int getMaxMessages() {
		return maxMessages;
	}
	/**
	 * @param maxMessages the maxMessages to set
	 */
	public void setMaxMessages(int maxMessages) {
		this.maxMessages = maxMessages;
	}
	/**
	 * @return the maxMessgesPerMailBoxes
	 */
	public int getMaxMessgesPerMailBoxes() {
		return maxMessgesPerMailBoxes;
	}
	/**
	 * @param maxMessgesPerMailBoxes the maxMessgesPerMailBoxes to set
	 */
	public void setMaxMessgesPerMailBoxes(int maxMessgesPerMailBoxes) {
		this.maxMessgesPerMailBoxes = maxMessgesPerMailBoxes;
	}
	/**
	 * @return the persitence
	 */
	public boolean isPersitence() {
		return persitence;
	}
	/**
	 * @param persitence the persitence to set
	 */
	public void setPersitence(boolean persitence) {
		this.persitence = persitence;
	}
}
