package automation.page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactory_HomeworkDay14 {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='btn-anis-effect' and text()='Đăng Ký']")
	WebElement btnDangKy;
	
	@FindBy(id = "txtFirstname")
	WebElement txtHoTen;
	
	@FindBy(id = "txtEmail")
	WebElement txtEmail;
	
	@FindBy(id = "txtCEmail")
	WebElement txtNhapLaiEmail;
	
	@FindBy(id ="txtPassword")
	WebElement txtPass;
	
	@FindBy(id = "txtCPassword")
	WebElement txtNhapLaiPass;
	
	@FindBy(id = "txtPhone")
	WebElement txtPhone;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	
	@FindBy(xpath = "//div[@class='avatar2']")
	WebElement btnImageAccount;

	@FindBy(xpath = "//a[text()='Chỉnh sửa thông tin']")
	WebElement btnEdit;
	
	@FindBy(id = "txtpassword")
	WebElement txtCurrentPass;
	
	@FindBy(id = "txtnewpass")
	WebElement txtNewPass;
	
	@FindBy(id = "txtrenewpass")
	WebElement txtReNewPass;
	
	@FindBy(xpath = "//button[text() = 'Lưu mật khẩu mới']")
	WebElement btnSaveNewPass;
	
	@FindBy(xpath = "//a[text()='Đăng Nhập']")
	WebElement btnLogin;
	
	@FindBy(id = "txtLoginUsername")
	WebElement txtLoginUsername;
	
	@FindBy(id ="txtLoginPassword")
	WebElement txtLoginPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit1;
	
	public PageFactory_HomeworkDay14(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void SigninFunction (String hoten, String email, String pass, String phone)
	{
		btnDangKy.click();
		txtHoTen.sendKeys(hoten);
		txtEmail.sendKeys(email);
		txtNhapLaiEmail.sendKeys(email);
		txtPass.sendKeys(pass);
		txtNhapLaiPass.sendKeys(pass);
		txtPhone.sendKeys(phone);
		btnSubmit.click();
	}
	public void EditPass (String password, String newpass) throws InterruptedException
	{
		btnImageAccount.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Chỉnh sửa thông tin']")));
		wait.until(ExpectedConditions.elementToBeClickable(btnEdit));
		btnEdit.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement webElement = driver.findElement(By.xpath("//label[text()='Giới tính']"));
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		Thread.sleep(1000);

		txtCurrentPass.sendKeys(password);
		txtNewPass.sendKeys(newpass);
		txtReNewPass.sendKeys(newpass);
		btnSaveNewPass.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	public void LoginFunction(String username, String password)
	{
		btnLogin.click();
		txtLoginUsername.sendKeys(username);
		txtLoginPass.sendKeys(password);
		btnSubmit1.click();
	}
}
