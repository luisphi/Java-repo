import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 * Consumo de servicio web en el servicio Bitly, para acortar enlaces
 *
 */
public class BitLy {

	public static void main(String[] args) throws IOException {

		JsonObject jsonObject = new JsonObject();
		JsonObject jsonResult = new JsonObject();
		jsonObject.addProperty("long_url", "https://services.habitanto.com/meet/room.html?token=eyJyb29tTm=");
		String response = "";
		String urlShort = "";
		System.out.println(jsonObject);

		try {
			URL url = new URL("https://api-ssl.bitly.com/v4/shorten");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", "Bearer fffffffffffff");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Accept", "*/*");

			OutputStream os = conn.getOutputStream();
			os.write(jsonObject.toString().getBytes());
			os.flush();
			System.out.println(conn.getResponseCode());
			if (conn.getResponseCode() != 200 && conn.getResponseCode() != 201) {
				System.out.println("No se ejecutó la consulta por respuesta HTTP no correcta");
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				response = br.readLine();
				jsonResult = new Gson().fromJson(response, JsonElement.class).getAsJsonObject();
				urlShort = jsonResult.get("link").getAsString();
				System.out.println(urlShort);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
