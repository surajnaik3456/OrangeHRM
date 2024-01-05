package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class ReportsPage extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	By reports = By.xpath("//a[text()='Reports']");
	By reportsPage = By.xpath("//h5[text()='Employee Reports']");
	By addBtn = By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']");
	By addReportsPage = By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']");
	By reportNameField = By.xpath("//input[@class='oxd-input oxd-input--active' and @placeholder='Type here ...']");
	By selectionCriteriaDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
	By includeField = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
	By selectDisplayFieldGroup = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
	By selectDisplayField = By.xpath("(//div[@class='oxd-select-text-input'])[4]");
	By selectDisplayFieldPlusIcon =By.xpath("(//i[@class='oxd-icon bi-plus'])[2]");
	By includeHeaderToggle = By.xpath("//input[@type='checkbox']/following::span");
	By SaveBtn = By.xpath("//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

	
public void clickReports()
{
	driver.findElement(reports).click();
}
public void clickAdd()
{
	driver.findElement(addBtn).click();
}
public void enterReportName(String reportName)
{
	driver.findElement(reportNameField).sendKeys(reportName);
}
public void selectCriteria(String selectionCriteria)
{
	driver.findElement(selectionCriteriaDropdown).click();
	driver.findElement(By.xpath("//span[text()='"+selectionCriteria+"']/parent::div")).click();
}
public void includeSelection(String include)
{
	driver.findElement(includeField).click();
	driver.findElement(By.xpath("//span[text()='"+include+"']/parent::div")).click();
}
public void selectDisplayFieldGrp(String displayFieldGroup)
{
	driver.findElement(selectDisplayFieldGroup).click();
	driver.findElement(By.xpath("//span[text()='"+displayFieldGroup+"']/parent::div")).click();
}
public void selectDisplayFld(String displayField1)
{
	driver.findElement(selectDisplayField).click();
	driver.findElement(By.xpath("//span[text()='"+displayField1+"']/parent::div")).click();
	driver.findElement(selectDisplayFieldPlusIcon).click();
}
public void selectDisplayFld2(String displayField2)
{
	driver.findElement(selectDisplayField).click();
	driver.findElement(By.xpath("//span[text()='"+displayField2+"']/parent::div")).click();
	driver.findElement(selectDisplayFieldPlusIcon).click();
}
public void selectDisplayFld3(String displayField3)
{
	driver.findElement(selectDisplayField).click();
	driver.findElement(By.xpath("//span[text()='"+displayField3+"']/parent::div")).click();
}
public void clickPlusBtn()
{
	driver.findElement(selectDisplayFieldPlusIcon).click();
}
public void clickToggle()
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(includeHeaderToggle));
	driver.findElement(includeHeaderToggle).click();
}
public void clickSvBtn()
{
	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    
	wait.until(ExpectedConditions.elementToBeClickable(SaveBtn));
	driver.findElement(SaveBtn).click();
}
}
