package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test

	public void testValidLogin() throws InterruptedException, IOException {
		LoginPage loginpage = new LoginPage(driver);

		extenttest = extentreports.createTest("LoginTest");

		extenttest.info("Entering credentials");
		loginpage.enterUsername("student");
		Thread.sleep(3000);
		loginpage.enterPassword("Password123");
		Thread.sleep(3000);
		loginpage.clickLogin();
		Thread.sleep(3000);

		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is " + pageTitle);
		Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");
		Thread.sleep(3000);
		
		String path=ScreenshotUtil.captureScreenshot(driver, "LoginTest");
		extenttest.pass("Login successfull").addScreenCaptureFromPath(path);

		extenttest.pass("Successfully logged in and navigated to the right page");
		extenttest.info("Browser closed");

	}

	@Test(dependsOnMethods = "testValidLogin")

	public void VerifySuccessfulLoginMessage() throws InterruptedException {
		LoginPage loginpage2 = new LoginPage(driver);
		Thread.sleep(3000);

		String successMessage = loginpage2.SuccessfulLoginMessage();
		String title = driver.getTitle();
		System.out.println("Page after login " + title);
		System.out.println(successMessage);

		Assert.assertTrue(successMessage.contains("Log out"), "Success message not displayed!");
	}

//	@Test
//	
//	
//	public void AddItemExceptionTest() throws InterruptedException {
//		LoginPage loginpage2 = new LoginPage(driver);
//		
//		loginpage2.clickPracticeLink();
//		Thread.sleep(3000);
//		
//		loginpage2.clickTestExceptionsLink();
//		Thread.sleep(3000);
//		
//		loginpage2.clickAddButton();
//		Thread.sleep(3000);
//		
//		Assert.assertEquals(loginpage2.isRowDisplayed(),"Row is not displayed");
//		
//	}
}
