package StepDefinition;

import Pages.HomePage;
import TestBase.TestBase;
import io.cucumber.java.en.*;

public class DropDown extends TestBase 
{
	HomePage homepg = new HomePage();
	
	@And ("the user selects About")
	public void selectAbout() 
	{
		homepg.selectAbout();
	}
    @Then ("about dialogue box shows up on the application")
    public void dialogueBoxIsDisplayed() 
	{
		homepg.AboutDailogueBoxVisible();
	}
    @And ("the user select Support")
    public void clickSupport() 
	{
		homepg.selectSupport();
	}
    @Then ("user should be directed to the support page")
    public void supportPgDisplayed() 
	{
		homepg.supportScreenShowsUp();
	}
    @And ("the user selects Change Password")
    public void ChangePwdSelect() 
	{
		homepg.passwordChangeClick();
	}
    @Then ("change password screen is displayed")
    public void changePwdScreenDisplayed() 
	{
		homepg.changePasswordScreenVisible();
	}
    
    @And ("^the user enter (.+), (.+) and (.+)$")
    public void EnterRequiredField(String currentpassword,String password,String confirmpassword) 
	{
		homepg.EnterCurrentPassword(currentpassword);
		homepg.enterPassword(password);
		homepg.enterConfirmPassword(confirmpassword);
	}
    @And ("clicks on save botton")
    public void clickSave() throws InterruptedException 
   	{
   		homepg.clickSave();
   		Thread.sleep(2000);
   	}
    @Then ("Success flash message is displayed")
    public void successMessageShowsup()
   	{
   		homepg.successMessage();
   	}
    
	}