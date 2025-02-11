package seleniumproject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Launchawebsite {
	public static void main(String[] args) {
	    WebDriver driver = new ChromeDriver();
	    try {
	        driver.manage().window().maximize();
	        driver.get("https://demowebshop.tricentis.com/");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        WebElement booksLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/books']")));
	        booksLink.click();
	        System.out.println("Books link has been clicked.");
	        
	        String title = driver.getTitle();
	        System.out.println(title);
	        
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/books']")));
	        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	        System.out.println("List of links on page:");
	        for (WebElement link : allLinks) {
	            String linkUrl = link.getAttribute("href");
	            if (linkUrl != null) {
	                System.out.println(linkUrl);
	            }
	        }
	    } finally {
	        driver.quit();
	    }
	}


	
	
}
