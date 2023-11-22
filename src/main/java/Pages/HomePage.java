package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class HomePage extends TestBase {

	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	By homePage = By.xpath("//h6");
	By userDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
	By logout = By.linkText("Logout");
	By admin = By.xpath("//a[@class='oxd-main-menu-item']");
	By adminSection = By.xpath("//header/div[1]/div[1]/span[1]");
	By totalRecords = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
	By sysUsername = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By empName = By.cssSelector("input[placeholder='Type for hints...']");
	By statusDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
	By clickSearch = By.cssSelector("button[type='submit']");
	By userDisplayed = By.xpath("(//span[@class='oxd-text oxd-text--span'])[1]");
	By resetBtn = By.xpath("(//button[@type='button'])[4]");
	By searchField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
	By sidePanel = By.cssSelector("div[class='oxd-sidepanel-body']");
	//Dropdown locators
	By aboutSelect = By.xpath("//*[text()='About']");
	By supportSelect = By.xpath("//*[text()='Support']");
	By changePasswordSelect = By.xpath("//*[text()='Change Password']");
	By AboutDailogueBox = By.cssSelector("h6[class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By supportScreen =By.cssSelector("div[class='orangehrm-support']");
	By changePasswordScreen = By.xpath("//*[text()='Update Password']");
	By currentPassword =By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	By pwd =By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
	By confirmPassword =By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]");
	By save =By.cssSelector("button[type='submit']");
	By success =By.xpath("//*[text()='Success']");
	
	public void homePageVerify()
	{
		driver.findElement(homePage).isDisplayed();
	}
	public void userDropDownClick()
	{
		driver.findElement(userDropdown).click();
	}
	public void logoutClick()
	{
		driver.findElement(logout).click();
	}
	public void adminClick()
	{
		driver.findElement(admin).click();
	}
	public void adminSectionDisplayed()
	{
		driver.findElement(adminSection).isDisplayed();
	}
	public String totalRecordsDisplayed()
	{
		return driver.findElement(totalRecords).getText();
	}
	public void clickSearchBtn()
	{
		driver.findElement(clickSearch).click();
	}
	public void userParameters(String username,String user_role,String employee_name,String status) throws InterruptedException
	{
	driver.findElement(sysUsername).sendKeys(username);
	driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
	Thread.sleep(2000);
	List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
	for(WebElement option:options)
	{
		if(option.getText().equalsIgnoreCase(user_role))
		{
			option.click();
			break;
		}
	}
	driver.findElement(empName).sendKeys(employee_name);
	driver.findElement(statusDropdown).click();
	List<WebElement> options2 = driver.findElements(By.xpath("//div[@role='option']"));
	for(WebElement option:options2)
	{
		if(option.getText().equalsIgnoreCase(status))
		{
			option.click();
			break;
		}
	}
	}
	public void searchedUserDisplayed(String message)
	{
	driver.findElement(userDisplayed).getText().equalsIgnoreCase(message);	
	}
	public void resetClick()
	{
	driver.findElement(resetBtn).click();	
	}
	public void searchFieldClick(String category)
	{
	driver.findElement(searchField).sendKeys(category);	
	}
	public void sidePanel()
	{
	driver.findElement(sidePanel).isDisplayed();
	}
	public void searchCategoryResult(String category)
	{
		List<WebElement> options2 = driver.findElements(By.xpath("//ul[@class='oxd-main-menu']"));
		for(WebElement option:options2)
		{
			if(option.getText().equalsIgnoreCase(category))
			{
				option.click();
				break;
			}
		}
		System.out.println(" Landed on " +category+" screen ");
	}
	//Dropdown methods
	public void selectAbout()
	{
		driver.findElement(aboutSelect).click();
	}
	public void selectSupport()
	{
		driver.findElement(supportSelect).click();
	}
	public void passwordChangeClick()
	{
		driver.findElement(changePasswordSelect).click();
	}
	public void AboutDailogueBoxVisible()
	{
		driver.findElement(AboutDailogueBox).isDisplayed();
	}
	public void supportScreenShowsUp()
	{
		driver.findElement(supportScreen).isDisplayed();
	}
	public void changePasswordScreenVisible()
	{
		driver.findElement(changePasswordScreen).isDisplayed();
	}
	public void EnterCurrentPassword(String currentpassword)
	{
		driver.findElement(currentPassword).sendKeys(currentpassword);
	}
	public void enterPassword(String password)
	{
		driver.findElement(pwd).sendKeys(password);
	}
	public void enterConfirmPassword(String confirmpassword)
	{
		driver.findElement(pwd).sendKeys(confirmpassword);
	}
	public void clickSave()
	{
		driver.findElement(save).click();
	}
	public void successMessage()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(success));
		driver.findElement(success).isDisplayed();
	}
	public void clickOption(String option) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//li/a/span[text()='"+option+"']/parent::a")).click();
	}
	public void clickDltForParticularUser(String user)
	{
		driver.findElement(By.xpath("//div[text()='"+user+"']/parent::div/following-sibling::div[4]//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]")).click();
	}
}
