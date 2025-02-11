package seleniumproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webpageopen {

public static void main(String[] args) {
	String baseurl="https://www.facebook.com";
	WebDriver driver;
	driver=new ChromeDriver();
	driver.manage().window().fullscreen();
	driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	driver.get(baseurl);
	driver.findElement(By.id("email")).sendKeys("esaikrishn@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("Sweety@2002");
	driver.findElement(By.id("loginbutton")).click();
	
	
	
}

}
