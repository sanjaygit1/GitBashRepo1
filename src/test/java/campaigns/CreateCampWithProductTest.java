package campaigns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;
import POM_Repo.PrdLookUpImg;
import POM_Repo.ProductValidatePage;
import POM_Repo.WindowSwtiching;

public class CreateCampWithProductTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampWithProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg img = new PrdLookUpImg(driver);
		img.clickPrdLoopUp();

		// To Avoid the Duplicates
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------
		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.readDataFromExcelSheet("Product", 0, 0) + ranNum;

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.prdDetails(prdName);

		home.selectCamp();
		CampLookUp campImg = new CampLookUp(driver);
		campImg.clickCampLookUp();

		String camName = elib.readDataFromExcelSheet("Campaign", 0, 0) + ranNum;

		CreateCampPage campPage = new CreateCampPage(driver);
		campPage.enterCampName(camName);
		campPage.clickPlusImg();

		wlib.switchingWindows(driver, "Products&action");

		WindowSwtiching winSwitch = new WindowSwtiching(driver);
		winSwitch.enterPrdNAme(prdName);
		winSwitch.ClicksearchBar();
		winSwitch.selectPrdName(driver, prdName);

		wlib.switchingWindows(driver, "Campaigns&action");

		campPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCamp(driver, camName);

		ProductValidatePage prdValidate = new ProductValidatePage(driver);

		prdValidate.validateProduct(driver, prdName);

	

	}

}
