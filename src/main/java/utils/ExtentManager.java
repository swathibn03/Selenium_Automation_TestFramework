package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	public static ExtentReports extent;

	public static ExtentReports getReport() {
		if (extent == null) {
			ExtentSparkReporter sparkreporter = new ExtentSparkReporter("test-output/extent.html");
			extent = new ExtentReports();
			extent.attachReporter(sparkreporter);
			
		}
		return extent;
	}

}
