package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campLink;

	@FindBy(css = "[src=\"themes/softed/images/user.PNG\"]")
	private WebElement admLink;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	@FindBy(linkText = "Products")
	private WebElement prdLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	
	// getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampLink() {
		return campLink;
	}

	/**
	 * This method is used to Select Campaign module
	 */

	public void selectCamp() {
		moreLink.click();
		campLink.click();
	}

	/**
	 * This method is used to logout from Application
	 */
	public void logOutApp() {
		admLink.click();
		signOutLink.click();
	}
/**
 * 
 */
	public void clickPrdLink()
	{
		prdLink.click();
	}
	/**
	 * 
	 */
	public void clickOrgLink()
	{
		orgLink.click();
	}
}
