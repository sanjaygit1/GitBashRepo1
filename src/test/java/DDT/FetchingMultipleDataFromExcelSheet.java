package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		// step1:- path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData77.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		int rowNum = sheet.getLastRowNum();
        System.out.println(rowNum);
        
        for (int i = 0; i < rowNum; i++) 
        {
        	Row row = sheet.getRow(i);
        	Cell cell = row.getCell(0);
        	String links = cell.getStringCellValue();
        	System.out.println(links);
		}
	}

}
