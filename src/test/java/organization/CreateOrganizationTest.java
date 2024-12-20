package organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import javax.security.auth.login.LoginContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import POM_Repo.CreateCampPage;
import POM_Repo.CreateOrganizationPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;
import POM_Repo.OrgLoopUpImg;
import POM_Repo.OrganizationValidatePage;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrganizationTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickOrgLink();

		OrgLoopUpImg img = new OrgLoopUpImg(driver);
		img.clickPrdLookUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String OrgName = elib.readDataFromExcelSheet("Organization", 0, 0) + ranNum;

		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);

		String phnNum = elib.readDataFromExcelUsingDataProvider("Organization", 1, 0);

		String mailID = elib.readDataFromExcelSheet("Organization", 2, 0);
//		orgPage.enterOrgName(OrgName);
//		orgPage.enterPhnNum(phnNum);
//		orgPage.enterEmailId(mailID);
		// or
		orgPage.enterOrgDetails(OrgName, phnNum, mailID);

		orgPage.ClickSaveButton();

		OrganizationValidatePage validate = new OrganizationValidatePage(driver);
		validate.validateOrg(driver, OrgName);

	}

}
