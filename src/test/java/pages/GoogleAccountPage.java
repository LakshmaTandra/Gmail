package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class GoogleAccountPage extends BasePage{
	

	public GoogleAccountPage(WebDriver driver) {
		super(driver);
	}

	By _useAnotherAccountLink = By.xpath("//div[contains(text(),'Use another account')]");
	
	
	
	public void clickUseAnotherAccountToLoginLink() {
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(_useAnotherAccountLink)).click();
			
		}catch(Exception e) {
			 e.getMessage();
			

		}
	}
	
	
}
