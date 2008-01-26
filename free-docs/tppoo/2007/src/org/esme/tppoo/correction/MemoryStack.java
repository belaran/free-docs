package org.esme.tppoo.correction;

import java.util.HashMap;
import java.util.logging.Logger;

public class MemoryStack extends HashMap implements MessagesStack {

	// On créer un logger pour cette classe
	Logger logger = Logger.getLogger(this.getClass().getName());

	public MemoryStack(int default_size) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key,Object m) {
		logger.info("Adding this message" + m.toString());
		Object obj = super.put(key, m);
		if ( obj != null ) {
			logger.info("Message added.");
		}
		else
			logger.info("Message wasn't added.");
		return obj;
	}

	@Override
	public Object get(Object key) {
		logger.info("Retrivieng message with id:" + key);
		Object m = super.get(key);
		if ( m != null ) {
			logger.info("Message retrieved:" + m.toString());
		}
		else
			logger.info("Message is not in the stack");
		return m;
	}

	/**
	 * "Taggue" le message associant à l'identifiant fourni
	 * comme "lu"
	 * @param mssgId
	 */
	public void checkout(String mssgId) {
		// FIXME: un usage habile des 'generics' en Java5
		// permettrait de supprimer ce 'cast'.
		MetaMessage m = (MetaMessage) super.get(mssgId);
		if (m != null ) m.setRead(true);
	}



	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}
