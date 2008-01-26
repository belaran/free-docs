package org.esme.samples;
import java.util.ArrayList;
import java.util.List;
public class ListUsage {
	public void usingList() {
		List<String> list;
		list = new ArrayList<String>(3);
		list.add("Hello");
		list.add(" ");
		list.add("World !");
		// Typed list allow to do this:
		for ( String str : list )
			System.out.print(str);
		System.out.println("");
		list.clear();
	}
}
