package steps;


import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {

	 private TestBase base;
	 private String browser ;
	 
	 
	 

	public Hook(TestBase base) {
		this.base = base;
	}

	@Before
	public void setup() {
		
		try {
			browser = base.getProperty("browserData");
			System.out.println(browser);

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				base.driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				base.driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				base.driver = new EdgeDriver();
			} else {
				System.out.println(" Enter correct browser details");
				throw new Exception("Enter correct browser details");

			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	@After
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {
			base.captureScreenshot(s.getName());
			
		}
		 base.driver.close();
		
	}

}
