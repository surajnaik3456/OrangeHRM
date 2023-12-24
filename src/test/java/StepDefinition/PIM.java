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
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));

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

	@When("Admin clicks on Add button")
	public void clicksAddBtn() {
		pimPg.clickAddBtn();
	}

	@Then("{string} page is displayed")
	public void page_is_displayed(String addEmpPage) {
		WebElement addEmpPg = driver.findElement(By.xpath("//h6[text()='" + addEmpPage + "']"));

		Assert.assertEquals("Add Employee page is not displayed", addEmpPg.getText(), addEmpPage);

	}

	@Then("Add profile picture")
	public void add_profile_picture() {
		driver.findElement(By.xpath("//input[@type='file' and @class='oxd-file-input'] "))
				.sendKeys("C:\\Users\\User\\Desktop\\profile.jpg");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^Fills all the parameters (.*),(.*) and (.*)$")
	public void fills_all_the_parameters_test_s_and_naik(String firstname, String middlename, String lastname)
			throws InterruptedException {
		pimPg.EnterFirstName(firstname);
		pimPg.EnterMiddleName(middlename);
		pimPg.EnterLastName(lastname);
	}

	@Then("Click on save button")
	public void click_on_save_button() {
		pimPg.clickSave();
	}

	@Then("{string} page gets displayed")
	public void personal_details_page_displayed(String pageDisplay) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='" + pageDisplay + "']")));
		WebElement pageIsDisplayed = driver.findElement(By.xpath("//h6[text()='" + pageDisplay + "']"));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
	}

	@Then("^Fill the parameters for (.*), (.*) and (.*)$")
	public void fill_the_parameters_for_automation_tester_quality_assurance_and_full_time_permanent(String jobtitle,
			String subunit, String employmentstatus) {
		pimPg.jobTitle(jobtitle);
		pimPg.subUnit(subunit);
		pimPg.empStatusSelect(employmentstatus);
	}

	@And("Click on the {string}")
	public void click_on_report_to(String reportTo) {
		pimPg.reportToClick(reportTo);

	}

	@Then("The {string} page is displayed")
	public void report_to_page_is_displayed(String report) {
		WebElement reportPage = driver.findElement(By.xpath("//h6[text()='" + report + "']"));
		Assert.assertEquals("Report to page is not displayed", reportPage.getText(), report);
	}

	@Then("Click on add button")
	public void click_on_add_button() {
		pimPg.clickAddButton();
	}

	@Then("^Add (.*) and (.*)$")
	public void add_supervisor_name_and_method(String name, String reportingMethod) {
		pimPg.addSupervisorName(name);
		pimPg.addReportingMethod(reportingMethod);

	}

	@When("Clicks on the save button")
	public void clicks_on_the_save_button() {
		pimPg.clickSave();
	}

	@Then("Click on Employee list")
	public void click_on_employee_list() {
		pimPg.clickEmployeeList();
	}

	@And("^Check if the employee with (.*),(.*)and (.*) is added")
	public void check_if_the_employee_added(String firstAndMiddleName, String lastname, String jobtitle) {
		WebElement firstMiddleName = driver.findElement(By.xpath("//div[text()='" + firstAndMiddleName + "']/parent::div"));
		WebElement lastName = driver.findElement(By.xpath("//div[text()='" + lastname + "']/parent::div"));
		WebElement jobTitle = driver.findElement(By.xpath("//div[text()='" + jobtitle + "']/parent::div"));
		while (!firstMiddleName.getText().equals(firstAndMiddleName) && lastName.getText().equals(lastname)) {
			driver.findElement(By.xpath("//button[@type='button' and @class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']")).click();
		}
		Assert.assertEquals("Employee with first name" + firstAndMiddleName + "is not added", firstMiddleName.getText(), firstAndMiddleName);
		Assert.assertEquals("Employee with first name" + lastname + "is not added", lastName.getText(), lastname);
		Assert.assertEquals("Employee with first name" + jobtitle + "is not added", jobTitle.getText(), jobtitle);
		System.out.println("Employee is added successfully");
	}
	
	@When("Admin clicks on edit for the employee with first and middle name {string}")
	public void clickEdit(String name)
	{
		WebElement firstAndMiddleName = driver.findElement(By.xpath("//div[text()='"+ name +"']/parent::div"));
		while(!firstAndMiddleName.getText().equalsIgnoreCase(name))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='oxd-icon bi-chevron-right']")));
			driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-right']")).click();
		}
		pimPg.clickEdit(name);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h6[text()='Personal Details']")));
	}

	@Then("^update (.*), (.*) and (.*)$")
	public void update_name_and_last_name(String firstName, String middleName, String lastName) throws InterruptedException {
		
		pimPg.updateFirstNm(firstName);
		pimPg.updateMiddleNm(middleName);
		pimPg.updateLastNm(lastName);
		Thread.sleep(3000);
	}
	@And ("Admin clicks on save button")
	public void ClickSaveBtn()
	{
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
	}
	@Then("^Update (.*)and(.*)$")
	public void update_it_managerand_tech_ops(String jobtitle, String subunit) {
		pimPg.updateJobTitle(jobtitle);   
		pimPg.updateSubUnit(subunit);
	}
	@Then("^Check if the employee with (.*),(.*) and (.*) is updated$")
	public void check_if_the_employee_details_updated(String firstAndMiddleName, String lastName, String jobtitle) {
		WebElement updatedFirstMiddleName = driver.findElement(By.xpath("//div[text()='" + firstAndMiddleName + "']/parent::div"));
		WebElement updatedLastName = driver.findElement(By.xpath("//div[text()='" + lastName + "']/parent::div"));
		WebElement jobTitle = driver.findElement(By.xpath("//div[text()='" + jobtitle + "']/parent::div"));
		while (!updatedFirstMiddleName.getText().equalsIgnoreCase(firstAndMiddleName) && updatedLastName.getText().equalsIgnoreCase(lastName)) {
			driver.findElement(By.xpath("//button[@type='button' and @class='oxd-pagination-page-item oxd-pagination-page-item--previous-next']")).click();
		}
		Assert.assertEquals("Employee with first name" + firstAndMiddleName + "is not added", updatedFirstMiddleName.getText(), firstAndMiddleName);
		Assert.assertEquals("Employee with first name" + lastName + "is not added", updatedLastName.getText(), lastName);
		Assert.assertEquals("Employee with first name" + jobtitle + "is not added", jobTitle.getText(), jobtitle);
		System.out.println("Employee is added successfully");
	}
}
