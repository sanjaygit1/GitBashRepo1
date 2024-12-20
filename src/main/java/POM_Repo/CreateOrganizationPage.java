package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(id="phone")
	private WebElement phnNum;
	
	@FindBy(id = "email1")
	private WebElement mailId;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnNum() {
		return phnNum;
	}

	public WebElement getMailId() {
		return mailId;
	}
	/**
	 * 
	 * @param name
	 */
	public void enterOrgName(String name)
	{
		orgName.sendKeys(name);
	}
	public void enterPhnNum(String num)
	{
		phnNum.sendKeys(num);
	}
	
	public void enterEmailId(String mail)
	{
		mailId.sendKeys(mail);
	}
	public void ClickSaveButton()
	{
		saveButton.click();
	}
	public void enterOrgDetails(String name,String num,String mail)
	{
		orgName.sendKeys(name);	
		phnNum.sendKeys(num);
		mailId.sendKeys(mail);
	}
}
