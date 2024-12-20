package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLoopUpImg {

	public OrgLoopUpImg(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[alt=\"Create Organization...\"]")
	private WebElement prdLookUp;

	public WebElement getPrdLookUp() {
		return prdLookUp;
	}
	
	public void clickPrdLookUp()
	{
		prdLookUp.click();
	}
}
