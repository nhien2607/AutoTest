package automation.testsuite;

import java.util.*;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class day12_Checkbox extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.checkboxSeleniumEasy);
	}

	@Test
	public void clickSingleCheckbox() {
		WebElement checkbox1 = driver
				.findElement(By.xpath("//label[normalize-space()='Click on this check box']/child::input"));
		if (checkbox1.isSelected() == true) {
			System.out.println("Checkbox1 đã đc checked");
		} else {
			checkbox1.click();
		}
	}
	@Test
	public void clickMultiCheckbox()
	{
		List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//descendant::input[@type='checkbox']"));
		for (int i=0; i<listCheckbox.size();i++)
		{
			if (listCheckbox.get(i).isSelected()== false)
			{
				listCheckbox.get(i).click();
			}
		}
	}
	@Test
	public void clickMultiCheckbox3()
	{
		List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//descendant::input[@type='checkbox']"));
		for (int i=0; i<listCheckbox.size();i++)
		{
			WebElement checkbox = driver.findElement(By.xpath("((//div[@class='panel-body'])[3]//descendant::input[@type='checkbox'])["+(i+1)+"]"));
			if (checkbox.isSelected() == false)
			{
				checkbox.click();
			}
		}
	}
}