package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.PracticeTablePage;
import utils.ScreenshotUtil;

public class PracticeTableTest extends BaseTest{
	
	@Test
	public void verifyJavaFilterTest() throws IOException {
		
		extenttest=extentreports.createTest("Java Filter Test");
		
		PracticeTablePage practicetablepage=new PracticeTablePage(driver);
		practicetablepage.selectJavaLanguage();
		
		String path=ScreenshotUtil.captureScreenshot(driver, "Java filter applied");
		extenttest.pass("Filter applied").addScreenCaptureFromPath(path);
		
		boolean result=practicetablepage.verifyJavaFilter();
		Assert.assertTrue(result,"Jav filter is not working properly");
		System.out.println("Java filter working properly");
		
	}

}
