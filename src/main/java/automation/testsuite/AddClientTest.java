package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.ClientPageFactory;
import automation.page.LoginPageFactory;

public class AddClientTest extends CommonBase{
	
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Rise);
	}
	@Test
	public void addClientSuccessfully() throws InterruptedException
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		
		ClientPageFactory client = new ClientPageFactory(driver);
		client.AddClient("Nhien Le");
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Nhien Le']")).isDisplayed());
	}
}
