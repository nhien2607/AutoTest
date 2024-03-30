package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void scrollToElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	private WebDriver initChromeDriver()
	{
		System.out.println("Launching chrome browser...");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		return driver;
	}
	private WebDriver initFirefoxDriver()
	{
		System.out.println("Launching firefox browser...");
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		return driver;
	}
	private WebDriver initMsEdgeDriver()
	{
		System.out.println("Launching MSEdge browser...");
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		// Đợi trong vòng 30 giây cho tới khi trang web load thành công
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}
	public WebDriver setupDriver(String browserName)
	{
		switch(browserName.trim().toLowerCase()) {
		case "chrome": 
			driver = initChromeDriver();
			break;
		case "firefox": 
			driver = initFirefoxDriver();
			break;
		case "edge": 
			driver = initMsEdgeDriver();
			break;
		default:
			System.out.println("Browser "+ browserName + "was incorrect, run default chrome browser");
			driver = initChromeDriver();
		}
		return driver;
	}
	
	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
		return driver.findElement(locator);
	}
	public void click(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void type(By locator, String value)
	{
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}
}
