package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	public static By TEXTBOX_EMAIL = By.id("email");
	public static By TEXTBOX_PASS = By.id("password");
	public static By BTN_SIGNIN = By.xpath("//button[text()='Sign in']");
	
	public static By TEXT_DASHBOARD = By.xpath("//span[text()='Dashboard']");
	public static By AUTHEN_ERROR = By.xpath("//div[normalize-space()='Authentication failed!']");
	public static By EMAIL_FORMAT_ERROR = By.xpath("//span[text()='Please enter a valid email address.']");
}
