package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class GoogleAccountPage extends BasePage{
	

	private By _useAnotherAccountLink = By.xpath("//div[contains(text(),'Use another account')]");
	
	public GoogleAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	// Method to login using a 'Another account link'
	
	public void clickUseAnotherAccountToLoginLink() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_useAnotherAccountLink)).click();
					
	}
	
	
}
