import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author luispazymino
 * @description Clase para leer y listar atributos de archivos de manera recursiva en directorios
 */

public class GetInfo_File {
	static List<Info_File> infoFileList = new ArrayList<Info_File>();
	//Filtro de fecha y ruta de carpeta a leer
	static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	static String route = "/Users/luispazymino/Desktop/1.BackUPajva";

	public static void main(String[] args) throws ParseException {
		// Obtener toda la lista de archivos
		File[] files = new File(route).listFiles();
		
		//Opción para solo consultar archivos con fecha de modificación mayor a cierta fecha
		String dateInString = "22-01-2018 10:20:56";
		Date date = sdf.parse(dateInString);
		
		showFiles(files, date.getTime());
			
		for (int i = 0; i < infoFileList.size(); i++) {
			System.out.println("Nombre: " + infoFileList.get(i).getName().substring(0, infoFileList.get(i).getName().lastIndexOf(".")));
			System.out.println("Extensión: " + infoFileList.get(i).getExtension());
			System.out.println("Path: " + infoFileList.get(i).getPath());
			System.out.println("Fecha Modificado: " + sdf.format(infoFileList.get(i).getLastModified()));
			System.out.println("======================");
		}
	}

	/**
	 * 
	 * @param files
	 * @param time
	 * @return
	 */

	public static void showFiles(File[] files, Long time) {
		for (File file : files) {
			if (!file.isHidden() && file.lastModified() >= time) {
				if (file.isDirectory()) {
					showFiles(file.listFiles(), time); // Llamada recursiva.
				} else {
					Info_File info = new Info_File(file.getName(), file.getPath(), file.lastModified(), 
							file.getName().substring(file.getName().lastIndexOf("."), file.getName().length()));
					
					infoFileList.add(info);
				}
			}
		}		
	}
}
