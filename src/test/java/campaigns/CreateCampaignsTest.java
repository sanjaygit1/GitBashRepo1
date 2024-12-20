package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampLookUp;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateCampPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;

public class CreateCampaignsTest extends BaseClass {

	@Test
	public void createCampaignsTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.selectCamp();

		CampLookUp camp = new CampLookUp(driver);
		camp.clickCampLookUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------

		Excel_Utility elib = new Excel_Utility();
		String camName = elib.readDataFromExcelSheet("Campaign", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(camName);
		campPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCamp(driver, camName);

	}

}
