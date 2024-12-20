package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductValidatePage {

	public ProductValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateProduct(WebDriver driver,String prdName)
	{
		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

		if (actData1.contains(prdName)) {
			System.out.println("product name is created");
		} else {
			System.out.println("Product name is not created");
		}
	}
}
