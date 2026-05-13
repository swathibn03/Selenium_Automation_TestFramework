package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	// Locators for Login page
	private By usernameTexBox = By.id("username");
	private By passwordTextBox = By.id("password");
	private By LoginButton = By.id("submit");
	
	//Locators for after succesfull login
	private By LogoutButton=By.linkText("Log out");
	
	//Locators in Practice Page
	private By PracticeLink=By.linkText("Practice");
	private By TextExceptionsLink=By.linkText("Test Exceptions");
	private By AddButton=By.id("add_btn");
	private By secondRow=By.xpath("//*[@id=\"row2\"]/input");

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(usernameTexBox).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(LoginButton).click();
	}
	
	public String SuccessfulLoginMessage()
	{
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(LogoutButton));
	  
	  String LogoutText=driver.findElement(LogoutButton).getText();
	  return LogoutText;
	}

	
	public void clickPracticeLink(){
		driver.findElement(PracticeLink).click();
		}
	
	public void clickTestExceptionsLink() {
		driver.findElement(TextExceptionsLink).click();
		
	}
	
	public void clickAddButton() {
		driver.findElement(AddButton).click();
		
	}
	
	public boolean isRowDisplayed() {
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(secondRow));
		return element.isDisplayed();
		
	}
	
}
