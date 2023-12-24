package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class PimPage extends TestBase {
	
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

By pimPage = By.xpath("//h5[text()='Employee Information']");
By addBtn = By.cssSelector("i[class='oxd-icon bi-plus oxd-button-icon']");
By firstNm = By.cssSelector("input[name='firstName']");
By middleNm = By.cssSelector("input[name='middleName']");
By lastNm = By.cssSelector("input[name='lastName']");
By save = By.xpath("//button[@type='submit']");
By jobTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
By subUnitSelect = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
By empStatus = By.xpath("(//div[@class='oxd-select-text-input'])[5]");
By addBtnForSupervisor = By.xpath("(//button[@type='button'])[3]");
By supervisorNameField = By.xpath("//input[@placeholder='Type for hints...']");
By reportingMethodDropdown = By.cssSelector("div[class='oxd-select-text-input']");
By employeeList = By.xpath("//a[text()='Employee List']");
//Edit Employee


public void clickAddBtn()
{
	driver.findElement(addBtn).click();
}
public void EnterFirstName (String firstname)
{
	driver.findElement(firstNm).sendKeys(firstname);
}
public void EnterMiddleName (String middlename)
{
	driver.findElement(middleNm).sendKeys(middlename);
}
public void EnterLastName (String lastname)
{
	driver.findElement(lastNm).sendKeys(lastname);
}
public void clickSave()
{
	driver.findElement(save).click();
}
public void jobClick(String job)
{
	driver.findElement(By.xpath("//a[text()='"+job+"']//parent::div")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
}
//public void jobTitle1(String jobtitle)
//{
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
//	driver.findElement(jobTitle).click();
//	driver.findElement(By.xpath("//span[text()='"+jobtitle+"']/parent::div")).click();
//}
public void subUnit(String subunit)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[3]")));
	driver.findElement(subUnitSelect).click();
	driver.findElement(By.xpath("//span[text()='"+subunit+"']/parent::div")).click();
}
public void empStatusSelect (String employmentstatus)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[5]")));
	driver.findElement(empStatus).click();
	driver.findElement(By.xpath("//span[text()='"+employmentstatus+"']/parent::div")).click();
}
public void reportToClick(String reportTo)
{
	driver.findElement(By.xpath("//a[text()='"+reportTo+"']//parent::div")).click();
}
public void clickAddButton()
{
	driver.findElement(addBtnForSupervisor).click();
}
public void addSupervisorName(String name)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Add Supervisor']")));
	driver.findElement(supervisorNameField).sendKeys(name);
	driver.findElement(By.xpath("//span[text()='"+name+"']/parent::div")).click();
}
public void addReportingMethod(String reportingmethod)
{
	
	driver.findElement(reportingMethodDropdown).click();
	driver.findElement(By.xpath("//span[text()='"+reportingmethod+"']/parent::div")).click();
}
public void clickEmployeeList()
{
driver.findElement(employeeList).click();	
}
// EditEmployee
public void clickEdit(String name)
{
	driver.findElement(By.xpath("//div[text()='"+name+"']/following::button[2]")).click();
}
public void updateFirstNm(String firstName)
{
	driver.findElement(firstNm).click();
	driver.findElement(firstNm).sendKeys(Keys.CONTROL+"a");
	driver.findElement(firstNm).sendKeys(Keys.DELETE);
	driver.findElement(firstNm).sendKeys(firstName);	
}
public void updateMiddleNm(String middleName)
{
	driver.findElement(middleNm).click();
	driver.findElement(middleNm).sendKeys(Keys.CONTROL+"a");
	driver.findElement(middleNm).sendKeys(Keys.DELETE);
	driver.findElement(middleNm).sendKeys(middleName);	
}
public void updateLastNm(String lastName)
{
	driver.findElement(firstNm).click();
	driver.findElement(lastNm).sendKeys(Keys.CONTROL+"a");
	driver.findElement(lastNm).sendKeys(Keys.DELETE);
	driver.findElement(lastNm).sendKeys(lastName);	
}
public void updateJobTitle(String jobtitle)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
	driver.findElement(jobTitle).click();
	driver.findElement(By.xpath("//span[text()='"+jobtitle+"']/parent::div")).click();	
}
public void updateSubUnit(String subunit)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[3]")));
	driver.findElement(subUnitSelect).click();
	driver.findElement(By.xpath("//span[text()='"+subunit+"']/parent::div")).click();
}
public void jobTitle(String jobtitle)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='oxd-select-text-input'])[1]")));
	driver.findElement(jobTitle).click();
	driver.findElement(By.xpath("//span[text()='"+jobtitle+"']/parent::div")).click();
}
}
