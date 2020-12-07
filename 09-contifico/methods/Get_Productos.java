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
import entities.Producto;

public class Get_Productos {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(Configuracion.UrlProducto);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", Configuracion.Authorization);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeErrorException(null, "Failed : HTTP error code : "  + conn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			
			JsonArray jsonProductos = new Gson().fromJson(br.readLine(), JsonElement.class).getAsJsonArray();
			ArrayList<Producto> productos = new ArrayList<Producto>();
			
			for (int i = 0; i < jsonProductos.size(); i++) {
				JsonObject jsonObj = jsonProductos.get(i).getAsJsonObject();
				Producto producto = new Producto();
				producto.setCodigo_barra(jsonObj.get("codigo_barra").getAsString());
				producto.setPara_pos(jsonObj.get("para_pos").getAsBoolean());
				producto.setPorcentaje_iva(jsonObj.get("porcentaje_iva").isJsonNull() ? null : jsonObj.get("porcentaje_iva").getAsDouble());
				producto.setPersonalizado1(jsonObj.get("personalizado1").isJsonNull() ? null : jsonObj.get("personalizado1").getAsString());
				producto.setImagen(jsonObj.get("imagen").isJsonNull() ? null : jsonObj.get("imagen").getAsString());
				producto.setTipo(jsonObj.get("tipo").getAsString());
				producto.setCategoria_id(jsonObj.get("categoria_id").isJsonNull() ? "" : jsonObj.get("categoria_id").getAsString());
				producto.setPersonalizado2(jsonObj.get("personalizado2").isJsonNull() ? null : jsonObj.get("personalizado2").getAsString());
				producto.setMarca_id(jsonObj.get("marca_id").isJsonNull() ? null : jsonObj.get("marca_id").getAsString());
				producto.setMinimo(jsonObj.get("minimo").getAsDouble());
				producto.setTipo_producto(jsonObj.get("tipo_producto").getAsString());
				producto.setPvp3(jsonObj.get("pvp3").isJsonNull() ? null : jsonObj.get("pvp3").getAsDouble());
				producto.setPvp1(jsonObj.get("pvp1").isJsonNull() ? null : jsonObj.get("pvp1").getAsDouble());
				producto.setPvp_manual(jsonObj.get("pvp_manual").getAsBoolean());
				producto.setPvp2(jsonObj.get("pvp2").isJsonNull() ? null : jsonObj.get("pvp2").getAsDouble());
				producto.setDescripcion(jsonObj.get("descripcion").getAsString());
				producto.setNombre(jsonObj.get("nombre").getAsString());
				producto.setEstado(jsonObj.get("estado").getAsCharacter());
				producto.setId(jsonObj.get("id").getAsString());
				producto.setCantidad_stock(jsonObj.get("cantidad_stock").getAsInt());
				
				productos.add(producto);
			}
			
			//Imprmimir
			for (Producto prod : productos) {
				System.out.println("codigo_barra: " + prod.getCodigo_barra());
				System.out.println("para_pos: " + prod.getPara_pos());
				System.out.println("porcentaje_iva: " + prod.getPorcentaje_iva());
				System.out.println("personalizado1: " + prod.getPersonalizado1());
				System.out.println("imagen: " + prod.getImagen());
				System.out.println("tipo: " + prod.getTipo());
				System.out.println("categoria_id: " + prod.getCategoria_id());
				System.out.println("personalizado2: " + prod.getPersonalizado2());
				System.out.println("marca_id: " + prod.getMarca_id());
				System.out.println("minimo: " + prod.getMinimo());
				System.out.println("tipo_producto: " + prod.getTipo_producto());
				System.out.println("pvp3: " + prod.getPvp3());
				System.out.println("pvp1: " + prod.getPvp1());
				System.out.println("pvp_manual: " + prod.getPvp_manual());
				System.out.println("pvp2: " + prod.getPvp2());
				System.out.println("descripcion: " + prod.getDescripcion());
				System.out.println("nombre: " + prod.getNombre());
				System.out.println("codigo: " + prod.getCodigo());
				System.out.println("estado: " + prod.getEstado());
				System.out.println("id: " + prod.getId());
				System.out.println("cantidad_stock: " + prod.getCantidad_stock());
				System.out.println("==============================================");
			}
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
