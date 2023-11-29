package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestBase {

	public static WebDriver driver;
	public void browserLaunch()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");	
	}
	public void quitBrowser()
	{
		driver.quit();
	}
}
