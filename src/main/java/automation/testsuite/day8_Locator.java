package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_Common;


public class day8_Locator extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_SelectorHub);
	}
	@AfterMethod
	public void closeChrome() 
	{
		driver.close();
	}
	@Test
	public void practiceLocator() throws InterruptedException
	{
		driver.findElement(By.xpath("//img[@title='Close']")).click();
		Thread.sleep(3000);
		WebElement userEmail = driver.findElement(By.name("email"));
		System.out.println("userEmail" + userEmail);
		WebElement pass = driver.findElement(By.id("pass"));
		WebElement company = driver.findElement(By.name("company"));
		WebElement mobile_number = driver.findElement(By.name("mobile number"));
	}
	
}
