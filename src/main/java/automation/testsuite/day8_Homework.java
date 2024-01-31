package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class day8_Homework extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException
	{
		driver = initChromeDriver(CT_Common.URL_Automationfc);
	}
	@AfterMethod
	public void closeChrome() 
	{
		driver.close();
	}
	
	@Test
	public void praticeSeletor() {
		WebElement name = driver.findElement(By.id("name"));
		WebElement address = driver.findElement(By.id("address"));
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
	}		
}
