package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class SignInPage extends BasePage {

	

	private By _input_emailID = By.xpath("//input[@name='identifier']");
	
	private By _btn_next_AftetEmailID = By.className("VfPpkd-RLmnJb");
	
	private By _input_password = By.name("password");
	
	private By _btn_Next_AfterPassword = By.xpath("//*[@id='passwordNext']");
	
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterGmailIDToLogin(String gmailID) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(_input_emailID)).sendKeys(gmailID);
		wait.until(ExpectedConditions.visibilityOfElementLocated(_btn_next_AftetEmailID)).click();
		
	}
	
	public void enterPasswordToSignIn(String Password) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(_input_password)).sendKeys(Password);
		wait.until(ExpectedConditions.visibilityOfElementLocated(_btn_Next_AfterPassword)).click();

		
	}
	
	
	
	public void signInToGmailAccount(String userEmailID, String password) {
		
		enterGmailIDToLogin(userEmailID);
		enterPasswordToSignIn(password);
		
	}
	
	
}
