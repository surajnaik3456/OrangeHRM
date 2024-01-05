package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.PayGradesPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;

public class PayGrade extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PayGradesPage payGradePg = new PayGradesPage();
	
	@And ("^Admin enters (.*)$")
	public void enterPayGradeName(String paygradename)
	{
		payGradePg.enterpayGradeName(paygradename);
	}
	@And ("The {string} page is displayed successfully")
	public void editPayGradePg(String payGradePg)
	{
		WebElement payGradePgDisplay = driver.findElement(By.xpath("//h6[text()='"+payGradePg+"']"));
		Assert.assertEquals("Paygrade page is not displayed", payGradePgDisplay.getText(), payGradePg);
	}
    @Then ("{string} section shows up")
    public void addCurrencySection(String addCurrency)
	{
		WebElement addCurrencySecDisplay = driver.findElement(By.xpath("//h6[text()='"+addCurrency+"']"));
		Assert.assertEquals("Add currency is not displayed", addCurrencySecDisplay.getText(), addCurrency);
	}
	@When("^Admin adds parameters in add currency section (.+),(.+) and (.+)$")
	public void admin_adds_parameters_in_add_currency_section(String currency, String minimumsalary, String maximumsalary) {
		payGradePg.addCurrency(currency);
		payGradePg.addMinimumSalary(minimumsalary);
		payGradePg.addMaximumSalary(maximumsalary);
	    
	}
	@And ("Clicks on save button for add currency")
	public void click_save_for_add_currency()
	{
		payGradePg.clickSaveButton();
	}
	@And ("^currency created with parameters (.+), (.+) and (.+) are added to the table$")
	public void currency_gets_added(String addedcurrency, String minimumsalary, String maximumsalary)
	{
		WebElement addedCurrency = driver.findElement(By.xpath("//div[text()='"+addedcurrency+"']"));
		WebElement addedMinSal = driver.findElement(By.xpath("//div[text()='"+addedcurrency+"']/following::div[1]"));
		WebElement addedMaxSal = driver.findElement(By.xpath("//div[text()='"+addedcurrency+"']/following::div[3]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='"+addedcurrency+"']")));
		Assert.assertEquals("Currency is not added to the table", addedCurrency.getText(), addedcurrency);
		Assert.assertEquals("Minimum salary is not added to the table", minimumsalary, addedMinSal.getText());
		Assert.assertEquals("Maximum salary is not added to the table", maximumsalary, addedMaxSal.getText());
	}
	
	@When("Admin clicks on cancel button")
	public void admin_clicks_on_cancel_button() {
		payGradePg.clickCancelButton();
	}
	@Then("^Added paygrade with (.*) and (.*) gets listed in pay grade table$")
	public void added_paygrade_listed_in_pay_grade_table(String paygradename, String addedcurrency ) {
		WebElement nameAdded = driver.findElement(By.xpath("//div[text()='"+paygradename+"']/parent::div[1]"));
		WebElement currencyAdded = driver.findElement(By.xpath("//div[text()='"+paygradename+"']/parent::div[1]/following::div[1]"));
		
		Assert.assertEquals("paygrade name not added to the pay grade table", nameAdded.getText(), paygradename);
		Assert.assertEquals("paygrade currency not added to the pay grade table", addedcurrency, currencyAdded.getText());
	    
	}




}
