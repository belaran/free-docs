/**
 *
 */
package org.esme.tppoo.correction;

import java.util.List;
import java.util.Map;

import org.esme.tppoo.Message;
import org.esme.tppoo.MessageEngine;
import org.esme.tppoo.MessageException;

/**
 * @author rpelisse
 *
 */
public class DefaultEngine implements MessageEngine {


	private MessagesStack messages;
	private MailboxesStack mailboxes;

	private int nbMaxClient;
	private int nbMaxMssg;
	private int nbMaxMessagePerClient;


	private static final int DEFAULT_SIZE = 10;

	public void initializeEngine(	int nbMaxMssg,
								 	int nbMaxClient,
								 	int nbMaxMessagePerClient,
								 	boolean perstistantStack)
		throws IllegalStateException {
		// On fixe les paramètres
		this.nbMaxClient = nbMaxClient;
		this.nbMaxMssg = nbMaxMssg;
		this.nbMaxMessagePerClient = nbMaxMessagePerClient;
		// ... contrôle d'intégrité...

		// Si la pile est persistance...
		if ( perstistantStack ) {
			// il suffit de changer l'implémentation !
			this.setMessages(new FileStackImpl(DEFAULT_SIZE));
		}
		else
			this.setMessages(new MemoryStack(DEFAULT_SIZE));


	}


	public MailboxesStack getMailboxes() {
		return mailboxes;
	}

	public void setMailboxes(MailboxesStack mailboxes) {
		this.mailboxes = mailboxes;
	}

	public MessagesStack getMessages() {
		return messages;
	}

	public void setMessages(MessagesStack messages) {
		this.messages = messages;
	}

	public DefaultEngine() {}

	// Programme client de la pile
	public static void main(String[] args) {
		DefaultEngine engine = new DefaultEngine();
		engine.setMailboxes(new MailboxesStackImpl());
		engine.setMessages(new MemoryStack());
	}

	/*

	public DefaultEngine() {
		messages = new MemoryStack();
		mailboxes = new MailboxesStackImpl();
	}*/

	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#checkMessages(java.lang.String)
	 */
	public List<Message> checkMessages(String mailboxId)
	throws IllegalArgumentException, MessageException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#initializeEngine(int, int, int, boolean)
	 */


	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#isRecevied(org.esme.tppoo.Message)
	 */
	public boolean isRecevied(Message sentMessage)
	throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#postMessage(org.esme.tppoo.Message)
	 */
	public void postMessage(Message message)
		throws MessageException,IllegalArgumentException {
		// ...

		// Stack is full ?
		if ( (this.messages.size() + 1) > this.nbMaxMssg ) {
			throw new MessageExceptionImpl("Too many messages in the stack");

		}

	}



}
