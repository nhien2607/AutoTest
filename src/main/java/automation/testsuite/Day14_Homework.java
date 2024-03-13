package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.PageFactory_HomeworkDay14;

public class Day14_Homework extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Alada1);
	}
	@Test
	public void signinSuccessfully() throws InterruptedException
	{
		PageFactory_HomeworkDay14 signin = new PageFactory_HomeworkDay14(driver);
		signin.SigninFunction("Khanh Nhien","nhienledokhanh9@gmail.com","123456", "0905123456");
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='fleft martop20 khct']")).isDisplayed());
	}
	@Test
	public void EditPassSuccessfully() throws InterruptedException
	{
		PageFactory_HomeworkDay14 login = new PageFactory_HomeworkDay14(driver);
		login.LoginFunction("nhienledokhanh@gmail.com", "123456");
		
		PageFactory_HomeworkDay14 editpass = new PageFactory_HomeworkDay14(driver);
		editpass.EditPass("123456","654321");
	}
	
}
