package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
//Inserting Data Into Properties File
		// step1:-get java representation object of the physical file(path setting)
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesFile7.properties");

		// step2:-Create object of Properties class
		Properties pro = new Properties();

		pro.setProperty("url", "https://www.saucedemo.com/v1");
		pro.setProperty("username", "standard_user");
		pro.setProperty("password", "secret_sauce");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/PropertiesFile7.properties");
		pro.store(fos, "CommonData");
//---------------------------------------------------------------------------------------------------------
		// fetching Data from Properties File

		WebDriver driver = new ChromeDriver();
		pro.load(fis);

		// step4:- read keys using the method getProperty("key")
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

	}

}
