package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.LoginPage;

public class LoginTest extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Rise);
	}
	@AfterMethod
	public void closeChrome() 
	{
		driver.close();
	}
	@Test
	public void loginSuccessfully()
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		assertTrue(driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
	}
	@Test
	public void loginFailIncorrectEmail()
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("adminIncorrect@demo.com", "riseDemo");
		assertTrue(driver.findElement(By.xpath("//div[normalize-space()='Authentication failed!']")).isDisplayed());
	}
	@Test
	public void loginFailIncorrectPass()
	{
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@demo.com", "riseDemoIncorrect");
		assertTrue(driver.findElement(By.xpath("//div[normalize-space()='Authentication failed!']")).isDisplayed());
	}
}
