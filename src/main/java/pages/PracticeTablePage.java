package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticeTablePage {

	WebDriver driver;

	public PracticeTablePage(WebDriver driver) {
		this.driver = driver;
	}

	By languageButton = By.xpath("//input[@type='radio' and @value='Java']");
	By table = By.xpath("//table/tbody");
	By tableRows = By.xpath("//table/tbody/tr");

	public void selectJavaLanguage() {
		WebElement javaRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='Java']"));
		String RadioButtonOption = javaRadio.getAttribute("value");
		System.out.println("Selected radio button is " + RadioButtonOption);
		driver.findElement(languageButton).click();
	}

	public boolean verifyJavaFilter() {
		List<WebElement> rows = driver.findElements(tableRows);
		for (WebElement row : rows) {
			String rowText = row.getText().trim();
			if (!rowText.isEmpty()) {
				System.out.println("Row text is " + rowText);
				if (!rowText.contains("Java")) {
					return false;
				}

			}
		}
		return true;

	}

}
