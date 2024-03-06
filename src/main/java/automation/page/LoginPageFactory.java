package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPageFactory {
	private WebDriver driver;
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id ="password")
	WebElement txtPass;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement btnSignin;

	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginFunction (String email, String pass)
	{
		txtEmail.clear();
		txtEmail.sendKeys(email);
		txtPass.clear();
		txtPass.sendKeys(pass);
		btnSignin.click();
	}
}
