package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.ReportsPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class Reports extends TestBase {
	ReportsPage reportsPg = new ReportsPage();
	

	@When("Admin clicks on Reports in top bar")
	public void admin_clicks_on_reports_in_top_bar() {
		reportsPg.clickReports();
	}
	@Then ("{string} page is been displayed")
	public void employee_report_pg_displayed(String reportsPg )
	{
		WebElement reportsPage = driver.findElement(By.xpath("//h5[text()='Employee Reports']"));
		Assert.assertEquals("Employee report page is not displayed", reportsPage.getText(), reportsPg);
	}
	@And ("Click on add button in reports page")
	public void clickAddBtn()
	{
		reportsPg.clickAdd();
	}
	@Then ("{string} page is displayed successfully")
	public void add_reports_page_displayed(String addRpPage)
	{
		WebElement addReportsPage = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));
		Assert.assertEquals("Add reports page is not displayed", addReportsPage.getText(), addRpPage);
	}
		
	@Then("^Fill all the parameters (.*),(.*),(.*) and (.*)$")
	public void fill_all_the_parameters(String reportName, String selectionCriteria, String include, String displayFieldGroup) throws InterruptedException {
		reportsPg.enterReportName(reportName);
		reportsPg.selectCriteria(selectionCriteria);
		reportsPg.includeSelection(include);
		reportsPg.selectDisplayFieldGrp(displayFieldGroup);
		Thread.sleep(4000);
	}
	@Then("^Add display fields (.*), (.*) and (.*) to be displayed in reports$")
	public void add_display_field(String displayField1 , String displayField2, String displayField3) {
		reportsPg.selectDisplayFld(displayField1);
	}
	@Then("Click on plus icon")
	public void click_on_plus_icon() {
	    
	}
	@Then("Click on include header toggle button")
	public void click_on_include_header_toggle_button() {
	    
	}
	@Then("Report is generated for Employee Details Report")
	public void report_is_generated_for_employee_details_report() {
	    
	}




}
