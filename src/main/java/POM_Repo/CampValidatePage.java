package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampValidatePage {

	public CampValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method is used for validating camp name
	 * @param driver
	 * @param camName
	 */
	public void validateCamp(WebDriver driver,String camName)
	{
		String actdata = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
//		if (actdata.contains(camName)) {
//			System.out.println("campaign name is created");
//		} else {
//			System.out.println("campaign name is not carated");
//		}
		Assert.assertEquals(actdata,camName,"Assert Fail");
		System.out.println("Assert Pass");
		
	}
}
