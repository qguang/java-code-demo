package data_structure;

import java.util.*;
public class HashSetDemo {

   public static void main(String args[]) {
      // create a hash set
      HashSet hs = new HashSet();
      
      // add elements to the hash set
      hs.add("B");
      hs.add("A");
      hs.add("D");
      hs.add("E");
      hs.add("C");
      hs.add("F");
      // try to add duplicated element, but hashset rejects it without error
      hs.add("F");
      
      System.out.println("the size of the hash set is : " + hs.size());
      System.out.println(hs);
      
      if (hs.contains("F")) {
    	  System.out.println("we already have \"F\" element ");  
      }
      
      if (! hs.contains("Guang")) {
    	  System.out.println("we don't have \"Guang\" element, let me try to add it");
    	  hs.add("Guang");
          System.out.println(hs);
      }
   }
}