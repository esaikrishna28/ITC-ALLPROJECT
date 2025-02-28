package webdriveruniversity;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WEBelemntsclick {

	
    WebDriver driver;

    @BeforeSuite
    public void urlopening() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.webdriveruniversity.com/Click-Buttons/index.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
	public void elementclick1() throws InterruptedException {
		
		driver.findElement(By.id("button1")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@data-dismiss='modal']")).click();
		Thread.sleep(1000);
	}
    
    @Test
    public void elemntclick2() throws InterruptedException {
    	
    	driver.findElement(By.id("button2")).click();
		Thread.sleep(1000);
		
		WebElement button =driver.findElement(By.xpath("//button[@data-dismiss='modal']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[2].click();", button);
		
    	
    }
    
   
	
	
}
