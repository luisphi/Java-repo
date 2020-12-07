package methods;

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

import config.Configuracion;

public class Post_Persona {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JsonObject jsonBody = new JsonObject();
		JsonObject jsonOut = new JsonObject();
		
		try {
			URL url = new URL(Configuracion.UrlPersona_Post);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", Configuracion.Authorization);
			conn.setRequestProperty("Content-Type", "application/json");
			
			//Agregar datos a Json para enviar datos			
			jsonBody.addProperty("tipo", "N");
			jsonBody.addProperty("telefonos", "2745486");
			jsonBody.addProperty("ruc", "");
			jsonBody.addProperty("razon_social", "Andres perrosa");
			jsonBody.addProperty("direccion", "AV. 9 DE OCTUBRE 729 Y BOYACA - GARCIA AVILES");
			jsonBody.addProperty("es_extranjero", true);
			jsonBody.addProperty("porcentaje_descuento", "10");
			jsonBody.addProperty("es_cliente", true);
			jsonBody.add("id", null);
			jsonBody.addProperty("es_empleado", false);
			jsonBody.addProperty("email", "agomez@nomail.com");
			jsonBody.addProperty("cedula", "1729581278");
			jsonBody.addProperty("placa", "24567");
			jsonBody.addProperty("es_vendedor", false);
			jsonBody.addProperty("es_proveedor", false);
			jsonBody.addProperty("es_corporativo", false);
			jsonBody.add("adicional1_cliente", null);
			jsonBody.add("adicional2_cliente", null);
			jsonBody.add("adicional3_cliente", null);
			jsonBody.add("adicional4_cliente", null);
			jsonBody.add("adicional1_proveedor", null);
			jsonBody.add("adicional2_proveedor", null);
			jsonBody.add("adicional3_proveedor", null);
			jsonBody.add("adicional4_proveedor", null);	
			jsonBody.add("banco_codigo_id", null);
			jsonBody.add("numero_tarjeta", null);
			jsonBody.add("aplicar_cupo", null);
			jsonBody.add("tipo_cuenta", null);
			
			OutputStream os = conn.getOutputStream();
			os.write(jsonBody.toString().getBytes());
			os.flush();	
			
			System.out.println("Este es el codigo: " + conn.getResponseCode());
			
						
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				System.out.println("Entra en el error");
				//throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			} else {
				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				
				System.out.println("Output from Server .... \n");
				//System.out.println("Este es el br: " + br.readLine());
				System.out.println("-------");
				
				
				
				jsonOut = new Gson().fromJson(br.readLine(), JsonElement.class).getAsJsonObject();				
				System.out.println(jsonOut.get("id").getAsString()); 
				
				String response;
				while ((response = br.readLine()) != null) {
					jsonOut = new Gson().fromJson(response, JsonElement.class).getAsJsonObject();
					System.out.println(jsonOut.get("id").getAsString()); 
				}
			}				
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Entro al error");
		}
	}

}
