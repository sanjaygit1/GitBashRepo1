package POM_Repo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProduct {

	public DeleteProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Products")
	private WebElement prdLink;
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement deleteButton;
	
	
	public void ClickPrdLink()
	{
		prdLink.click();
	}
	public void selectCheckBox(WebDriver driver,String name)
	{
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='"+name+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
	}
	
	public void clickDeleteButton()
	{
		deleteButton.click();
	}
	
	public void ValidatePrdDeleted(WebDriver driver,String prdName)
	{
		List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));

		boolean flag = false;

		for (WebElement PrdData : prdList) {
			String data = PrdData.getText();
			if (data.contains(prdName)) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("Product data is deleted");
		} else {
			System.out.println("product data is not deleted");

		}
	}
}
