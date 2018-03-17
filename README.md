# Repositorio de código JAVA
Recopilación de código en java útil, usado en otros proyectos 

## Validación de cédula y RUC - ECUADOR
Validación completa de cédula de identidad y RUC (SRI) para documentos en Ecuador.

Usar la Clase "DniEcuador_Test.java", ingresar el documento a validar y obtendrá el resultado impreso en consola.

```
public static void main(String[] args) {
	// Instanciar la clase y llamar al método
	DniEcuador dni = new DniEcuador("1722345678");
	System.out.println(dni.validation());
}
```

## Clases para Unir varios PDFs
Usar la clase "MergePDF_Test.java", ingresar a la lista "pdfs" la ruta de los archivos a unir.

La clase usa la librería itext-4.2.0.jar, en caso de error debe referenciarla al proyecto.

```
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
		e.printStackTrace();
	}
}
```
