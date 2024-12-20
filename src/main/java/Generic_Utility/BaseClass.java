package Generic_Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import POM_Repo.HomePage;
import POM_Repo.LoginPage;

public class BaseClass {

	public WebDriver driver;

	@BeforeSuite
	public void Bs() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void Bt() {
		System.out.println("parallel execution");
	}

	@BeforeClass
	public void Bc() throws Throwable {
		System.out.println("Launching Browser");
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
	}

	@BeforeMethod
	public void Bm() throws Throwable {

		File_Utility flib = new File_Utility();
        String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizingWindow1(driver);
		wlib.waitForElementsToLoad(driver);

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		System.out.println("Login into application");
	}

	@AfterMethod
	public void Am() {
		HomePage	home=new HomePage(driver);
		home.logOutApp();
		System.out.println("logout application");
	}

	@AfterClass
	public void Ac() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest
	public void At() {
		System.out.println("close parallel execution");
	}

	@AfterSuite
	public void As() {
		System.out.println("close DataBase");
	}

}
