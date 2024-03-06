package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.constant.CT_Common;
import automation.page.LoginPageFactory;

public class LoginTest_Day14 extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Rise);
	}
	@Test
	public void loginSuccessfully()
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.TEXT_DASHBOARD).isDisplayed());
	}
	
	@Test
	public void loginFail_EmailIncorrectValue()
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("adminIncorrect@demo.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.AUTHEN_ERROR).isDisplayed());
	}
	
	@Test
	public void loginFail_EmailIncorrectFormat()
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo_123.com", "riseDemo");
		assertTrue(driver.findElement(CT_Account.EMAIL_FORMAT_ERROR).isDisplayed());
	}
	
	@Test
	public void loginFail_PassIncorrectValue()
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemoIncorrect");
		assertTrue(driver.findElement(CT_Account.AUTHEN_ERROR).isDisplayed());
	}
	@AfterMethod
	public void closeChrome() 
	{
		driver.close();
	}
}
