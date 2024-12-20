package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUp {

	public CampLookUp(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[alt=\"Create Campaign...\"]")
	private WebElement campLookUp;

	public WebElement getCampLookUp() {
		return campLookUp;
	}

	public void clickCampLookUp() {
		campLookUp.click();
	}

}
