package pageobejctmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class POMsecondscneario {

	WebDriver driver;
	
	@BeforeClass
	public void openurlagain(ITestContext context) {
		
		driver = new EdgeDriver();
        driver.get("https://www.zebra.com/");

        // Debugging statement
        System.out.println("WebDriver initialized and navigated to zebra.com");

        // Store the WebDriver instance in the context for the listener
        context.setAttribute("driver", driver);
		
		
	}
	
	@Test
	public void clickcookies() {
		
		 Zebaraopenerpom zeb= new  Zebaraopenerpom(driver);
		 zeb.clickAcceptCookies();
		
		
	}
	
	
	@AfterClass
	public void closeurlagain() {
		driver.quit();
	}
	
	
}
