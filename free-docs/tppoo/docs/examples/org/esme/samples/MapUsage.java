package org.esme.samples;

import java.util.HashMap;
import java.util.Map;

public class MapUsage {
   public void usingMap() {
      Map<String,Object> map;
      map = new HashMap<String,Object>(3);
      map.put("key","value");
      System.out.println(map.get("value"));
   }
}
