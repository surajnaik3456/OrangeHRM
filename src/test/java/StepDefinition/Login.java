package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends TestBase {

	LoginPage loginpg = new LoginPage(driver);
	HomePage homepg = new HomePage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	@Given ("user is on login page")
	public void checkloginpg() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-logo']/img[1]")));
		loginpg.verifyLoginPage();
	}
	@When ("^user enters valid (.+) and (.+)$")
	public void validEmailPwd(String username,String password)
	{

		loginpg.enterUserName(username);
		loginpg.enterPassword(password);
	}
	@And ("click on Login button")
	public void clickLgnButton()
	{
		loginpg.clickLoginBtn();
	}
	@Then ("user should land on homepage")
	public void checkHomePg()
	{

		homepg.homePageVerify();
	}
	@When("^user enters invalid (.+) and valid (.+)$")
	public void userEntersInvalidUnAndValidPwd(String username, String password)
	{
		loginpg.enterUserName(username);
		loginpg.enterPassword(password);
	}

	@Then("the user should get an error message indicating Invalid Credentials")
	public void userShouldGetErrorMessage() 
	{
		loginpg.invalidError();
	}
	@When ("the user leaves both username and password fields empty")
	public void bothFieldEmpty()
	{
		System.out.println("Blank username and password fields");
	}
	@Then ("the user should get an error message indicating required fields")
	public void requiredFieldErr()
	{
		loginpg.blankFieldsEr();
	}
	@When ("user clicks on forgot your password link")
	public void clickForgotPwd()
	{
		loginpg.clickForgotPwd();
	}
	@Then ("Reset password page is displayed")
	public void resetPg()
	{
		loginpg.resetPgCheck();
	}
	@And ("Enter username in username text field")
	public void enterUserName()
	{
		loginpg.enterResetUserName();
	}
	@And ("click on Reset password button")
	public void clickReset()
	{
		loginpg.clickResetBtn();
	}
	@Then ("reset password link is sent via email")
	public void linkSentCheck()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Reset Password link sent successfully']")));
		loginpg.checkForConfirmation();
	}
	@Given ("the user is logged in")
	public void userLoggedIn()
	{
		loginpg.userLoggedIn();
		homepg.homePageVerify();
	}
	@When ("the user clicks on profile dropdown")
	public void userDropdownClick()
	{
		homepg.userDropDownClick();
	}
	@And ("clicks the logout")
	public void clickLogout()
	{
		homepg.logoutClick();
	}
	@Then ("the user should be logged out and redirected to the login page")
	public void checkLoginPage()
	{
		loginpg.verifyLoginPage();
	}
	
}
