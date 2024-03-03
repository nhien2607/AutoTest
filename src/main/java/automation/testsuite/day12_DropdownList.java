package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class day12_DropdownList extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.dropdownListSeleniumEasy);
	}

	@Test
	public void testDropdownlist() {
		Select dropDLDay = new Select(driver.findElement(By.id("select-demo")));
		System.out.println("Size is: " + dropDLDay.getOptions().size());
		dropDLDay.selectByVisibleText("Monday");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertEquals(dropDLDay.getFirstSelectedOption().getText(), "Monday");
		dropDLDay.selectByValue("Tuesday");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertEquals(dropDLDay.getFirstSelectedOption().getText(), "Tuesday");
		dropDLDay.selectByIndex(1);
		Assert.assertEquals(dropDLDay.getFirstSelectedOption().getText(), "Sunday");

	}
}
