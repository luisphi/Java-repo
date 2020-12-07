import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/***
 * 
 * Uso simple para agregar un array de json usando GSON
 *
 */

public class UseJsonArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tipo[] = {"cuenta1","cuenta2","cuenta3"};
		Double valor[] = {45.0,5.67,67.90};
		Double saldo[] = {645.0,50.67,670.90};
		
		JsonArray result = new JsonArray();
		
		
		for (int i = 0; i < tipo.length; i++) {
			JsonObject obj1 = new JsonObject();
			obj1.addProperty("tipo", tipo[i]);
			obj1.addProperty("valor", valor[i]);
			obj1.addProperty("saldo", saldo[i]);
			
			result.add(obj1);
		}
		
		System.out.println(result);
	}

}
