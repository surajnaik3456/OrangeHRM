package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class UserManagementPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	By addBtn = By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary']");
	By addUserPage = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By userRole = By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
	By statusDropdown = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
	By pwd = By.xpath("(//input[@type='password'])[1]");
	By ConfirmPwd = By.xpath("(//input[@type='password'])[2]");
	By employeeName = By.cssSelector("input[placeholder='Type for hints...']");
	By userName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By save = By.cssSelector("button[type='submit']");
	By successMssg = By.xpath("//*[text()='Success']");
	// EditUser
	By editUserPage = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By userRoleEdit = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By statusDropdownEdit = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By userNameEdit = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By saveEdit = By.cssSelector("button[type='submit']");
	// DeleteUser
	By yesBtn = By.xpath("//button[text()=' Yes, Delete ']");
	By noBtn = By.xpath("//button[text()=' No, Cancel ']");

	public void clickAddBtn() {
		driver.findElement(addBtn).click();
	}

	public void addUserPageDisplayed() {
		driver.findElement(addUserPage).isDisplayed();
	}

	/*public void fillAllParameters(String user_role, String status, String password, String employee_name,
			String user_name, String confirm_password) {
		driver.findElement(userRole).click();
		driver.findElement(By.xpath("//span[text()='" + user_role + "']/parent::div")).click();
		driver.findElement(statusDropdown).click();
		driver.findElement(By.xpath("//span[text()='" + status + "']/parent::div")).click();
		driver.findElement(pwd).sendKeys(password);
		driver.findElement(employeeName).sendKeys(employee_name);
		driver.findElement(By.xpath("//span[text()='" + employee_name + "']/parent::div")).click();
		driver.findElement(userName).sendKeys(user_name);
		driver.findElement(ConfirmPwd).sendKeys(confirm_password);
	}*/
	public void userRoleSelect(String user_role)
	{
		driver.findElement(userRole).click();
		driver.findElement(By.xpath("//span[text()='" + user_role + "']/parent::div")).click();
	}
	public void selectStatus(String status)
	{
		driver.findElement(statusDropdown).click();
		driver.findElement(By.xpath("//span[text()='" + status + "']/parent::div")).click();
	}
	public void enterPwd(String password)
	{
		driver.findElement(pwd).sendKeys(password);
	}
	public void enterEmpName(String employee_name)
	{
		driver.findElement(employeeName).sendKeys(employee_name);
		driver.findElement(By.xpath("//span[text()='" + employee_name + "']/parent::div")).click();
	}
	public void enterUsername(String user_name)
	{
		driver.findElement(userName).sendKeys(user_name);
	}
	public void confirmPwd(String confirm_password)
	{
		driver.findElement(ConfirmPwd).sendKeys(confirm_password);
	}
	
	
	
	
	

	public void clickSave() {
		wait.until(ExpectedConditions.elementToBeClickable(save));
		driver.findElement(save).click();
	}

	public void checkUserGotAdded(String user_name) throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='oxd-icon bi-trash'])[1]")));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//div[text()='" + user_name + "']/parent::div")).getText();
	}

	public void successMsg() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMssg));
		driver.findElement(successMssg).isDisplayed();
	}

	public void selectEditParticularUser(String user) {
		driver.findElement(By.xpath("//div[text()='" + user
				+ "']/parent::div/following-sibling::div[4]//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]"))
				.click();
	}

	public void editUsrPg() {
		driver.findElement(editUserPage).isDisplayed();
	}

	public void editUserName(String usernameupdate) {
		driver.findElement(userNameEdit).clear();
		driver.findElement(userNameEdit).sendKeys(usernameupdate);
	}

	public void userRoleUpdate(String userrole) {
		driver.findElement(userRoleEdit).click();
		driver.findElement(By.xpath("//span[text()='" + userrole + "']/parent::div")).click();
	}

	public void updateStatus(String status) {
		driver.findElement(statusDropdownEdit).click();
		driver.findElement(By.xpath("//span[text()='" + status + "']/parent::div")).click();
	}

	public void ClickSaveEdit() {
		wait.until(ExpectedConditions.elementToBeClickable(saveEdit));
		driver.findElement(saveEdit).click();
	}

	public void clickDltForUsername(String username) {
		driver.findElement(By.xpath("//div[text()='" + username
				+ "']/parent::div/following-sibling::div[4]//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]"))
				.click();
	}

	public void yesInPopUp() {
		driver.findElement(yesBtn).click();
	}

	public void NoInPopUp() {
		driver.findElement(noBtn).click();
	}

}
