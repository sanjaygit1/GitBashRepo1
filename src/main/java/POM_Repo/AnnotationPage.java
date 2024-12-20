package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AnnotationPage {
public AnnotationPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

@FindBy(name = "user_name")
private WebElement userTextField;

//@FindBys({@FindBy(css = "[type=\"password\"]"),@FindBy(name="user_password")})

@FindAll({@FindBy(css = "[type=\"password\"]"),@FindBy(name="user_password")})
private WebElement passWordTextField;

@FindBys({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type=\"submit\"]")})
private WebElement saveButton;
	
public void login(String name,String password)
{
	userTextField.sendKeys(name);
	passWordTextField.sendKeys(password);
	saveButton.click();
}


}

