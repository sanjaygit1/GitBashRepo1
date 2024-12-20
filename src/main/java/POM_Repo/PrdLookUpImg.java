package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrdLookUpImg {

	
	public PrdLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title=\"Create Product...\"]")
	private WebElement prdLooUp;

	public WebElement getPrdLooUp() {
		return prdLooUp;
	}
	
	public void clickPrdLoopUp()
	{
		prdLooUp.click();
	}
}
