package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class PimPage extends TestBase {
	
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

By pimPage = By.xpath("//h5[text()='Employee Information']");
By addBtn = By.cssSelector("i[class='oxd-icon bi-plus oxd-button-icon']");
By firstNm = By.cssSelector("input[name='firstName']");
By middleNm = By.cssSelector("input[name='middleName']");
By lastNm = By.cssSelector("input[name='lastName']");
By saveEmp = By.xpath("//button[@type='submit']");
By jobTitle = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
By subUnitSelect = By.xpath("(//div[@class='oxd-select-text-input'])[3]");
By empStatus = By.xpath("(//div[@class='oxd-select-text-input'])[3]");


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
	driver.findElement(saveEmp).click();
}
public void jobClick(String job)
{
	driver.findElement(By.xpath("//a[text()='"+job+"']//parent::div")).click();
}
public void jobTitle(String jobtitle)
{
	driver.findElement(jobTitle).click();
	driver.findElement(By.xpath("//span[text()='"+jobtitle+"']/parent::div")).click();
}
public void subUnit(String subunit)
{
	driver.findElement(subUnitSelect).click();
	driver.findElement(By.xpath("//span[text()='"+subunit+"']/parent::div")).click();
}
public void empStatusSelect (String employmentstatus)
{
	driver.findElement(empStatus).click();
	driver.findElement(By.xpath("//span[text()='"+employmentstatus+"']/parent::div")).click();
}
}
