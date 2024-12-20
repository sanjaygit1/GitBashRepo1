package DDT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import demo.sample;

public class DebuggingEx2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com");
		// driver.manage().window().maximize();
		sample win = new sample();
		win.maximizeWin(driver);
		driver.findElement(By.name("q")).sendKeys("puma");
//pull back
//push back		
	}

}
