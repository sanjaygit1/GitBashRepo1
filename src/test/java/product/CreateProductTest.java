package product;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.CampLookUp;
import POM_Repo.CampValidatePage;
import POM_Repo.CreateCampPage;
import POM_Repo.CreateOrganizationPage;
import POM_Repo.CreateProductPage;
import POM_Repo.HomePage;
import POM_Repo.LoginPage;
import POM_Repo.OrgLoopUpImg;
import POM_Repo.OrganizationValidatePage;
import POM_Repo.PrdLookUpImg;
import POM_Repo.ProductValidatePage;

@Listeners(Generic_Utility.ExtentReportConfig.class)
public class CreateProductTest extends BaseClass {

	@Test(groups = "sanityTest")
	public void createProductTest() throws Throwable {

		HomePage home = new HomePage(driver);
		home.clickPrdLink();

		PrdLookUpImg img = new PrdLookUpImg(driver);
		img.clickPrdLoopUp();

		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

		Excel_Utility elib = new Excel_Utility();
		String prdName = elib.readDataFromExcelSheet("Product", 0, 0) + ranNum;

		CreateProductPage page = new CreateProductPage(driver);
		page.prdDetails(prdName);

	//	Assert.fail();
		ProductValidatePage validate = new ProductValidatePage(driver);

	}



}