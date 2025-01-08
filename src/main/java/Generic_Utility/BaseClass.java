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
import org.testng.annotations.Parameters;

import POM_Repo.HomePage;
import POM_Repo.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void Bs() {
		System.out.println("DataBase connection");
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void Bt() {
		System.out.println("parallel execution");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest", "sanityTest" })
//	public void Bc(String BROWSER) throws Throwable {
	public void Bc() throws Throwable {

		System.out.println("Launching Browser");
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");

		//reading parameters from cmd
//		String BROWSER = System.getProperty("browser");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
			
		}
		sDriver=driver;
	}

//@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = { "smokeTest", "regressionTest", "sanityTest" })
//	public void Bm(String URL,String USERNAME,String PASSWORD) throws Throwable {
	public void Bm() throws Throwable {
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");
	
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizingWindow1(driver);
		wlib.waitForElementsToLoad(driver);

		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginIntoApp(USERNAME, PASSWORD);

		System.out.println("Login into application");
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void Am() {
		HomePage home = new HomePage(driver);
		home.logOutApp();
		System.out.println("logout application");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void Ac() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void At() {
		System.out.println("close parallel execution");
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest", "sanityTest" })
	public void As() {
		System.out.println("close DataBase");
	}

}
