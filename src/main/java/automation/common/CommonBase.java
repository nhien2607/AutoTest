package automation.common;

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
		Thread.sleep(1000);
		driver.get(URL);
		return driver;
	}

}
