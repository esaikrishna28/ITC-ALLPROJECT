package SampleSauseClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class logout {

	WebDriver dr=null;
	public logout(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.dr=driver;
	}

	
	
	public void logoutsucc() throws InterruptedException {
		 dr.findElement(By.id("react-burger-menu-btn")).click();
		 Thread.sleep(1000);
		    
		    WebDriverWait waitter = new WebDriverWait(dr, Duration.ofSeconds(5));
		    WebElement logoutLink = waitter.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

		    // Click the logout link
		    logoutLink.click();
		    Thread.sleep(1000);
		    dr.findElement(By.id("logout_sidebar_link")).click();
		
		    dr.quit();
		
		
	}
	
	
}
