package me.luisphi.create;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import com.lowagie.text.pdf.PdfTable;

import java.io.*;

/**
 * Ejemplo de uso de la librería iText para trabajar con documentos PDF en Java, nos
 * permite crear, analizar, modificar y mantener documentos en este formato.
 *
 */
public class CreatePDF {
	// Definición de fuentes
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	private static final String iTextExampleImage = "/Users/luispazymino/Desktop/1.png";

	public static void main(String args[]) {
		CreatePDF generatePDFFileIText = new CreatePDF();
		generatePDFFileIText.createPDF(new File("/Users/luispazymino/Desktop/salida.pdf"));
	}

	/**
	 * Creamos un documento PDF con iText usando diferentes elementos para aprender
	 * a usar esta librería.
	 * 
	 * @param pdfNewFile
	 *            <code>String</code> pdf File we are going to write. Fichero pdf en
	 *            el que vamos a escribir.
	 */
	public void createPDF(File pdfNewFile) {
		// Creamos el documento e indicamos el nombre del fichero.
		try {
			Document document = new Document(PageSize.A4, 35, 30, 50, 50);
			try {
				PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("No se encontró el fichero para generar el pdf: " + fileNotFoundException);
			}
			document.open();
			// Añadimos los metadatos del PDF
			document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
			document.addSubject("Using iText (usando iText)");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Código Xules");
			document.addCreator("Código Xules");
			

			// Primera página
			Chunk chunk = new Chunk("This is the title", chapterFont);
			chunk.setBackground(BaseColor.GRAY);
			// Creemos el primer capítulo)
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			chapter.setIndentationLeft(200);
			chapter.add(new Paragraph("This is the paragraph de luis", paragraphFont));			
			chapter.add(new Paragraph("Esto va desde esto"));
			
			
			
			Chunk chunk2 = new Chunk("This is the title otro", chapterFont);
			
			Paragraph nombre = new Paragraph("Datos mios", smallBold);
			Paragraph apellido = new Paragraph("Datos mios 2222", smallBold);
			
			nombre.setIndentationLeft(0);
			nombre.setLeading(200);

			apellido.setIndentationLeft(10);
			//apellido.setLeading(0);
			
			apellido.setPaddingTop(1400);
			
			document.add(nombre);
			document.add(apellido);
			
			
			//Agregar table
			PdfPTable table1 = new PdfPTable(4);
			//table1.setWidthPercentage(100);
			//table1.setWidths(new float[] {1,2,6,3});
			table1.setTotalWidth(new float[]{ 150, 216, 90,50});
			table1.setLockedWidth(true);
			
			//table1.setHorizontalAlignment(Element.ALIGN_RIGHT);
						
			for (int j = 0; j < 10; j++) {
				for (int i = 0; i < 4; i++) {
					PdfPCell cell1 = new PdfPCell();
					//cell1.setBorder(Rectangle.NO_BORDER);
					cell1.setHorizontalAlignment(Element.ALIGN_RIGHT);
					Paragraph p1 = new Paragraph("paragraph  : " + i);
					p1.setAlignment(Element.ALIGN_CENTER);
			        cell1.addElement(p1);
			        table1.addCell(cell1);
				}
			}
			
			PdfPTable tableCell = new PdfPTable(1);
	        PdfPCell cel = new PdfPCell();
	        cel.setMinimumHeight(100);
	        cel.setFixedHeight(200);
			cel.addElement(table1);
	        tableCell.addCell(cel);
	        
	        
	       
	        
	        document.add(table1);
	        
	        document.add(tableCell);
			
			////
			document.add(chapter);
			
			
			
			
			//////
			PdfPTable table = new PdfPTable(1);
	        PdfPCell cell = new PdfPCell();
	        Paragraph p;
	        p = new Paragraph(16, "paragraph 1: leading 16");
	        cell.addElement(p);
	        p = new Paragraph(32, "paragraph 2: leading 32");
	        cell.addElement(p);
	        p = new Paragraph(10, "paragraph 3: leading 10");
	        cell.addElement(p);
	        p = new Paragraph(18, "paragraph 4: leading 18");
	        cell.addElement(p);
	        p = new Paragraph(40, "paragraph 5: leading 40");
	        cell.addElement(p);
	        table.addCell(cell);
	        
	        document.add(table);
			
			////////////////////
	        Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
	        Paragraph para = new Paragraph("Test", font);
	        para.setLeading(0, 1);
	        PdfPTable table2 = new PdfPTable(1);
	        table2.setWidthPercentage(100);
	        PdfPCell cell2 = new PdfPCell();
	        cell2.setMinimumHeight(100);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell2.addElement(para);
	        table2.addCell(cell2);
	        document.add(table2);
	        
	        ///////////////////
	        Chunk glue = new Chunk(new VerticalPositionMark());
	        PdfPTable table3 = new PdfPTable(1);
	        Phrase p3 = new Phrase();
	        p3.add("Left");
	        p3.add(glue);
	        p3.add("Right");
	        table3.addCell(p3);
	        document.add(table3);
			
	        //////
	        
		
			
			document.close();
			System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
		} catch (DocumentException documentException) {
			System.out.println(
					"The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}
	}
}
