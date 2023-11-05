package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestBase.TestBase;

public class LoginPage extends TestBase {
	WebDriver driver;
	By logo = By.xpath("//div[@class='orangehrm-login-logo']/img[1]");
	By userNameField = By.name("username");
	By passwordField = By.name("password");
	By loginClick = By.xpath("//button[@type='submit']");
	By errorMsg = By.xpath("//div[@class='orangehrm-login-error']/div[1]/div[1]");
	By blankFieldErr = By.xpath("//*[text()='Required'][1]");
	By forgotPwdClick = By.xpath("//*[text()='Forgot your password? ']");
	By resetPg = By.xpath("//h6");
	By resetUserName = By.xpath("//input[@name='username']");
	By clickReset = By.xpath("//button[text()=' Reset Password ']");
	By confirmation = By.xpath("//*[text()='Reset Password link sent successfully']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void verifyLoginPage()
	{
		driver.findElement(logo).isDisplayed();
	}
	public void enterUserName(String username)
	{
		driver.findElement(userNameField).sendKeys(username);
	}
	public void enterPassword(String password)
	{
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLoginBtn()
	{
		driver.findElement(loginClick).click();
	}
	public void invalidError()
	{
		driver.findElement(errorMsg).isDisplayed();
	}
	public void blankFieldsEr()
	{
		driver.findElement(blankFieldErr).isDisplayed();
	}
	public void clickForgotPwd()
	{
		driver.findElement(forgotPwdClick).click();
	}
	public void resetPgCheck()
	{
		driver.findElement(resetPg).isDisplayed();
	}
	public void enterResetUserName()
	{
		driver.findElement(resetUserName).sendKeys("Admin");
	}
	public void clickResetBtn()
	{
		driver.findElement(clickReset).click();
	}
	public void checkForConfirmation()
	{
		driver.findElement(confirmation).isDisplayed();
	}
	public void userLoggedIn()
	{
		driver.findElement(userNameField).sendKeys("Admin");
		driver.findElement(passwordField).sendKeys("admin123");
		driver.findElement(loginClick).click();
		
	}
	
}
