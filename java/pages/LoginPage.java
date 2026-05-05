package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By usernameTexBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By LoginButton = By.id("submit");

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
