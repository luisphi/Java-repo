import com.google.gson.JsonObject;
import java.util.Base64;

/**
 * 
 * Formar un documento json, y condificarlo en Base 64
 *
 */
public class JsonBase64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		JsonObject jsonBody = new JsonObject();
		String url = "https://services.habitanto.com/meet/start.html?token=";
		String token_anfitrion = "";
		String token_invitado = "";

		jsonBody.addProperty("subject", "Sala de: Luis");
		jsonBody.addProperty("roomName", "Habitanto-" + "34556");
		jsonBody.addProperty("p2", "Luis p");
		jsonBody.addProperty("password", "password");
		jsonBody.addProperty("tipo", 1); //Reunión personal
		jsonBody.addProperty("fecha", "");

		token_anfitrion = Base64.getEncoder().encodeToString(jsonBody.toString().getBytes());
		jsonBody.addProperty("p2", "");
		
		token_invitado = Base64.getEncoder().encodeToString(jsonBody.toString().getBytes());

		System.out.println(token_anfitrion); 
		System.out.println(token_invitado); 
	}

}
