package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.PracticePage;
import pages.PracticeTablePage;
import utils.ScreenshotUtil;

public class PracticeTest extends BaseTest {
	
	@Test
	public void clickPracticeLinkTest() throws InterruptedException{
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername("student");
		loginpage.enterPassword("Password123");
		extenttest=extentreports.createTest("Click Practice Link");
		PracticePage practicepage=new PracticePage(driver);
		
		practicepage.clickPracticeLink();
		Thread.sleep(3000);
		extenttest.info("Clicked Practice Link successfully.");
		extenttest.pass("Clicked Practice link and navigated to links page");
	}
	
	
	@Test(dependsOnMethods="clickPracticeLinkTest")
	public void clickTestTableLink() throws IOException, InterruptedException {
		
		extenttest=extentreports.createTest("Click Test Table Link");
		PracticePage practicepage=new PracticePage(driver);
		practicepage.clickTestTableLink();
		Thread.sleep(3000);
		
		String path=ScreenshotUtil.captureScreenshot(driver, "Click Test Table Link");
		extenttest.info("Clicked Test Table link successfully");
		extenttest.pass("Clicked Test Table link and navigated to table page").addScreenCaptureFromPath(path);
		Thread.sleep(3000);
		
	}
	
public void verifyJavaFilterTest() throws IOException, InterruptedException {
		
		extenttest=extentreports.createTest("Java Filter Test");
		
		PracticeTablePage practicetablepage=new PracticeTablePage(driver);
		Thread.sleep(3000);
		practicetablepage.selectJavaLanguage();
		System.out.println("Selected Java option");
		extenttest.info("Selected Java Radio button");
		
		String path=ScreenshotUtil.captureScreenshot(driver, "Java filter applied");
		extenttest.pass("Filter applied").addScreenCaptureFromPath(path);
		
		boolean result=practicetablepage.verifyJavaFilter();
		Assert.assertTrue(result,"Jav filter is not working properly");
		System.out.println("Java filter working properly");
		
	}
	

}
