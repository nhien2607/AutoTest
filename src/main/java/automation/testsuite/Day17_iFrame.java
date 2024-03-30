package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;

public class Day17_iFrame extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_CODESTAR);
	}

	public void findIFrame_Index() throws InterruptedException
	{
		Thread.sleep(10000);
		int totalIFrame = driver.findElements(By.tagName("iframe")).size();
		for (int i = 0; i < totalIFrame; i++)
		{
			driver.switchTo().frame(i);
			//tìm phần tử đại diện trên iFrame cần test là button có text = Gửi ngay
			int soLuongPhanTuDaiDien = driver.findElements(By.xpath("//button[text()='Gửi ngay']")).size();
			if(soLuongPhanTuDaiDien >0)
			{
				System.out.println("iFrame cần tìm ở vị trí thứ: "+(i+1));
			}
			driver.switchTo().defaultContent();
		}
	}
	@Test
	public void case_DangKyKhongThanhCong_ThieuEmail() throws InterruptedException
	{
		Thread.sleep(5000);
		scrollToElement(driver.findElement(By.xpath("//h2[contains(text(),'Đăng kí nhận')]")));
		driver.switchTo().frame(1);
		driver.findElement(By.id("account_phone")).sendKeys("0796687776");
		driver.findElement(By.xpath("//button[text()='Gửi ngay']")).click();
		Assert.assertTrue(driver.findElement(By.id("account_phone")).isDisplayed());
	}
}
