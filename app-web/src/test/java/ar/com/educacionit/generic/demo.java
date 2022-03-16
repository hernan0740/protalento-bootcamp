package ar.com.educacionit.generic;

import com.itextpdf.text.DocumentException;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("GG");
		GeneratePDFFileIText generatePDFFileIText = new GeneratePDFFileIText();
		 System.out.println("qGGGGo");
		try {
			generatePDFFileIText.createPDF();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

}
