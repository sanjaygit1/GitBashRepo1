package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utility.File_Utility;
import Generic_Utility.WebDriver_Utility;
import POM_Repo.AnnotationPage;

public class MultiplePOMAnnotation {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizingWindow1(driver);
		wlib.waitForElementsToLoad(driver);
		driver.get(URL);
		
		AnnotationPage page = new AnnotationPage(driver);
		page.login(USERNAME, PASSWORD);
	}

}
