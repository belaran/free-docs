package org.esme.samples;
import java.util.ArrayList;
import java.util.List;

public class InterfaceUsage {
  public static void main(String[] args) {
    List<Checksumable> items;
    items = new ArrayList<Checksumable>(2);
    items.add(new MyFile());
    		// MyFile extends File
            // and implements Checksumable
    items.add(new User());
    		// User also implements Checksumable
    for ( Checksumable item : items ) {
      System.out.println(item.checksum());
    }
  }
}
