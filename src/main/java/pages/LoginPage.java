package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By usernameTexBox = By
			.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input");
	private By passwordTextBox = By
			.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input");
	private By LoginButton = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTexBox).sendKeys("username");
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(LoginButton).click();
	}

}
