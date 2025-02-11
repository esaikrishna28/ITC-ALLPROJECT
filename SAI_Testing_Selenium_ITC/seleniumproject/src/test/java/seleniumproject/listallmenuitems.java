package seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class listallmenuitems {

	public static void main(String[] args) {
		 WebDriver driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
	     driver.get("https://demowebshop.tricentis.com/");
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//	     List<WebElement> menuLinks =driver.findElements(By.tagName("a"));
//	     for(WebElement link:menuLinks) {
//	    	 System.out.println(link.getText() +"-"+link.getAttribute("href"));
//	    	 
//	     }
	     
	     WebElement ulelement = driver.findElement(By.className("top-menu"));
	     
	     List<WebElement> anchortags =ulelement.findElements(By.tagName("a"));
	     
	     for(WebElement link:anchortags) {
	    	 System.out.println(link.getText() +"-"+link.getAttribute("href"));
	    	 
	     }	
	     	
	     System.out.println(anchortags.get(0).getAttribute("href"));
	     System.out.println(anchortags.size());
	     
	     driver.quit();
		
	}
	
	
}
