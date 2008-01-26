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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.esme.tppoo.Message;
import org.esme.tppoo.MessageEngine;
import org.esme.tppoo.MessageException;
import org.junit.Before;
import org.junit.Test;




/**
 * @author Romain PELISSE, pelisse@esme.fr
 *
 */
public class BasicUseCase
{
	private static final String RECIPIENT = "Recipient";
	private static final String NON_EXISTENT_MAILBOX = "no-such-mailboxes";
	private MessageEngine stack;
	private String implementationName = "org.esme.tppoo.DummyStack";

	private StackParameter params;
	private Message message;
	@Before
	public void buildStack() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		stack = (MessageEngine) this.getClass().getClassLoader().loadClass(implementationName).newInstance();
		// default test stack params
		this.params = new StackParameter(10, 2, 5, false);
		// default test message
		this.message = new Message("Message id",null,RECIPIENT);
	}

	private void parametizeStack(StackParameter params,MessageEngine stack) {
		stack.initializeEngine(params.getMaxMessages(),
								params.getMaxMailBoxes(),
								params.getMaxMessgesPerMailBoxes(),
								params.isPersitence());
	}

	/*
	 * Commodity method to build and test proper configuration...
	 */
	private void configureEngine() {
		try {
			this.parametizeStack(params, this.stack);
		}
		catch ( IllegalArgumentException e)
		{
			fail("Stack Initialization failed with those parameters:" + params.toString());
		}
	}

	@Test
	public void basicUseCase() throws IllegalArgumentException,MessageException {

		this.configureEngine();
		// Now we have a proper setted engine, let's test if
		try {
			this.stack.postMessage(message);
		} catch (IllegalArgumentException e) {
			fail("Stack failed to postMessage" + message.toString() + "\nError is " + e.getMessage());
		} catch (MessageException e) {
			fail("Stack failed to postMessage" + message.toString() + "\nError is " + e.getMessage());
		}
		// Now we check that the message IS NOT arrived
		assertFalse(this.stack.isRecevied(message));
		// ... then, we check it out
		List<Message> messages = this.stack.checkMessages(RECIPIENT);
		assertEquals(messages.size(),1);
		for ( Message incoming : messages) {
			assertEquals(incoming,message);
		}
		// ... now the mailbox is empty, checking this out
		messages = this.stack.checkMessages(RECIPIENT);
		assertNotNull(messages);
		assertEquals(messages.size(),0);
		// .... now the message has been recevied, checking this out
		assertTrue(this.stack.isRecevied(message));
	}

	@Test
	public void tooManyMessages() {
		this.configureEngine();
		List<Message> messagesToSent = new ArrayList<Message>(this.params.getMaxMessages() * 2);
		for ( int nbMessage = 0; nbMessage < this.params.getMaxMessages() * 2; nbMessage++ )
		{
			messagesToSent.add(new Message("id" + nbMessage, null,RECIPIENT));
		}
		assertEquals(messagesToSent.size(),this.params.getMaxMessages() * 2);
		try {
			for ( Message m : messagesToSent )
				this.stack.postMessage(m);
		}
		catch ( MessageException e) {
			return ; // ok
		}
		fail("Stack shouldn't be able to handle " + this.params.getMaxMessages() * 2 + " messages, with those parameters :" + this.params.toString());
	}

	@Test
	public void tooManyMB() {
		this.configureEngine();
		try {
			for ( int nbRecipient = 0; nbRecipient < this.params.getMaxMailBoxes() * 2; nbRecipient++ )
			{
				// This should create a mailbox
				this.stack.checkMessages("mailbox" + nbRecipient);
			}
		}
		catch ( MessageException e ) {
			return ; //ok
		}
		fail("Stack shouldn't be able to handle " + this.params.getMaxMailBoxes() * 2 + " mailboxes with those parameters: " + this.params.toString());
	}

	@Test
	public void tooManyMessagesForOneUser() {
		// TODO
	}

	@Test
	public void greatPayLoad() throws IllegalArgumentException, MessageException {
		final int MAX_MESSAGE = 10000;
		final int MAX_PER_MB = 200;
		final int MAX_MB = 50;
		this.params = new StackParameter(MAX_MESSAGE ,MAX_MB,MAX_PER_MB,false);
		this.configureEngine();
		List<Message> messagesToSent = new ArrayList<Message>(MAX_MESSAGE);

		int ratio = MAX_MESSAGE / MAX_PER_MB;
		for ( int nbRecipient = 0 ; nbRecipient < ratio ; nbRecipient++ ) {
			for ( int nbMessage = 0; nbMessage < MAX_PER_MB; nbMessage++ )
			{
				messagesToSent.add(new Message("id" + nbMessage, null,RECIPIENT + nbRecipient));
			}
			assertEquals(messagesToSent.size(),MAX_MESSAGE);
			for ( Message m : messagesToSent )
			{
				this.stack.postMessage(m);
			}
		}


	}

	@Test
	public void callToIsReceviedCallWithNull() {
		try {
			this.stack.isRecevied(null);
		}
		catch ( IllegalArgumentException e ) {
			return ; // this is ok
		}
		fail("Call to isRecevied method should fail is argument is 'null' ");
	}

	@Test
	public void invalidIsReceviedCall() {
		try {
			this.message = new Message(null,null,null);
			this.stack.isRecevied(message);
		}
		catch ( IllegalArgumentException e ) {
			return ; // this is ok
		}
		fail("Call to isRecevied method should fail is message id is 'null' ");
	}

	@Test
	public void invalidStackParameters() {
		this.params = new StackParameter(-1,-1,-1,false);
		try {
			this.parametizeStack(this.params, this.stack);
		}
		catch ( IllegalArgumentException e)
		{
			return; // this is ok
		}
		fail("Stack initialization should failed with parameters such as " + this.params.toString());
	}


	@Test
	public void nullCheckMailBoxes() throws MessageException {
		this.configureEngine();
		try {
			this.stack.checkMessages(null);
		}
		catch ( IllegalArgumentException e ) {
			return ; // this is ok
		}
		fail("Call to checkMessage with null arg shall throw an IllegalArgumentException.");
	}


	@Test
	public void nonExistentMailboxChecked() throws IllegalArgumentException, MessageException {
		this.params = new StackParameter();
		this.configureEngine();
		this.stack.checkMessages(NON_EXISTENT_MAILBOX);
	}

	@Test
	public void nonInitializedStack() {
		// Can't post if stack not initialized !!!
		try {
			this.stack.postMessage(message);
		} catch (IllegalArgumentException e) {
			fail("Waiting a MessageException, got an IllegalArgumentException.");
		} catch (MessageException e) {
			return; // test OK !
		}
		fail("Waiting a MessageException, not exception thrown.");
	}

}
