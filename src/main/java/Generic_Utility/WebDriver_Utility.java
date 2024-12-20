package Generic_Utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizingWindow1(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method is used to wait for ELements to get loaded in GUI
	 * @param driver
	 */
	public void waitForElementsToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
/**
 * 
 * @param driver
 * @param particalTitle
 */
	public void switchingWindows(WebDriver driver,String particalTitle)
	{
		Set<String> allWins1 = driver.getWindowHandles();
		Iterator<String> it1 = allWins1.iterator();

		while (it1.hasNext()) {
			String win1 = it1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if (title1.contains(particalTitle)) {
				break;
			}
		}
	}
	/**
	 * Accepting the Alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
}
