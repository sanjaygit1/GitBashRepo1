package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// initilzation
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Element Decalartion
	@FindBy(name = "user_name")
	private WebElement UserTextField;

	@FindBy(name = "user_password")
	private WebElement PassWordTextField;

	@FindBy(id = "submitButton")
	private WebElement LoginButton;

	// getter methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business Logics
	/**
	 * This method is used to login into vtiger application
	 * @param username
	 * @param password
	 */
public void loginIntoApp(String username,String password)
{
	UserTextField.sendKeys(username);
	PassWordTextField.sendKeys(password);
	LoginButton.click();
}
}
