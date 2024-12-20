package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utility.Java_Utility;

public class DataProviderEx3 {

	@Test(dataProvider = "getData")
	public void createOrganization(String name, String mailId) throws Throwable {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().window().maximize();

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();

		driver.findElement(By.name("accountname")).sendKeys(name);
		driver.findElement(By.name("email1")).sendKeys(mailId);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

	@DataProvider
	public Object[][] getData()
	{
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		Object[][] objArr = new Object[3][2];
		
		objArr[0][0]="AAA"+ranNum;
		objArr[0][1]="abc@gmail.com";
		
		objArr[1][0]="BBB"+ranNum;
		objArr[1][1]="chsgv@gmail.com";
		
		objArr[2][0]="CCC"+ranNum;
		objArr[2][1]="amcb@gmail.com";
		
		return objArr;
		
	}
}
