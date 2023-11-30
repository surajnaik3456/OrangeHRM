package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserManagementPage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

import java.time.Duration;

import org.junit.Assert;

public class UserFlow extends TestBase {
	LoginPage loginPg = new LoginPage();
	HomePage homepg = new HomePage();
	UserManagementPage userMngPg = new UserManagementPage();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@When("Admin clicks on add button")
	public void user_clicks_on_add_button() {
		userMngPg.clickAddBtn();

	}

	@Then("Add user form is displayed")
	public void add_user_form_is_displayed() {
		userMngPg.addUserPageDisplayed();
	}

	@When("^user saves with parameters for (.*), (.*), (.*), (.*), (.*) and (.*)$")
	public void user_saves_with_parameters(String user_role, String status, String password, String employee_name,
			String user_name, String confirm_password) {
		userMngPg.userRoleSelect(user_role);
		userMngPg.selectStatus(status);
		userMngPg.enterPwd(password);
		userMngPg.enterEmpName(employee_name);
		userMngPg.enterUsername(user_name);
		userMngPg.confirmPwd(confirm_password);

	}

	@When("Clicks on save button in add user page")
	public void clicks_on_save_button_in_add_user() {
		userMngPg.clickSave();
	}

	@Then("success message is displayed")
	public void success_message() {
		userMngPg.successMsg();
	}

	@And("^user with (.*) gets added to the list$")
	public void user_pauli_gets_added_to_the_list(String user_name) throws InterruptedException {
		userMngPg.checkUserGotAdded(user_name);
	}

	@When("^Admin clicks on edit icon for the (.*)$")
	public void user_clicks_on_edit_icon_for_the(String user) {
		userMngPg.selectEditParticularUser(user);

	}

	@Then("edit user form is displayed")
	public void edit_user_form_is_displayed() {
		userMngPg.editUsrPg();
	}

	@When("^Admin updates the (.*), (.*) and (.*)$")
	public void admin_updates(String usernameupdate, String userrole, String status) {
		userMngPg.editUserName(usernameupdate);
		userMngPg.userRoleUpdate(userrole);
		userMngPg.updateStatus(status);
	}

	@And("clicks on save button")
	public void click_save() {

		userMngPg.clickSave();
	}

	@Then("success messages should be displayed")
	public void successMsg() {
		userMngPg.successMsg();
	}

	@And("^redirected to (.*)$")
	public void redirected_to_user_management_screen(String usermangement) {
		WebElement userMngPg = driver.findElement(By.xpath("//h5[text()='" + usermangement + "']"));
		Assert.assertEquals(userMngPg.getText(), usermangement);
	}

	@And("^check if (.*), (.*) for the (.*) is updated$")
	public void check_user_details_updated(String userrole, String status, String username) {
		WebElement updatedUserRole = driver
				.findElement(By.xpath("//div[text()='" + username + "']/parent::div/following-sibling::div[1]"));
		WebElement updatedStatus = driver
				.findElement(By.xpath("//div[text()='" + username + "']/parent::div/following-sibling::div[3]"));
		Assert.assertEquals(updatedUserRole.getText(), userrole);
		Assert.assertEquals(updatedStatus.getText(), status);
	}

	@When("^user clicks on delete icon for the (.*)$")
	public void user_clicks_on_delete_icon_for_the_user(String username) {

		userMngPg.clickDltForUsername(username);

	}

	@Then("^confirmation (.*) shows up$")
	public void confirmation_pop_up_shows_up(String popup) {

		WebElement confirmationPopUp = driver.findElement(By.xpath("//p[text()='Are you Sure?']"));
		wait.until(ExpectedConditions.elementToBeClickable(confirmationPopUp));
		Assert.assertTrue(confirmationPopUp.isDisplayed());

	}

	@Then("user clicks on Yes/No button")
	public void user_clicks_on_yes_delete_button() {

		userMngPg.yesInPopUp();
	}

	@Then("Success message is displayed")
	public void success_message_displayed() {
		userMngPg.successMsg();
	}

	@And("^user with (.*) gets delete and is not in the table$")
	public void userDltConfirmation(String username) {

		try {
			driver.findElement(By.xpath("//div[text()='" + username + "']"));
		} catch (NoSuchElementException e) {
			System.out.println("Element with username '" + username + "' is not present (as expected).");
		}

	}
}
