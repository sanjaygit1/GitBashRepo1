package DDT;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class FetchingDataFromPDF {

	public static void main(String[] args) throws IOException {

		File file = new File("./src/test/resources/multipage-pdf.pdf");

		PDDocument doc = PDDocument.load(file);

		int pages = doc.getNumberOfPages();// Fetches total num of pages present
//	System.out.println(pages);

		PDFTextStripper pdfData = new PDFTextStripper();
//		String readData = pdfData.getText(doc);//reads all the pages data
//		System.out.println(readData);

//		pdfData.setStartPage(2);
//		String page = pdfData.getText(doc);
//		System.out.println(page);

		pdfData.setStartPage(2);
		pdfData.setEndPage(2);
		
		String page = pdfData.getText(doc);
		System.out.println(page);
	}

}
