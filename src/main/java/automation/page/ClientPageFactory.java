package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientMenu;
	@FindBy(xpath = "//a[text()=' Add client']")
	WebElement btnAddClient;
	@FindBy(id = "type_person")
	WebElement radioPerson;
	@FindBy(id = "company_name")
	WebElement textBoxCompany;
	@FindBy(id = "disable_online_payment")
	WebElement checkboxOnlinePayment;
	@FindBy(xpath = "//button[text()=' Save']") 
	WebElement buttonSave;
	@FindBy(xpath = "//a[text()='Clients']")
	WebElement clientTab;
	@FindBy(xpath = "//div[@id='client-table_filter']//input[@placeholder='Search']" )
	WebElement textBoxSearch;
	
	private WebDriver driver;
	public ClientPageFactory(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void AddClient (String company) throws InterruptedException
	{
		clientMenu.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnAddClient);
		Thread.sleep(3000);
		radioPerson.click();
		textBoxCompany.sendKeys(company);
		if(checkboxOnlinePayment.isDisplayed()== true && checkboxOnlinePayment.isSelected() == false)
		{
			checkboxOnlinePayment.click();
		}
		buttonSave.click();
		Thread.sleep(3000);
		clientTab.click();
		Thread.sleep(3000);
		textBoxSearch.sendKeys(company);
		
	}
	
	
}
