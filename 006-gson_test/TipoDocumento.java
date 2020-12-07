import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 * Script simple que recibe un archivo json con la cedula de una persona
 * y se imprime si la cédula es válida o no, se importa la validación de cédula de Ecuador
 *
 */

public class TipoDocumento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader jsoncontact;
		
		try {
			jsoncontact = new FileReader("/Users/acsmac01/Desktop/contactos.json");
			JsonArray jsonArr = new Gson().fromJson(jsoncontact, JsonElement.class).getAsJsonArray();
						
			for (int i = 0; i < jsonArr.size(); i++) {
				JsonObject jsonObj = jsonArr.get(i).getAsJsonObject();
				
				if(jsonObj.get("cottipodocumento").getAsInt() == 3) {
					DniEcuador dni = new DniEcuador( jsonObj.get("cedula").getAsString() );
					
					if(!dni.validation().contains("CORRECTO")) {
						System.out.println( jsonObj.get("oid").getAsInt() + "," );
					}
				}				
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
