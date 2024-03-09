package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactory_HomeworkDay15 {
	private WebDriver driver;
	@FindBy(xpath = "//a[@id='one-way-tab']")
	WebElement checkOneWay;
	@FindBy(xpath = "(//label[text()='Flying from']//following::input)[1]")
	WebElement textFlyingFrom;
	@FindBy(xpath = "(//label[text()='Flying to']//following::input)[1]")
	WebElement textFlyingTo;
	@FindBy(xpath = "(//label[text()='Departing']/following-sibling::div/input[@name='daterange-single'])[1]")
	WebElement dropdownDeparture;
	@FindBy(xpath = "//a[@class='dropdown-toggle dropdown-btn']")
	WebElement dropdownPassengers;
	@FindBy(xpath = "(//input[@name='adult_number']//following-sibling::div/i[@class='la la-plus'])[1]")
	WebElement buttonPlusAdult;
	@FindBy(xpath = "(//a[text()='Search Now'])[1]")
	WebElement buttonSearchNow;
	public PageFactory_HomeworkDay15(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void SearchFunction(String from, String to, String departing)
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('one-way-tab').checked=false;");
		textFlyingFrom.sendKeys(from);
		textFlyingTo.sendKeys(to);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",dropdownDeparture);
		dropdownDeparture.sendKeys("02092024");
		dropdownDeparture.sendKeys(Keys.TAB);
		js.executeScript("arguments[0].click();", dropdownPassengers);
		js.executeScript("arguments[0].click();", buttonPlusAdult);
		js.executeScript("arguments[0].click();", buttonSearchNow);

	}
	
}
