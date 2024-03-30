package automation.page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automation.common.CommonBase;

public class PageFinalProject extends CommonBase {
	@FindBy(xpath = "//span[text()='Projects']")
	WebElement projectMenu;
	@FindBy(xpath = "//a[@title='Add project']")
	WebElement btnAddProject;
	@FindBy(xpath = "//input[@id='title']")
	WebElement txtTitle;
	@FindBy(xpath = "//span[text()='Demo Client']")
	WebElement dropdownClient;
	@FindBy(xpath = "(//ul[@class='select2-results'])[5]//li[2]")
	WebElement clientOption;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement txtDescription;
	@FindBy(id = "start_date")
	WebElement startdate;
	@FindBy(id = "deadline")
	WebElement txtdeadline;
	@FindBy(id = "price")
	WebElement txtprice;
	@FindBy(xpath = "//li[@class='select2-search-field']//input")
	WebElement label;
	@FindBy(id = "save-and-continue-button")
	WebElement btnSaveAndContinue;
	@FindBy(xpath = "//span[text()='Mark Thomas']")
	WebElement dropdownMember;
	@FindBy(xpath = "(//ul[@class='select2-results'])[5]//li[3]")
	WebElement memberOption;
	@FindBy(xpath = "//button[text()=' Close']")
	WebElement btnClose;
	@FindBy(xpath = "//input[@type='search']")
	WebElement textBoxSearch;
	@FindBy(xpath = "(//td/child::a[@title='Edit project'])[1]")
	WebElement btnEdit;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement btnSave;
	@FindBy(xpath = "(//td/child::a[@title='Delete project'])[1]")
	WebElement btnDelete;
	@FindBy(id = "confirmDeleteButton")
	WebElement btnConfirmDelete;

	private WebDriver driver;
	public PageFinalProject(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void addProject(String title, String description, String startDate, String deadline, String price) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		projectMenu.click();
		btnAddProject.click();
		Thread.sleep(3000);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",txtTitle);
		txtTitle.sendKeys(title);
		
		dropdownClient.click();
		clientOption.click();
		txtDescription.sendKeys(description);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",startdate);
		startdate.clear();
		startdate.sendKeys(startDate);
		startdate.sendKeys(Keys.TAB);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",txtdeadline);
		txtdeadline.clear();
		txtdeadline.sendKeys(deadline);
		txtdeadline.sendKeys(Keys.TAB);
		txtprice.sendKeys(price);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",label);
		label.sendKeys("Urgent");
		label.sendKeys(Keys.TAB);
		btnSaveAndContinue.click();
		Thread.sleep(3000);
		dropdownMember.click();
		Thread.sleep(3000);
		memberOption.click();
		btnClose.click();
		
		textBoxSearch.sendKeys(title);
	}
	public void editProject(String title, String titleEdit, String startDateEdit, String deadlineEdit, String priceEdit) throws InterruptedException
	{
		projectMenu.click();
		textBoxSearch.sendKeys(title);
		Thread.sleep(3000);
		btnEdit.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",txtTitle);
		txtTitle.clear();
		txtTitle.sendKeys(titleEdit);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",startdate);
		startdate.clear();
		startdate.sendKeys(startDateEdit);
		startdate.sendKeys(Keys.TAB);
		js.executeScript( "arguments[0].removeAttribute('readonly','readonly')",txtdeadline);
		txtdeadline.clear();
		txtdeadline.sendKeys(deadlineEdit);
		txtdeadline.sendKeys(Keys.TAB);
		txtprice.sendKeys(priceEdit);
		btnSave.click();
	}
	public void deleteProject(String title) throws InterruptedException
	{
		projectMenu.click();
		textBoxSearch.sendKeys(title);
		Thread.sleep(3000);
		btnDelete.click();
		Thread.sleep(3000);
		btnConfirmDelete.click();
		Thread.sleep(3000);
	}
}
