package TestNgpackage;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class launchurl {

	

	WebDriver driver;
	   // Setup WebDriver before each test
	  
	@BeforeMethod
	
	   public void setUp() {
	       // Set the path to the WebDriver executable (make sure to download it)
	       //System.setProperty("webdriver.chrome.driver", "C:\\Users\\direc\\OneDrive\\Desktop\\CorporateTraining\\ITC\\chromedriver-win64\\chromedriver.exe");
	       // Initialize WebDriver (using Chrome in this example)
	       driver = new ChromeDriver();
	   }
	   // Test to launch the URL
	   @Test(dataProvider = "urlProvider", dataProviderClass = TestData.class)
	   public void launchWebShop(String url) {
	       // Open the URL
	       driver.get(url);
	       // Optionally, you can assert or log something to verify the page loaded
	       String pageTitle = driver.getTitle();
	       System.out.println("Page Title: " + pageTitle);
	      
	       // Assert the title to ensure the correct page is loaded
	     assertTrue(pageTitle.contains("Demo Web Shop"), "Page title does not contain 'Demo Web Shop'");
	 
	   }
	   // Cleanup after each test
	
	@AfterMethod

	   public void tearDown() {
	       // Close the browser
	       //driver.quit();
	   }
	
	
}
