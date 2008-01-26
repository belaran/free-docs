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

package org.esme.tppoo;

import java.util.List;

/**
 * @author Romain PELISSE, pelisse@esme.fr
 *
 */
public interface MessageEngine
{
	/**
	 * Method to just after engine construction. It initializes the engine and defines most of its behavior.
	 *
	 * @param nbMaxMssg, defines the total size of the message stack. The engine will refuse any new postMessage as soon
	 * as this number is reached.
	 * @param nbMaxClient, defines how many 'mailboxes' can the engine have at the same time.
	 * @param nbMaxMessagePerClient
	 * @param pestistStack
	 * @throws IllegalStateException
	 */
	public void initializeEngine(int nbMaxMssg,int nbMaxClient, int nbMaxMessagePerClient, boolean pestistStack) throws IllegalStateException;

	/**
	 *	If a message is posted while the engine's stack is full, the engine will throw a MessageException.
	 * @param message
	 * @throws MessageException is thrown when, due to an internal error of the
	 * 			MessagEngine implementation, the message wasn't posted.
	 * 			A MessageException should be thrown if the stack has not been properly initialised using
	 * 			the initializeEngine method.
	 * @throws IllegalArgumentException such exceptions are thrown when the message provided is 'null' or 'invalid'.
	 */
	public void postMessage(Message message) throws MessageException,IllegalArgumentException;

	/**
	 *
	 * @param mailboxId
	 * @return A list of messages. If there is no messages, the list is empty (list.size() == 0 ).
	 * 			The method shouldn't return 'null'
 	 * @throws IllegalArgumentException is thrown if the mailboxId is invalid ( 'null').
	 * @throws MessageException is thrown when checking out the mailbox that does exist, and that the stack
	 * 			cannot create because there is already too many mailboxes.
	 */
	public List<Message> checkMessages(String mailboxId) throws IllegalArgumentException,MessageException;

	/**
	 *
	 * @param sentMessage
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean isRecevied(Message sentMessage) throws IllegalArgumentException;

}
