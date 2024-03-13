package automation.testsuite;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.PageFactory_HomeworkDay14;

public class Day16_Homework extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Alada1);
	}
	@Test
	public void EditPassSuccessfully() throws InterruptedException
	{
		PageFactory_HomeworkDay14 login = new PageFactory_HomeworkDay14(driver);
		login.LoginFunction("nhienledokhanh@gmail.com", "654321");
		
		PageFactory_HomeworkDay14 editpass = new PageFactory_HomeworkDay14(driver);
		editpass.EditPass("654321","123456");
		
		Assert.assertEquals("",driver.getTitle());
	}
}
