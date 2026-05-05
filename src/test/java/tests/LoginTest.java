package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	
	public void testValidLogin() throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername("student");
		Thread.sleep(3000);
		loginpage.enterPassword("Password123");
		Thread.sleep(3000);
		loginpage.clickLogin();
		Thread.sleep(3000);
		
		String pageTitle=driver.getTitle();
		System.out.println("Title of the page is "+pageTitle);
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		Thread.sleep(3000);
		
//		String successMessage=loginpage.SuccessfulLoginMessage();
//		String title=driver.getTitle();
//		System.out.println("Page after login"+title);
//		
//		Assert.assertTrue(successMessage.contains("Logged In Successfully"),"Success message not displayed!");
	
		
	}
	
	@Test(dependsOnMethods="testValidLogin")
	public void VerifySuccessfulLoginMessage() throws InterruptedException
	{
		LoginPage loginpage=new LoginPage(driver);
		Thread.sleep(3000);
		
		String successMessage=loginpage.SuccessfulLoginMessage();
		String title=driver.getTitle();
		System.out.println("Page after login"+title);
		System.out.println(successMessage);
		
		Assert.assertTrue(successMessage.contains("Log out"),"Success message not displayed!");
}
}
		
		
		