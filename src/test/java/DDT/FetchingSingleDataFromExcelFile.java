package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcelFile {

	public static void main(String[] args) throws Throwable {

		// step1:- path connection
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData77.xlsx");

		// step2:- keep workbook in read mode
		Workbook book = WorkbookFactory.create(fis);

		// step3:- Navigates into particular sheet
		Sheet sheet = book.getSheet("Sheet1");

		// step4:- Navigates into particular Row
		Row row = sheet.getRow(2);

		// step5:-Navigates into particular cell

		Cell cell = row.getCell(1);

		String ExcelData = cell.getStringCellValue();
		System.out.println(ExcelData);

	}

}
