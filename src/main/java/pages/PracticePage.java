package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePage {

	private WebDriver driver;
	private By practiceLink = By.xpath("//a[text()='Practice']");
	private By TestTableLink=By.linkText("Test Table");
	
	public PracticePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPracticeLink() {
		driver.findElement(practiceLink).click();
	}
	
	public void clickTestTableLink() {
		driver.findElement(TestTableLink).click();
	}
}
