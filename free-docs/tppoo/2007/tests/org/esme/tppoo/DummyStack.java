/**
 * 
 */
package org.esme.tppoo;

import java.util.List;

/**
 * @author rpelisse
 *
 */
public class DummyStack implements MessageEngine {

	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#checkMessages(java.lang.String)
	 */
	public List<Message> checkMessages(String mailboxId)
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.esme.tppoo.MessageEngine#initializeEngine(int, int, int, boolean)
	 */
	public void initializeEngine(int nbMaxMssg, int nbMaxClient,
			int nbMaxMessagePerClient, boolean pestistStack)
			throws IllegalStateException {
		// TODO Auto-generated method stub

	}

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
	public void postMessage(Message message) throws MessageException,
			IllegalArgumentException {
		// TODO Auto-generated method stub

	}

}
