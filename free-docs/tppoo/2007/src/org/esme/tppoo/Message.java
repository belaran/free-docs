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

/**
 *
 * @author Romain PELISSE, pelisse@esme.fr
 *
 */
public class Message {
	private String id;			// The message id has decided by caller, therefore it may not be unique !
	private String recipient;	// The recipient name ( ie his mailbox)
	private Object content;		// Any object can be 'attached' to the message

	public Message(String id, Object content, String recipient)	{
		this.id = id;
		this.content = content;
		this.recipient = recipient;
	}

	public String toString() {
		return "[Id:" + this.id +
				",Content:" + this.content +
				",Recipient:" + this.recipient +
				"]";
	}

	/*
	 * Appropriate getter/setters
	 */


	/**
	 * @return the content
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(Object content) {
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return recipient;
	}

	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
