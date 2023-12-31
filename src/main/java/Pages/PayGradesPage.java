package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.TestBase;

public class PayGradesPage extends TestBase {
	
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

By payGradeNameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

public void enterpayGradeName(String paygradename)
{
	driver.findElement(payGradeNameField).sendKeys(paygradename);
}
}
