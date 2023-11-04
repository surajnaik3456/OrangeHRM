package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;

public class UserManagement extends TestBase{
	LoginPage loginpg = new LoginPage(driver);
	HomePage homepg = new HomePage(driver);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	@Given ("the user is on homepage")
	public void userOnHomepage()
	{
		loginpg.verifyLoginPage();
		loginpg.userLoggedIn();
		homepg.homePageVerify();
	}
	@And ("clicks on Admin in sidepanel")
    public void clickAdmin() throws InterruptedException
	{
		Thread.sleep(2000);
		homepg.adminClick();
	}
	@Then ("User Management section is displayed")
	public void adminSection()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[1]/div[1]/span[1]")));
		homepg.adminSectionDisplayed();
	}
	@And ("the user makes a note of the total number of records for the users")
	public void totalCount()
	{
	System.out.println("\nTotal count : " +homepg.totalRecordsDisplayed());
	}
    @When ("^user search with search parameters for (.+), (.+), (.+) and (.+)$")
    public void enterParameters(String username,String user_role, String employee_name, String status) throws InterruptedException 
	{
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")));
		homepg.userParameters(username, user_role, employee_name, status);
	}
    @And ("clicks on Search button")
    public void clickSearch()
	{
		homepg.clickSearchBtn();
	}
    @Then ("^the searched user is displayed with the (.+)$")
    public void userDisplayed(String message)
	{
		homepg.searchedUserDisplayed(message);
	}
    
    @When ("the user clicks on Reset button")
    public void resetClick()
    {
    	homepg.resetClick();
    }
    @Then ("the search parameters values should be cleared")
    public void searchParametersCleared()
    {
    	WebElement searchField = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        String fieldValue = searchField.getAttribute("value");
        if (fieldValue.isEmpty()) {
            System.out.println("The field is empty.");
        } else {
            System.out.println("The field is not empty.");
        }
    }
    @And ("All the records should be displayed")
    public void displayAllRecords()
    {
    	homepg.totalRecordsDisplayed();
    }
   
	

}
