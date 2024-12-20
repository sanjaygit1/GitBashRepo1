package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwtiching {

	public WindowSwtiching(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "search_text")
	private WebElement prdTxtField;
	
	@FindBy(name = "search")
	private WebElement serachBar;
	
	
	public void enterPrdNAme(String name)
	{
		prdTxtField.sendKeys(name);
	}
	public void ClicksearchBar()
	{
		serachBar.click();
	}
	
	
	public void selectPrdName(WebDriver driver,String prdName )
	{
		driver.findElement(By.xpath("//a[text()='" + prdName + "']")).click();
	}
	
	
}
