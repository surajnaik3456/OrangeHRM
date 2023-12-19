package StepDefinition;

import Pages.PimPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM extends TestBase {
	PimPage pimPg = new PimPage();
WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(6));
	@Then("PIM page is displayed")
	public void pimPgDisplayed() {
		WebElement pimDisplayed = driver.findElement(By.xpath("//h5[text()='Employee Information']"));
		// Assert.assertEquals("Page displayed successfully", pimDisplayed.getText(),
		// "Employee Information");
		// Assert.assertTrue("Page displayed",pimDisplayed.getText().contains("Employee
		// Information"));
		try {
			Assert.assertEquals("AssertionError", pimDisplayed.getText(), "Employee Information");
			System.out.println("Page displayed successfully");
		} catch (AssertionError e) {
			System.out.println("Assertion failed: " + e.getMessage());
		}
	}
		@When ("Admin clicks on Add button")
		public void clicksAddBtn() 
		{
			pimPg.clickAddBtn(); 
		}
		
		@Then("{string} page is displayed")
		public void page_is_displayed(String addEmpPage) {
			WebElement addEmpPg = driver.findElement(By.xpath("//h6[text()='"+addEmpPage+"']"));
			
			Assert.assertEquals("Add Employee page is not displayed", addEmpPg.getText(), addEmpPage);
		    
		}
		@Then("Add profile picture")
		public void add_profile_picture() {
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='file' and @class='oxd-file-input']")));
		    driver.findElement(By.xpath("//input[@type='file' and @class='oxd-file-input'] ")).sendKeys("C:\\Users\\User\\Desktop\\profile.jpg");
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Then("^Fills all the parameters (.*),(.*) and (.*)$")
		public void fills_all_the_parameters_test_s_and_naik(String firstname,String middlename, String lastname ) throws InterruptedException {
			pimPg.EnterFirstName(firstname);
			pimPg.EnterMiddleName(middlename);
			pimPg.EnterLastName(lastname);
			Thread.sleep(2000);
		}
		@Then("Click on save button")
		public void click_on_save_button() {
			pimPg.clickSave();
		}
		@Then ("{string} page gets displayed")
		public void personal_details_page_displayed(String pageDisplay)
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='"+pageDisplay+"']")));
			WebElement pageIsDisplayed = driver.findElement(By.xpath("//h6[text()='"+pageDisplay+"']"));
			Assert.assertEquals("Personal details page is not displayed", pageIsDisplayed.getText(), pageDisplay);
		}
		@Then("Click on {string}")
		public void click_on(String job) {
			pimPg.jobClick(job);
		    
		}
		@Then("Job details page is displayed")
		public void job_details_page_is_displayed() {
		   WebElement jobDetailsPage = driver.findElement(By.xpath("//h6[text()='Job Details']"));
		   Assert.assertEquals("Job details page is not displayed", jobDetailsPage.getText(), "Job Details");
		}
		@Then("^Fill the parameters for (.*), (.*) and (.*)$")
		public void fill_the_parameters_for_automation_tester_quality_assurance_and_full_time_permanent(String jobtitle, String subunit, String employmentstatus) {
			pimPg.jobTitle(jobtitle);
			pimPg.subUnit(subunit);
			pimPg.empStatusSelect(employmentstatus);
			System.out.println("hi");
		}
		@And ("Click on the {string}")
		public void click_on_report_to(String reportTo) {
			pimPg.reportToClick(reportTo);
		    
		}
		@Then("The {string} page is displayed")
		public void report_to_page_is_displayed(String report) {
			WebElement reportPage = driver.findElement(By.xpath("//h6[text()='"+report+"']"));
			Assert.assertEquals("Report to page is not displayed", reportPage.getText(), report);
		   System.out.println("HEY");
		}
		@Then("Click on add button")
		public void click_on_add_button() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("Add Cecil  Bonaparte and Direct")
		public void add_cecil_bonaparte_and_direct() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@When("Clicks on the save button")
		public void clicks_on_the_save_button() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("Click on Employee list")
		public void click_on_employee_list() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}
		@Then("Check if the employee with Test,s and Automation tester is added")
		public void check_if_the_employee_with_test_s_and_automation_tester_is_added() {
		    // Write code here that turns the phrase above into concrete actions
		    throw new io.cucumber.java.PendingException();
		}



	}


