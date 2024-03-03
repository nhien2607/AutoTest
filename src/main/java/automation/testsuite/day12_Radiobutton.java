package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class day12_Radiobutton extends CommonBase {

	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.radioButton);
	}
	@Test
	public void clickRadio()
	{
		WebElement radioMale = driver.findElement(By.xpath("(//input[@value='Male'])[1]"));
		if (radioMale.isEnabled()== true && radioMale.isSelected()== false)
		{
			radioMale.click();
		}
		else
		{
			WebElement radioFeMale = driver.findElement(By.xpath("(//input[@value='Female'])[1]"));
			radioFeMale.click();
		}
	}
}
