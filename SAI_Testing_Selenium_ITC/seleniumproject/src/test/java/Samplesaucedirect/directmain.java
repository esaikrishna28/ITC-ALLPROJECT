package Samplesaucedirect;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class directmain {
public static void main(String[] args) {
	 WebDriver driver = new ChromeDriver();
		
	 driver.manage().window().maximize();
     driver.get("https://www.saucedemo.com/");
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     driver.findElement(By.id("user-name")).sendKeys("standard_user");
     driver.findElement(By.id("password")).sendKeys("secret_sauce");
     driver.findElement(By.id("login-button")).click();
     
     
   
//     driver.findElement(By.id("item_4_title_link")).click();
     List<String> urllist=new ArrayList<>();
    
    WebElement inventorylist = driver.findElement(By.className("inventory_list"));
     
 List<WebElement> elem =  inventorylist.findElements(By.tagName("a"));
 
    
    for(WebElement webele: elem) {
    //	System.out.println(webele.getText()+" link is "+webele.getAttribute("id"));
    	urllist.add(webele.getAttribute("id"));
    	
    }
    
    System.out.println(urllist);
    
    driver.findElement(By.id(urllist.get(0))).click();
    driver.findElement(By.id("add-to-cart")).click();
    driver.findElement(By.className("shopping_cart_link")).click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('checkout').scrollIntoView(true);");
    
    
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("sai krishna");
    driver.findElement(By.id("last-name")).sendKeys("ellur");
    driver.findElement(By.id("postal-code")).sendKeys("584101");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    
    driver.findElement(By.id("back-to-products")).click();
    
    
    
    
    
    driver.findElement(By.id("react-burger-menu-btn")).click();
    
    WebDriverWait waitter = new WebDriverWait(driver, Duration.ofSeconds(5));
    WebElement logoutLink = waitter.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

    // Click the logout link
    logoutLink.click();
    driver.findElement(By.id("logout_sidebar_link")).click();
    
    
    
    
    
    
    
     
}
}
