package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.JobTitlePage;
import Pages.LoginPage;
import Pages.UserManagementPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class JobTitle extends TestBase {
	LoginPage loginPg = new LoginPage();
	HomePage homepg = new HomePage();
	UserManagementPage userMngPg = new UserManagementPage();
	JobTitlePage jobTitlePg = new JobTitlePage();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@When("Admin clicks on job dropdown")
	public void admin_clicks_on_job_dropdown() {
		jobTitlePg.jobClick();

	}

	@And("selects {string} in the dropdown")
	public void selects_job_titles(String dropdown) {
		jobTitlePg.selectFromJobDropDown(dropdown);

	}

	@Then("{string} screen is displayed")
	public void job_title_screen_is_displayed(String jobtitle) throws InterruptedException {
		WebElement jobTitlePage = driver.findElement(By.xpath("//h6[text()='" + jobtitle + "']"));
		Assert.assertEquals(jobTitlePage.getText(), jobtitle);

	}

	@When("user clicks on add button")
	public void user_clicks_on_add_button() {
		jobTitlePg.clickAddBtn();
	}

	@Then("{string} form is displayed")
	public void job_title_form_is_displayed(String title) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Add Job Title']")));
		WebElement addJobTitle = driver.findElement(By.xpath("//h6[text()='Add Job Title']"));
		Assert.assertEquals(addJobTitle.getText(), title);
	}

	@Then("^fills all the parameters (.*),(.*) and (.*)$")
	public void fills_all_the_parameters(String jobTitle, String jobDescription, String note) {
		jobTitlePg.enterJobTitle(jobTitle);
		jobTitlePg.enterJobDescription(jobDescription);
		jobTitlePg.enterNote(note);
	}

	@Then("^Check if title (.*) and descrption got added to the table$")
	public void job_title_gets_added_to_the_table(String jobTitle) {

			WebElement title = driver.findElement(By.xpath("//div[text()='" + jobTitle + "']/parent::div"));
			WebElement description = driver.findElement(By.xpath("//div[text()='" + jobTitle + "']/parent::div/following-sibling::div"));
		Assert.assertEquals(title.getText(), jobTitle);
		if (description.getText()!="")
		{
			System.out.println("job Description Added");
		}
		else
		{
			System.out.println("job Description not added");
		}

	}
	@When ("Admin clicks on edit icon for job title {string}")
	public void click_edit_icon(String username) {
		jobTitlePg.clickEditForUsername(username);
		   
	}

	@Then("{string} form displays")
	public void edit_job_title_form_is_displayed(String editjobtitle) {
		WebElement editJobTitle = driver.findElement(By.xpath("//h6[text()='"+editjobtitle+"']"));
		Assert.assertEquals(editJobTitle, editjobtitle);   
	}
	@When ("^Admin updates the parameters (.*), (.*) and (.*)$")
	public void editJobTitle(String jobTitle, String jobDescription, String note)
	{
		jobTitlePg.enterJobTitle(jobTitle);
		jobTitlePg.enterJobDescription(jobDescription);
		jobTitlePg.enterNote(note);
	}
	
	@Then("<updateJobTitle> gets added to the table")
	public void update_job_title_gets_added_to_the_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}
