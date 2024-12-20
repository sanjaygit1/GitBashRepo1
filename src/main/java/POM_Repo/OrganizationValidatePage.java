package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidatePage {

	public OrganizationValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateOrg(WebDriver driver,String name)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

		if (actData.contains(name)) {
			System.out.println("Orgnization is created");
		}

		else {
			System.out.println("Orgnization not created");
		}
	}
}
