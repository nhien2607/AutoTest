package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Common;
import automation.page.ClientPageFactory;
import automation.page.LoginPageFactory;
import automation.page.PageFinalProject;

public class FinalProject extends CommonBase{
	@BeforeMethod
	public void openChrome() throws InterruptedException {
		driver = initChromeDriver(CT_Common.URL_Rise);
	}
	@Test
	public void addProjectSuccessfully() throws InterruptedException
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		
		PageFinalProject project = new PageFinalProject(driver);
		project.addProject("Testing", "abcd", "01042024", "05042024", "1000");
		
		Assert.assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Testing']")).isDisplayed());
	}
	@Test
	public void editProjectSuccessfully() throws InterruptedException
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		
		PageFinalProject project = new PageFinalProject(driver);
		project.addProject("Testing", "abcd", "01042024", "05042024", "1000");
		
		PageFinalProject project1 = new PageFinalProject(driver);
		project1.editProject("Testing", "Testing123", "02042024", "06042024", "2000");
		
		Assert.assertTrue(driver.findElement(By.xpath("//td/child::a[text()='Testing123']")).isDisplayed());
	}
	@Test
	public void deleteProjectSuccessfully() throws InterruptedException
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		
		PageFinalProject project = new PageFinalProject(driver);
		project.addProject("Testing456", "abcdef", "01042024", "05042024", "1000");
		
		PageFinalProject project2 = new PageFinalProject(driver);
		project2.deleteProject("Testing456");
		
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='No record found.']")).isDisplayed());
	}
	
}
