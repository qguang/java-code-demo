package data_structure;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> al = new ArrayList<String>();
		
		System.out.println("Initial Size of Al: " + al.size());
		
		al.add("C");
		al.add("A");
		al.add("E");
		al.add("B");
		al.add("D");
		al.add("F");
		al.add(1, "A2");
		al.add(1, "A1");
		
		System.out.println("Size of Al after additions: " + al.size());
		System.out.println("Contents of Al: " + al);
		
		al.remove("D");
		al.remove(2);
		System.out.println("Size of Al after additions: " + al.size());
		System.out.println("Contents of Al: " + al);
			
	}

}
