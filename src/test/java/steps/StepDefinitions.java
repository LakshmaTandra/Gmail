package steps;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.GoogleAccountPage;
import pages.HomePage;
import pages.SignInPage;

public class StepDefinitions extends TestBase {
	
	private TestBase base;
	HomePage homePage;
	SignInPage signInPage;
	GoogleAccountPage googleAccountPage;
	

	public StepDefinitions(TestBase base) {
		this.base = base;
	}
	
	@Given("I am on Gmail login page")
	public void i_am_on_gmail_login_page() throws IOException {
		base.driver.get(base.getProperty("Url"));
	  
	}

	@And("I login with registered gmail account")
	public void i_login_with_registered_gmail_account(DataTable dataTable) {
		signInPage = new SignInPage(base.driver);
		signInPage.signInToGmailAccount(dataTable.cell(1, 0), dataTable.cell(1, 1));
	
	}

	@When("I click on compose")
	public void i_click_on_compose() {
		homePage = new HomePage(base.driver);
		homePage.clickOnComposeEmailButton();
	   
	}

	@And("I enter email details")
	public void i_enter_email_details(DataTable dataTable) {
	   homePage.enterToEmailAddress(dataTable.cell(1, 0));
	   homePage.enterNewEmailSubjectDetails(dataTable.cell(1, 1));
	   homePage.enterNewEmailMessageBody(dataTable.cell(1, 2));
	}

	@And("I press on send")
	public void i_press_on_send() {
		homePage.clickSendCTA();
	   
	}

	@And("wait for the email to be sent successfully and logout")
	public void wait_for_the_email_to_be_sent_successfully_and_logout() {
	  homePage.verifyMessageSentisDisplayed();
	  homePage.signOut();
		
	}

	@When("I Login to another gmail account")
	public void i_login_to_another_gmail_account(DataTable dataTable) {
		googleAccountPage = new GoogleAccountPage(base.driver);
		googleAccountPage.clickUseAnotherAccountToLoginLink();
		signInPage.signInToGmailAccount(dataTable.cell(1, 0), dataTable.cell(1, 1));
		
	}

	@Then("verify new email from {string} appears in Inbox.")
	public void verify_new_email_from_appears_in_inbox(String senderEmailID) {
		Assert.assertTrue("Email not received", homePage.verifyUnreadEmailListContains(senderEmailID.toLowerCase()));
	    
	}


	
	
}
