package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TestBase.TestBase;

public class HomePage extends TestBase {

	WebDriver driver;
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
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
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
}
