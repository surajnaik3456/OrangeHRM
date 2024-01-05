package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class PayGradesPage extends TestBase {
	
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

By payGradeNameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
By currencyField = By.xpath("//div[@class='oxd-select-text-input' and text()='-- Select --']");
By minimumSalaryField = By.xpath("//div/label[text()='Minimum Salary']//following::input[1]");
By maximumSalaryField = By.xpath("//div/label[text()='Minimum Salary']//following::input[2]");
By saveBtn =By.xpath("(//button[@type='submit'])[2]");
By clickCancel = By.xpath("//button[@type='button' and text()=' Cancel ']");


public void enterpayGradeName(String paygradename)
{
	driver.findElement(payGradeNameField).sendKeys(paygradename);
}
public void addCurrency(String currency)
{
	driver.findElement(currencyField).click();
	driver.findElement(By.xpath("//span[text()='"+currency+"']/parent::div")).click();
}
public void addMinimumSalary(String minimumsalary)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(minimumSalaryField));
	driver.findElement(minimumSalaryField).sendKeys(minimumsalary);
}
public void addMaximumSalary(String maximumsalary)
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(maximumSalaryField));
	driver.findElement(maximumSalaryField).sendKeys(maximumsalary);
}
public void clickSaveButton()
{
	driver.findElement(saveBtn).click();
}
public void clickCancelButton()
{
	driver.findElement(clickCancel).click();
}
}
