/**
 *
 */
package org.esme.samples;

import java.io.File;

/**
 * @author rpelisse
 *
 */
public class MyFile implements Checksumable {

	public MyFile(){}

	public MyFile(File parent, String child) {
	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see org.esme.samples.Checksumable#checksum()
	 */
	public int checksum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
