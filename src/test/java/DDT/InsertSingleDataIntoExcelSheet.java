package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataIntoExcelSheet {

	public static void main(String[] args) throws Throwable {

		// step1:- path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData77.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet("Sheet1");

		Row row = sheet.createRow(0);

		Cell cell = row.createCell(0);

		cell.setCellValue("Puma");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData77.xlsx");
		book.write(fos);
		book.close();
	}

}
