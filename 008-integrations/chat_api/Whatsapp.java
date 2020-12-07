package chat_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * 
 * @author luispazymino
 * Clase para comunicación con https://chat-api.com, envío de Whatsapp
 *
 */
class Whatsapp {
	private String token;
	private String instance;

	//Constructor
	public Whatsapp(String token, String instance) {
		super();
		this.token = token;
		this.instance = instance;
	}

	// OBETENER INFORMACION DE LA INSTANCIA, EN ESPECIAL SI ESTA AUTENTIFICADA
	String getStatus() {
		String result = "";
		try {
			URL url = new URL(instance + "status?full=true&no_wakeup=true&token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// OBTENER INFORMACION SOBRE EL TELEFONO, EN ESPECIAL LA BATERIA
	String getMe() {
		String result = "";
		try {
			URL url = new URL(instance + "me?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// ENVIAR UN MENSAJE PLANO
	String sendMessage(String phone, String message) {
		String result = "";
		JsonObject jsonBody = new JsonObject();
		jsonBody.addProperty("phone", phone);
		jsonBody.addProperty("body", message);

		try {
			URL url = new URL(instance + "sendMessage?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
				jsonBody = new Gson().fromJson(result, JsonElement.class).getAsJsonObject();
				result = jsonBody.get("sent").getAsString();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// ENVIAR UN ARCHIVO DESDE COMO UN MENSAJE
	String sendFile(String phone, String pathFile, String filename, String caption, Boolean cached) {
		String result = "";
		JsonObject jsonBody = new JsonObject();
		jsonBody.addProperty("phone", phone);
		jsonBody.addProperty("body", pathFile);
		jsonBody.addProperty("filename", filename);
		jsonBody.addProperty("caption", caption);
		jsonBody.addProperty("cached", cached);

		try {
			URL url = new URL(instance + "sendFile?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
				jsonBody = new Gson().fromJson(result, JsonElement.class).getAsJsonObject();
				result = jsonBody.get("sent").getAsString();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// PARA ENVIAR AUDIOS COMO MENSAJES
	String sendPTT(String phone, String audio) {
		String result = "";
		JsonObject jsonBody = new JsonObject();
		jsonBody.addProperty("phone", phone);
		jsonBody.addProperty("audio", audio);

		try {
			URL url = new URL(instance + "sendPTT?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
				jsonBody = new Gson().fromJson(result, JsonElement.class).getAsJsonObject();
				result = jsonBody.get("sent").getAsString();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// ENVIAR UNA UBICACION POR MENSAJE
	String sendLocation(String phone, String lat, String lng, String address) {
		String result = "";
		JsonObject jsonBody = new JsonObject();
		jsonBody.addProperty("phone", phone);
		jsonBody.addProperty("lat", lat);
		jsonBody.addProperty("lng", lng);
		jsonBody.addProperty("address", address);

		try {
			URL url = new URL(instance + "sendLocation?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
				jsonBody = new Gson().fromJson(result, JsonElement.class).getAsJsonObject();
				result = jsonBody.get("sent").getAsString();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// CREAR GRUPOS TOMANDO UN LISTADO DE TELEFONOS
	String createGroup(String groupName, String[] phones, String messageText) {
		String result = "";
		JsonObject jsonBody = new JsonObject();
		JsonArray array = new JsonArray();
		for (String value : phones) {
			array.add(new JsonPrimitive(value));
		}
		jsonBody.addProperty("groupName", groupName);
		jsonBody.add("phones", array);
		jsonBody.addProperty("messageText", messageText);
		System.out.println(jsonBody);
		try {
			URL url = new URL(instance + "group?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/json");

			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
				jsonBody = new Gson().fromJson(result, JsonElement.class).getAsJsonObject();
				result = jsonBody.get("created").getAsString();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// MOSTRAR LA COLA DE MENSAJES AUN NO ENVIADOS
	String showMessagesQueue() {
		String result = "";
		try {
			URL url = new URL(instance + "showMessagesQueue?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// LIMPIAR LA COLA DE MENSAJES PENDIENTES
	String clearMessagesQueue() {
		String result = "";
		try {
			URL url = new URL(instance + "clearMessagesQueue?token=" + token);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}

	// VERIFICAR SI UN CELULAR TIENE ACCESO A WHATSAPP
	Boolean checkPhone(String phone) {
		String result = "";
		try {
			URL url = new URL(instance + "checkPhone?token=" + token + "&phone=" + phone);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			if (conn.getResponseCode() == 200) {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				result = br.readLine();
			} else {
				result = "Failed : HTTP error code : " + conn.getResponseCode();
			}
			conn.disconnect();
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result.contains("not") ? false : true;
	}

}
