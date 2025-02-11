package webdriveruniversity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Languagecapture {

	public WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	@BeforeSuite
	public void launchurl() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.zebra.com/");
		driver.manage().window().maximize();
        Thread.sleep(1000);
      
       
        WebElement checkbtn = driver.findElement(By.xpath("//button[text()='Accept Cookies']"));
		
		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbtn);

		checkbtn.click();
		
		Thread.sleep(1000);
		
	}
	
	
	@Test
	public void listlanguage() {
	
		
		
	}



}



