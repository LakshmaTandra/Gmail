package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By _ComposeEmailLink = By.xpath("//*[@class='T-I T-I-KE L3']");

	private By _toEmailIdField = By.xpath("//textarea[@name='to']");

	private By _newEmailSubjectField = By.xpath("//input[@name='subjectbox']");

	private By _newEmailMessageBodyField = By.xpath("//*[@class='Am Al editable LW-avf tS-tW']");

	private By _sendButton = By.xpath("//*[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']");

	private By _emailSentMessage = By.xpath("//*[@class='vh']");

	private By _googleAccountButton = By.xpath("//img[@class='gb_Da gbii']");

	private By _signOutButton = By.id("gb_71");

	private By _unreadEmailCount = By.xpath("//*[@class='bsU']");

	private By _unreadEmailList = By.xpath("//div[@class='yW']/span/span");
	
	private By _inboxLink = By.xpath("//*[@class='TO nZ aiq']");
	
	
	private int unreadEmailCount =0;
	


	public boolean verifyPageTitle() {
		try {
			return wait.until(ExpectedConditions.titleContains("Inbox"));
		} catch (Exception e) {
			System.out.println("Inbox page not displayed.");
			return false;
		}
	}

	public void clickOnComposeEmailButton() {
		if (verifyPageTitle()) {
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(_ComposeEmailLink)).click();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	public void enterToEmailAddress(String toEmailID) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_toEmailIdField)).sendKeys(toEmailID);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void enterNewEmailSubjectDetails(String subject) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_newEmailSubjectField)).sendKeys(subject);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void enterNewEmailMessageBody(String Message) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_newEmailMessageBodyField)).sendKeys(Message);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void clickSendCTA() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_sendButton)).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void verifyMessageSentisDisplayed() {
		try {
			wait.until(ExpectedConditions.textToBePresentInElementLocated(_emailSentMessage, "Message sent"));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void signOut() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_googleAccountButton)).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(_signOutButton)).click();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean verifyUnreadEmailListContains(String fromEmailID) {
		
		
		wait.until(ExpectedConditions.titleContains("Inbox"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(_inboxLink)).click();
		for(int i=0 ; i<=3;i++) {

		driver.navigate().refresh();
		
		}
		
		try {
		
		 unreadEmailCount= Integer.parseInt(wait.until(ExpectedConditions.visibilityOfElementLocated(_unreadEmailCount)).getText());
		
		}catch(Exception e) {
			e.getMessage();
		}
		
		List<WebElement> emailList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(_unreadEmailList));
		if(unreadEmailCount != 0) {
			ArrayList<String> emails = new ArrayList<String>();
			 for(int i=0;i< unreadEmailCount;i++) {
				 emails.add(emailList.get(i).getAttribute("email"));
			 }
			 if(emails.contains(fromEmailID)) {
				 System.out.println("Email received.");
				 return true;
			 }else {
				 System.out.println("Email not received.");
				 return false;
			 }		    
		}
		 else {
			return false;
		}
		
		
	}
	
	

}
