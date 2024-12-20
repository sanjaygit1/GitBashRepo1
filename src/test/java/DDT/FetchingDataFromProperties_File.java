package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingDataFromProperties_File {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = new ChromeDriver();

		// Hard coding
//		driver.get("https://www.saucedemo.com/v1");
//		driver.manage().window().maximize();
//
//		driver.findElement(By.id("user-name")).sendKeys("standard_user");
//		driver.findElement(By.id("password")).sendKeys("secret_sauce");
//		driver.findElement(By.id("login-button")).click();

		// --------------------------------------------------------------------------------------------

		// step1:-get java representation object of the physical file(path setting)
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\PropertiesFile7.properties");

		// step2:-Create object of Properties class
		Properties pro = new Properties();

		//step3:- load all the keys
		pro.load(fis);

		//step4:- read keys using the method getProperty("key")
		String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");
		
        driver.get(URL);
        driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

	}

}
