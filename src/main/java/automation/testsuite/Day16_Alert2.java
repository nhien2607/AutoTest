package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Day16_Alert2 extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_ALERT);
	}
	@Test
	public void accepttextboxAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='analystic' and text() = 'Alert with Textbox ']")));
		WebElement buttonAlertWithTextbox = driver.findElement(By.xpath("//a[@class='analystic' and text() = 'Alert with Textbox ']"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonAlertWithTextbox));
		buttonAlertWithTextbox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		WebElement buttonOpenAlert = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
		buttonOpenAlert.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Nhien");
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo1")));
		WebElement outputElement = driver.findElement(By.id("demo1"));
		Assert.assertTrue(outputElement.isDisplayed());
		
		String text = outputElement.getText();
		Assert.assertEquals("Hello Nhien How are you today", text);
	}
	@Test
	public void dismisstextboxAlert() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='analystic' and text() = 'Alert with Textbox ']")));
		WebElement buttonAlertWithTextbox = driver.findElement(By.xpath("//a[@class='analystic' and text() = 'Alert with Textbox ']"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonAlertWithTextbox));
		buttonAlertWithTextbox.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		WebElement buttonOpenAlert = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonOpenAlert));
		buttonOpenAlert.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Nhien");
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(3000);
		WebElement outputElement = driver.findElement(By.id("demo1"));
		String text = outputElement.getText();
		Assert.assertEquals("", text);
	}
}
