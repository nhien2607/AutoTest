package automation.testsuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Day16_Alert1 extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_GURU);
	}
	@Test
	public void acceptAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));
		WebElement cusTextBox =  driver.findElement(By.name("cusid"));
		cusTextBox.sendKeys("1234");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
		WebElement buttonSubmit = driver.findElement(By.name("submit"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
		buttonSubmit.click();
		
		//Đợi alert xác nhận có muốn xóa customer ko
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		//Đợi alert đã xóa thành công hiện ra
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Delete Customer Form']")));
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Delete Customer Form']")).isDisplayed());
	}
	@Test
	public void dismissAlert()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("cusid")));
		WebElement cusTextBox =  driver.findElement(By.name("cusid"));
		cusTextBox.sendKeys("1234");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("submit")));
		WebElement buttonSubmit = driver.findElement(By.name("submit"));
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
		buttonSubmit.click();
		
		//Đợi alert xác nhận có muốn xóa customer ko
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Delete Customer Form']")));
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='Delete Customer Form']")).isDisplayed());
	}
}
