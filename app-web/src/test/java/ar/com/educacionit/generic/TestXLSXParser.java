package ar.com.educacionit.generic;

import java.io.File;
import java.util.Collection;

import com.itextpdf.text.DocumentException;

import ar.com.educacionit.domain.Articulos;

public class TestXLSXParser {

	public static void main(String[] args) throws ParseException {
		
		String path = "./src/test/java/ar/com/educacionit/generic/articulos.xlsx";
		
		IParser<Collection<Articulos>> xlsxParser = new XLSXFileParser(path); 

			try {
				
				Collection<Articulos> articulos = xlsxParser.parse();			
				//System.out.println(articulos.size() == 1);
				System.out.println(articulos);
				GeneratePDFFileIText nuevoPdf = new GeneratePDFFileIText();
				nuevoPdf.createPDF(articulos);
				
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		
	}

		
		
	}


