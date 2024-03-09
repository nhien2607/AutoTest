package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.PageFactory_HomeworkDay14;
import automation.page.PageFactory_HomeworkDay15;

public class Day15_Homework extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_TECH);
	}
	@Test
	public void SeachSuccessfully()
	{
		PageFactory_HomeworkDay15 search = new PageFactory_HomeworkDay15(driver);
		search.SearchFunction("Hà Nội", "Đà Nẵng", "02052024");
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Flight Search Result']")).isDisplayed());
	}
	
}
