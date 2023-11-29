package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import TestBase.TestBase;

public class JobTitlePage extends TestBase {

	By Job = By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item'])[2]");
	By jobDropdown = By.xpath("//font[text()='Employment Status']/parent::font/parent::a/parent::li");
	By selectJobTitle = By.xpath("//a[text()='Job Titles']/parent::li");
	By jobTitlePage = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	By addJobTitlePage = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By jobTitleField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By jobDescriptionField = By.xpath("//textarea[@placeholder='Type description here']");
	By addNoteField = By.xpath("//textarea[@placeholder='Add note']");
	By saveButton = By.cssSelector("button[type='submit']");
	By editButton = By.xpath(
			"//div[text()='Account Assistant']/parent::div/parent::div//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]");
	By dltButton = By.xpath(
			"//div[text()='Account Assistant']/parent::div/parent::div//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");
	By editJobTitleField = By
			.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]");
	By saveBtn = By.cssSelector("button[type='submit']");

	public void jobClick() {
		driver.findElement(Job).click();
	}

	public void selectFromJobDropDown(String dropdown) {
		driver.findElement(By.xpath("//a[text()='" + dropdown + "']/parent::li")).click();
	}

	public void selectJobTitleInDropdown() {
		driver.findElement(selectJobTitle).click();
	}

	public void clickAddBtn() {
		driver.findElement(addButton).click();
	}

	public void enterJobTitle(String jobTitle) {
		driver.findElement(jobTitleField).sendKeys(Keys.CONTROL+"a");
		driver.findElement(jobTitleField).sendKeys(Keys.DELETE);
		driver.findElement(jobTitleField).sendKeys(jobTitle);

	}

	public void enterJobDescription(String jobDescription) {
		driver.findElement(jobDescriptionField).sendKeys(Keys.CONTROL+"a");
		driver.findElement(jobDescriptionField).sendKeys(Keys.DELETE);
		driver.findElement(jobDescriptionField).sendKeys(jobDescription);
	}

	public void enterNote(String note) {
		driver.findElement(addNoteField).sendKeys(Keys.CONTROL+"a");
		driver.findElement(addNoteField).sendKeys(Keys.DELETE);
		driver.findElement(addNoteField).sendKeys(note);
	}

	public void clickEditForUsername(String username) {
		
		driver.findElement(By.xpath("//div[text()='" + username + "']/parent::div/following::button[2]")).click();
	}

	public void updateJobTitle(String updatejobTitle) {
		driver.findElement(editJobTitleField).sendKeys(Keys.CONTROL+"a");
		driver.findElement(editJobTitleField).sendKeys(Keys.DELETE);
		driver.findElement(editJobTitleField).sendKeys(updatejobTitle);

	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}
}
