package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserManagementPage;
import io.cucumber.java.en.*;

public class UserFlow {
	LoginPage loginPg = new LoginPage();
	HomePage homepg = new HomePage();
	UserManagementPage UserMngPg = new UserManagementPage();
	
	@When("Admin clicks on add button")
	public void user_clicks_on_add_button() {
		UserMngPg.clickAddBtn();
	}

	@Then("Add user form is displayed")
	public void add_user_form_is_displayed() {
		UserMngPg.addUserPageDisplayed();
	}

	@When("^user saves with parameters for (.*), (.*), (.*), (.*), (.*) and (.*)$")
	public void user_saves_with_parameters(String user_role, String status, String password, String employee_name, String user_name, String confirm_password) {
		UserMngPg.fillAllParameters(user_role, status, password, employee_name, user_name, confirm_password);
	}

	@When("Clicks on save button in add user page")
	public void clicks_on_save_button_in_add_user() {
		UserMngPg.clickSave();
	}
	@Then("success message is displayed")
	public void success_message() {
		UserMngPg.successMsg();
	}
	
	@And("^user with (.*) gets added to the list$")
	public void user_pauli_gets_added_to_the_list(String user_name) throws InterruptedException {
		UserMngPg.checkUserGotAdded(user_name);
	}

	@When("^Admin clicks on edit icon for the (.*)$")
	public void user_clicks_on_edit_icon_for_the(String user) {
		UserMngPg.selectEditParticularUser(user);
	    
	}

	@Then("edit user form is displayed")
	public void edit_user_form_is_displayed() {
		UserMngPg.editUsrPg();
	}

	@When("^user updates the user name to (.*)$")
	public void user_updates_the_user_name(String updatedname) throws InterruptedException {
		UserMngPg.editUserName(updatedname);
	}

	@And ("clicks on save button")
	public void click_save()
	{
		UserMngPg.ClickSaveEdit();
	}
	 @Then ("success messages should be displayed")
	 public void successMsg()
		{
		 UserMngPg.successMsg();
		}
	@Then("redirected to user management screen")
	public void redirected_to_user_management_screen() {
		UserMngPg.userManagementPg();
	}

	@When("user updates the user role from Admin to ESSAdmin")
	public void user_updates_the_user_role_from_admin_to_ess_admin() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on delete icon for the Pauli")
	public void user_clicks_on_delete_icon_for_the_pauli() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("confirmation pop-up shows up")
	public void confirmation_pop_up_shows_up() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user clicks on Yes,delete button")
	public void user_clicks_on_yes_delete_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Success message is displayed")
	public void success_message_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
