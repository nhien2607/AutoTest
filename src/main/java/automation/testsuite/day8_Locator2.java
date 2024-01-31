package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class day8_Locator2 extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException
	{
		driver = initChromeDriver(CT_Common.URL_Alada);
	}
	@AfterMethod
	public void closeChrome() 
	{
		driver.close();
	}
	
	@Test
	public void praticeSeletor() {
		WebElement  hoVaTen = driver.findElement(By.id("txtFirstname"));
		WebElement  email = driver.findElement(By.id("txtEmail"));
		WebElement  nhapLaiEmail = driver.findElement(By.id("txtCEmail"));
		WebElement  matKhau = driver.findElement(By.id("txtPassword"));
		WebElement  nhapLaiMatKhau = driver.findElement(By.id("txtCPassword"));
		WebElement  dienThoai = driver.findElement(By.id("txtPhone"));
}
}