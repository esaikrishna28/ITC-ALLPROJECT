package SampleSauseClasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChromeDriversetup {
  
	public static WebDriver chromesetup() {
		 WebDriver driver = new ChromeDriver();
			
		 driver.manage().window().maximize();
	     driver.get("https://www.saucedemo.com/");
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	     return driver;
	}
	
}

