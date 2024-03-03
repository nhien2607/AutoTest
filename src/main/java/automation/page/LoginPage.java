package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_Account;

public class LoginPage {
	private WebDriver driver;
	public LoginPage(WebDriver commonDriver) {
		this.driver = commonDriver;
	}
	public void LoginFunction(String email, String pass)
	{
		WebElement textEmail =  driver.findElement(CT_Account.TEXTBOX_EMAIL);
		if (textEmail.isDisplayed())
		{
			textEmail.clear();
			textEmail.sendKeys(email);
		}
		WebElement textPass =  driver.findElement(CT_Account.TEXTBOX_PASS);
		if (textPass.isDisplayed())
		{
			textPass.clear();
			textPass.sendKeys(pass);
		}
		WebElement btnSignin =  driver.findElement(CT_Account.BTN_SIGNIN);
		if (btnSignin.isDisplayed())
		{
			btnSignin.click();
			
		}
	}
}
