package test;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername("Admin");
		loginpage.enterPassword("admin123");
		loginpage.clickLogin();
		
		String pageTitle=driver.getTitle();
		System.out.println("Title of the page is "+pageTitle);
	}
}
		
		
		