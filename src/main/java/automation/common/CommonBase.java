package automation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonBase {
	public WebDriver driver;
//khởi tạo driver cho chrome để bật 1 url
	public WebDriver initChromeDriver(String URL) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		return driver;
	}

}
