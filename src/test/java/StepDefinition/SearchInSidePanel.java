package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class SearchInSidePanel extends TestBase {
	LoginPage loginpg = new LoginPage();
	HomePage homepg = new HomePage();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	@And ("the side panel is visible")
	public void checkSidePanel()
	{
		homepg.sidePanel();
	}
	@When ("^user enters (.+) in the side panel search field$")
	public void enterCategory(String category)
	{
		homepg.searchFieldClick(category);
	}
	@Then ("^user should see search results related to (.+)$")
	public void searchResult(String category) throws InterruptedException
	{
		homepg.searchCategoryResult(category);
		Thread.sleep(2000);
	}
}
