package me.luisphi.merge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * 
 * @author Luis Paz y Miño.
 * @description La clase usa la librería itext-4.2.0.jar, en caso de error debe referenciarla al proyecto.
 */

public class MergePDF {
	List<InputStream> streamOfPDFFiles = new ArrayList<InputStream>();
	OutputStream outputStream;
	Boolean paginate;	
	
	//Constructor para la clase
	protected MergePDF(List<InputStream> streamOfPDFFiles, OutputStream outputStream, Boolean paginate) {
		super();
		this.streamOfPDFFiles = streamOfPDFFiles;
		this.outputStream = outputStream;
		this.paginate = paginate;
	}
	
	/*
	 * Método para concatenación de documentos pdf, usando librerias iText
	 * El resultado se constata revisando el nuevo archivo generado en la ruta de outputStream
	 */
	public void concatPDFs() {
		Document document = new Document();
		try {
			List<PdfReader> readers = new ArrayList<PdfReader>();
			int totalPages = 0;
			Iterator<InputStream> iteratorPDFs = streamOfPDFFiles.iterator();

			while (iteratorPDFs.hasNext()) {
				InputStream pdf = iteratorPDFs.next();
				PdfReader pdfReader = new PdfReader(pdf);
				readers.add(pdfReader);
				totalPages += pdfReader.getNumberOfPages();
			}

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();
			PdfContentByte cb = writer.getDirectContent();

			PdfImportedPage page;
			int currentPageNumber = 0;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			while (iteratorPDFReader.hasNext()) {
				PdfReader pdfReader = iteratorPDFReader.next();

				while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {

					Rectangle rectangle = pdfReader.getPageSizeWithRotation(1);
					document.setPageSize(rectangle);
					document.newPage();

					pageOfCurrentReaderPDF++;
					currentPageNumber++;
					page = writer.getImportedPage(pdfReader, pageOfCurrentReaderPDF);
					switch (rectangle.getRotation()) {
					case 0:
						cb.addTemplate(page, 1f, 0, 0, 1f, 0, 0);
						break;
					case 90:
						cb.addTemplate(page, 0, -1f, 1f, 0, 0, pdfReader.getPageSizeWithRotation(1).getHeight());
						break;
					case 180:
						cb.addTemplate(page, -1f, 0, 0, -1f, 0, 0);
						break;
					case 270:
						cb.addTemplate(page, 0, 1.0F, -1.0F, 0, pdfReader.getPageSizeWithRotation(1).getWidth(), 0);
						break;
					default:
						break;
					}
					if (paginate) {
						cb.beginText();
						cb.getPdfDocument().getPageSize();
						cb.endText();
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			document.close();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen())
				document.close();
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		System.out.println(">>>>>EL ARCHIVO HA SIDO GENERADO REVISE LA CARPETA DE SALIDA<<<<<");
	}
}