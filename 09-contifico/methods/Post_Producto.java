package methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import config.Configuracion;
import entities.Producto;

public class Post_Producto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Producto producto = new Producto();
		
		producto.setCodigo_barra("1234567");
		producto.setPara_pos(true);
		producto.setPorcentaje_iva(12.0);
		producto.setPvp1(1.0);
		producto.setPvp2(4.0);
		producto.setPvp3(8.0);		
		producto.setPvp_manual(false);
		producto.setNombre("Expensa abril 2018");		
		producto.setCodigo("004");
		producto.setDescripcion("Mensualidad de expensas");
		producto.setEstado('A');
		producto.setCategoria_id("OjZdyyPpTr1QdJ4m");
		producto.setMinimo(0.0);		
        
        try {
			URL url = new URL(Configuracion.UrlProducto);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Authorization", Configuracion.Authorization);
			conn.setRequestProperty("Content-Type", "application/json");
						
			OutputStream os = conn.getOutputStream();
			os.write(new Gson().toJson(producto).toString().getBytes());
			os.flush();			
			
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(	(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}		
			
			conn.disconnect();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
