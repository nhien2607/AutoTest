package automation.testsuite;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Day17_WindowHandle extends CommonBase {
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_GURU2);
	}
	@Test
	public void handleWindowPopup()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		By clickHerebtn = By.xpath("//a[text()='Click Here']");
		wait.until(ExpectedConditions.elementToBeClickable(clickHerebtn));
		driver.findElement(clickHerebtn).click();
		//Lấy ra window chính
		String mainWindow = driver.getWindowHandle();
		//Lấy ra các window đang đc mở
		Set<String > allWindows = driver.getWindowHandles();
		//Duyệt ra các window trong allWindows để nhập email và click Submit button
		for (String window:allWindows)
		{
			if(!window.equals(mainWindow))
			{
				driver.switchTo().window(window);
				driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
				driver.findElement(By.name("btnLogin")).click();
				Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).isDisplayed());
				System.out.println(driver.getCurrentUrl());// Print URL cua Window
				System.out.println(driver.getTitle());//Print title cua Window
				driver.close();
			}	
		}
		//Hết for thì chuyển về mainWindow để chạy tiếp
		driver.switchTo().window(mainWindow);
	}
}
