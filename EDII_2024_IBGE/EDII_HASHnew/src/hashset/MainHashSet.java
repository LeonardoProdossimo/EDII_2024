package hashset;

import java.util.HashMap;
import java.util.HashSet;

public class MainHashSet {

	public static void main(String[] args) {
		HashSet<String> conjunto = new HashSet<String>();
		conjunto.add("laranja");
		conjunto.add("alface");
		conjunto.add("alface");
		System.out.println(conjunto);
		
		HashMap<String, Integer> conjunto2 = new HashMap<String, Integer>();
		conjunto2.put("ABC-8764", 8976);
		conjunto2.put("CBG-9987", 587222);
		System.out.println(conjunto2.get("ABC-8764"));
	}

}
