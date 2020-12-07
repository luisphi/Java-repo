package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import config.Configuracion;
import entities.Detalle;
import entities.Documento;
import entities.Persona;

public class Get_Documentos {

	public static void main(String[] args) throws IOException {

		try {
			URL url = new URL(Configuracion.UrlDocumento);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", Configuracion.Authorization);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeErrorException(null, "Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			JsonArray jsonDocumentos = new Gson().fromJson(br.readLine(), JsonElement.class).getAsJsonArray();
			ArrayList<Documento> documentos = new ArrayList<Documento>();

			for (int i = 0; i < jsonDocumentos.size(); i++) {
				JsonObject jsonObj = jsonDocumentos.get(i).getAsJsonObject();
				Documento documento = new Documento();
				documento.setIva(jsonObj.get("iva").getAsDouble());
				documento.setId(jsonObj.get("id").getAsString());

				// Detalles
				if (jsonObj.has("detalles")) { // Verificar que tenga detalles
					JsonArray jsonDetalles = jsonObj.get("detalles").getAsJsonArray();
					ArrayList<Detalle> detalles = new ArrayList<Detalle>();
					for (int j = 0; j < jsonDetalles.size(); j++) {
						JsonObject jsonDet = jsonDetalles.get(j).getAsJsonObject();
						Detalle detalle = new Detalle();
						detalle.setPorcentaje_iva(jsonDet.get("porcentaje_iva").isJsonNull() ? null	: jsonDet.get("porcentaje_iva").getAsDouble());
						detalle.setCantidad(jsonDet.get("cantidad").getAsDouble());
						detalle.setBase_no_gravable(jsonDet.get("base_no_gravable").getAsDouble());
						detalle.setProducto_id(jsonDet.get("producto_id").isJsonNull() ? ""	: jsonDet.get("producto_id").getAsString());

						detalles.add(detalle);
					}
					documento.setDetalles(detalles);
				}

				//Clase para personas
				Persona persona = new Persona();
				persona.setDireccion(jsonObj.get("persona").getAsJsonObject().get("direccion").getAsString());

				documento.setPersona(persona);

				documentos.add(documento);
			}

			// Imprimir para verificar
			for (Documento doc : documentos) {
				System.out.println("Iva: " + doc.getIva());
				System.out.println("Id: " + doc.getId());
				System.out.println("--PERSONA--");
				System.out.println("Direccion: " + doc.getPersona().getDireccion());
				System.out.println("--DETALLES--");
				for (int i = 0; i < doc.getDetalles().size(); i++) {
					System.out.println("porcentaje_iva: " + doc.getDetalles().get(i).getPorcentaje_iva());
					System.out.println("cantidad: " + doc.getDetalles().get(i).getCantidad());
					System.out.println("producto_id: " + doc.getDetalles().get(i).getProducto_id());
				}
				System.out.println("=======================================");
			}

			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
