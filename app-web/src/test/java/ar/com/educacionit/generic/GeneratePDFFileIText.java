package ar.com.educacionit.generic;
import java.io.File;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import ar.com.educacionit.domain.Articulos;

public class GeneratePDFFileIText {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
         
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    
    public void createPDF(Collection<Articulos> prueba) throws DocumentException {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        
           
			try { Document document = new Document();
            		OutputStream outputStream;
				outputStream = new FileOutputStream(new File("C://Users//usuario//Desktop//tablaArticulos.pdf"));
				PdfWriter.getInstance(document, outputStream);
			
				document.open();
	            // We add metadata to PDF
	            // Añadimos los metadatos del PDF
	            document.addTitle("ARTICULOS (Exportamos la tabla a PDF)");
	            document.addSubject("Using iText (usando iText)");
	            document.addKeywords("Java, PDF, iText");
	            document.addAuthor("Código Xules");
	            document.addCreator("Código Xules");
	             
	            // First page
	            // Primera página 
	            Chunk chunk = new Chunk("Practica", chapterFont);
	            chunk.setBackground(BaseColor.GRAY);
	            // Let's create de first Chapter (Creemos el primer capítulo)
	            Chapter chapter = new Chapter(new Paragraph(chunk),1);
	            chapter.setNumberDepth(0);
	            chapter.add(new Paragraph(" Semana 13"));
	            
	                       
	           
	            Paragraph paragraph = new Paragraph();
	            Section paragraphMore = chapter.addSection(paragraph);
	            	            
	            //agregar articulos
	         
	           
	            Integer numColumns = 6;
	            Integer numRows = 1;
	            // We create the table (Creamos la tabla).
	            PdfPTable table = new PdfPTable(numColumns); 
	            PdfPCell celdainicial = new PdfPCell(new Paragraph("ARTICULOS DISPONIBLES",FontFactory.getFont("arial",16,Font.ITALIC,BaseColor.WHITE)));
	            celdainicial.setHorizontalAlignment(Element.ALIGN_CENTER);
	            celdainicial.setBackgroundColor(BaseColor.DARK_GRAY);
	            celdainicial.setColspan(6);
	            table.addCell(celdainicial);
	            // Ahora llenamos la tabla del PDF
	            PdfPCell columnHeader;
	            
	            String encabezado[]={"TITULO",	"CODIGO","PRECIO","STOCK","MARCASID","CATEGORIASID"};
	            
	            for (int column = 0; column < numColumns; column++) {
	                columnHeader = new PdfPCell(new Phrase(encabezado[column],FontFactory.getFont("arial",14,Font.ITALIC,BaseColor.DARK_GRAY)));
	                columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
	                columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                table.addCell(columnHeader);
	            }
	            table.setHeaderRows(1);
	            // Fill table rows (rellenamos las filas de la tabla).                
	            PdfPCell rows;
	            for (int row = 0; row < numRows; row++) {
	                
	            	int column = 0;
	                	for(Articulos aux:prueba) {
	    	            	
	                		//TITULO	CODIGO	PRECIO	STOCK	MARCASID	CATEGORIASID
	                		rows=new PdfPCell(new Phrase(aux.getTitulo()));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	                		
	                		
	                		table.addCell(rows);
	    	            	rows=new PdfPCell(new Phrase(aux.getCodigo()));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            	table.addCell(rows);
	    	            	rows=new PdfPCell(new Phrase(String.valueOf(aux.getPrecio())));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            	table.addCell(rows);
	    	            	rows=new PdfPCell(new Phrase(String.valueOf(aux.getStock())));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            	table.addCell(rows);
	    	            	rows=new PdfPCell(new Phrase(String.valueOf(aux.getMarcasId())));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            	table.addCell(rows);
	    	            	rows=new PdfPCell(new Phrase(String.valueOf(aux.getCategoriasId())));
	                		rows.setHorizontalAlignment(Element.ALIGN_CENTER);
	    	            	table.setWidthPercentage(105f);
	    	            	
	                		table.addCell(rows);
	    	            	
	    	            	column++;
	    	            }
	             
	            }
	            
	            table.setHorizontalAlignment(Element.ALIGN_CENTER);
	            float[] widths = new float[] { 6f, 6f,6f,6f,8f,8f };
	            table.setTotalWidth(widths);
	            paragraph.add(table);
	            document.add(chapter);
	            document.close();
	            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!"); 
			
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("error no se encontro nada");
			}
            
        
            
    }
            
}         
       
       
    
