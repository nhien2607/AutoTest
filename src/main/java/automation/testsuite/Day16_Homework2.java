package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Day16_Homework2 extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_ALERT_DEMO);
	}
	@Test
	public void assertAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
		WebElement buttonTryit = driver.findElement(By.xpath("//button[text()='Try it']"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonTryit));
		buttonTryit.click();
		
		wait.until(ExpectedConditions.alertIsPresent());	
		Assert.assertEquals("Welcome to Selenium WebDriver Tutorials",driver.switchTo().alert().getText());
	}
}
