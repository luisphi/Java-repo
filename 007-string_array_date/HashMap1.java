import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Pruebas usando HashMap de java
 *
 */
public class HashMap1 {
	@SuppressWarnings("rawtypes")
	public static void main(String args[]) {

		/* This is how to declare HashMap */
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		/* Adding elements to HashMap */
		hmap.put(12, "Chaitanya");
		hmap.put(2, "Rahul");
		hmap.put(7, "Singh");
		hmap.put(49, "Ajeet");
		hmap.put(3, "Anuj");
		
		System.out.println(hmap.get(2));
		System.out.println(hmap.values());

		/* Display content using Iterator */
		Set<?> set = hmap.entrySet();
		Iterator<?> iterator = set.iterator();
		while (iterator.hasNext()) {
			Map.Entry mentry = (Map.Entry) iterator.next();
			System.out.print("key is: " + mentry.getKey() + " & Value is: " + mentry.getValue());
		}

		/* Get values based on key */
		String var = hmap.get(2);
		System.out.println("Value at index 2 is: " + var);

		/* Remove values based on key */
		hmap.remove(3);
		System.out.println("Map key and values after removal:");
		Set<?> set2 = hmap.entrySet();
		Iterator<?> iterator2 = set2.iterator();
		while (iterator2.hasNext()) {
			Map.Entry mentry2 = (Map.Entry) iterator2.next();
			System.out.print("Key is: " + mentry2.getKey() + " & Value is: " + mentry2.getValue());
		}

	}
}
