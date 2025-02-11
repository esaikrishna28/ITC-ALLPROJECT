package TestNgpackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Saucedemo {

	WebDriver driver;
	List<String> urllist=new ArrayList<>();
	@BeforeTest
	public void setup() {
		driver =new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void login() throws InterruptedException {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();;
		Thread.sleep(1000);
		
	}
	@Test
	public void selectproduct() {
	
		
	    
	    WebElement inventorylist = driver.findElement(By.className("inventory_list"));
	     
	 List<WebElement> elem =  inventorylist.findElements(By.tagName("a"));
	 
	    
	    for(WebElement webele: elem) {
	    //	System.out.println(webele.getText()+" link is "+webele.getAttribute("id"));
	    	urllist.add(webele.getAttribute("id"));
	    	
	    }
	    
	    System.out.println(urllist);
		
	}
	
	@Test(dependsOnMethods = {"selectproduct"})
	public void completeaction() throws InterruptedException {
		
		driver.findElement(By.id(urllist.get(0))).click();
		Thread.sleep(1000);
	    driver.findElement(By.id("add-to-cart")).click();Thread.sleep(1000);
	    driver.findElement(By.className("shopping_cart_link")).click();Thread.sleep(1000);
	    driver.findElement(By.id("checkout")).click();Thread.sleep(1000);
	    driver.findElement(By.id("first-name")).sendKeys("sai krishna");Thread.sleep(1000);
	    driver.findElement(By.id("last-name")).sendKeys("ellur");Thread.sleep(1000);
	    driver.findElement(By.id("postal-code")).sendKeys("584101");Thread.sleep(1000);
	    driver.findElement(By.id("continue")).click();Thread.sleep(1000);
	    driver.findElement(By.id("finish")).click();Thread.sleep(1000);
	    
	    driver.findElement(By.id("back-to-products")).click();Thread.sleep(1000);
	}
	
	
	
}
