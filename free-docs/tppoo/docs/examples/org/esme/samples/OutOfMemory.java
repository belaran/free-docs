/**
 *
 */
package org.esme.samples;

import java.util.ArrayList;
import java.util.List;

/**
 * FIXME: Stupid example ! Do a better one !
 * @author Romain PELISSE, pelisse@esme.Fr
 *
 */
public class OutOfMemory {
	public static final int MAX_OCCURENCES = 10000000;

	// Here we have allocated already MAX_OCCURENCES slots for String !
	private List<String> list = new ArrayList<String>(MAX_OCCURENCES);

	public void badIdea() {
		for ( int nbItem = 0 ; nbItem < MAX_OCCURENCES ; nbItem++ ) {
			// Here we adding a String of MAX_OCCURENCES length !
			list.add(new StringBuffer(MAX_OCCURENCES).toString());
		}
	}

	public static void main(String[] args) {
		System.out.println("Program begins...");
		// Here we're going to create a list of MAX_OCCURENCES size !
		OutOfMemory object = new OutOfMemory();
		System.out.println("...List is created,...");
		// Here we fill
		object.badIdea();
		System.out.println("...and filled with large Strings.");
	}
}
