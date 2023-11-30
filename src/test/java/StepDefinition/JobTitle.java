package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
		WebElement description = driver
				.findElement(By.xpath("//div[text()='" + jobTitle + "']/parent::div/following-sibling::div"));
		Assert.assertEquals(title.getText(), jobTitle);
		if (description.getText() != "") {
			System.out.println("job Description Added");
		} else {
			System.out.println("job Description not added");
		}

	}

	@When("Admin clicks on edit icon for job title {string}")
	public void click_edit_icon(String username) {
		jobTitlePg.clickEditForUsername(username);

	}

	@Then("{string} form displays")
	public void edit_job_title_form_is_displayed(String editjobtitle) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Edit Job Title']")));
		WebElement editJobTitle = driver.findElement(By.xpath("//h6[text()='" + editjobtitle + "']"));
		Assert.assertEquals(editJobTitle.getText(), editjobtitle);
	}

	@When("^Admin updates (.*),(.*) and (.*)$")
	public void editJobTitle(String jobTitle, String jobDescription, String note) {
		jobTitlePg.updateJobTitle(jobTitle);
		jobTitlePg.enterJobDescription(jobDescription);
		jobTitlePg.enterNote(note);
	}

	@And("Clicks on save button")
	public void clickSaveButton() {
		jobTitlePg.clickSaveBtn();
		
	}

	@And("^(.*) gets added to the table$")
	public void update_job_title_gets_added_to_the_table(String updatedTitle) {
		WebElement title = driver.findElement(By.xpath("//div[text()='" + updatedTitle + "']/parent::div"));
		Assert.assertEquals(title.getText(), updatedTitle);
	}
	@When("^Admin clicks on delete icon for the (.*)$")
	  public void click_delete_for_job_title(String deletejobtitle) {
	    driver.findElement(By.xpath("//div[text()='" + deletejobtitle + "']/parent::div/following::button[1]")).click();
	  }

	  @Then("^user with (.*) job title gets deleted and is not in the table$")
	  public void user_with_account_assistant_gets_deleted(String jobtitle) {
	    try {
	      driver.findElement(By.xpath("//div[text()='" + jobtitle + "']/parent::div"));
	    } catch (NoSuchElementException e) {
	      System.out.println("Job title with '" + jobtitle + "' is not present (as expected)");
	    }

	  }

}
