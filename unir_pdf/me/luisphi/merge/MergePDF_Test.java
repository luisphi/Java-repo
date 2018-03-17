package me.luisphi.merge;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class MergePDF_Test {

	public static void main(String[] args) {
			
		List<InputStream> pdfs = new ArrayList<InputStream>();			
		
		try {
			// Lista con rutas de los archios que se van a unir (Se pueden agregar los documentos que se desee)
			pdfs.add(new FileInputStream("/Users/luispazymino/Desktop/Doc1.pdf"));
			pdfs.add(new FileInputStream("/Users/luispazymino/Desktop/Doc2.pdf"));
			
			// Ruta de salida del documento, especificando el nombre "Salida.pdf"
			OutputStream output = new FileOutputStream("/Users/luispazymino/Desktop/Salida.pdf");
			
			MergePDF merge = new MergePDF(pdfs, output, true);
			merge.concatPDFs();
		} catch (Exception e) {
			System.out.println("REVISE QUE LOS DOCUMENTOS A UNIR SE ENCUENTREN LA CARPETA ESPECIFICADA");
			e.printStackTrace();
		}
	}

}
