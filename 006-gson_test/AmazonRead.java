import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 * Lectura de un archivo data.json, pasarlo a json y trabajar obteniendo la
 * información Esta tomado desde un formato json de los rebotes de Amazon SES
 *
 */

public class AmazonRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader jsonAmazon;
		String diagnosticCode = "";

		try {
			jsonAmazon = new FileReader("/Users/luispazymino/Desktop/data.json");
			JsonArray jsonArr = new Gson().fromJson(jsonAmazon, JsonElement.class).getAsJsonArray();

			System.out.println("TIPO REBOTE!CONDOMINIO!ENVIADO A!MOTIVO REBOTE");

			for (int i = 0; i < jsonArr.size(); i++) {
				JsonObject jsonObj = jsonArr.get(i).getAsJsonObject();

				try {
					diagnosticCode = jsonObj.get("bounce").getAsJsonObject().get("bouncedRecipients").getAsJsonArray()
							.get(0).getAsJsonObject().get("diagnosticCode").getAsString();
				} catch (Exception e) {
					diagnosticCode = "###Sin detalle";
				}

				System.out.println(jsonObj.get("bounce").getAsJsonObject().get("bounceType").getAsString() + "!"
						+ jsonObj.get("mail").getAsJsonObject().get("headers").getAsJsonArray().get(2).getAsJsonObject()
								.get("value").getAsString()
						+ "!"
						+ jsonObj.get("bounce").getAsJsonObject().get("bouncedRecipients").getAsJsonArray().get(0)
								.getAsJsonObject().get("emailAddress").getAsString()
						+ "!" + diagnosticCode.replaceAll("\n", " ").replaceAll("\r", ""));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
