package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;


public class BaseTest {

	protected WebDriver driver;
	protected ExtentReports extentreports;
	protected ExtentTest extenttest;


	@BeforeClass

	public void setUp() {
		extentreports = ExtentManager.getReport();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
//		if(extentreports==null) {
//			ExtentManager.getReport();
//		}

	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.close();
			extentreports.flush();
		}
	}
}
