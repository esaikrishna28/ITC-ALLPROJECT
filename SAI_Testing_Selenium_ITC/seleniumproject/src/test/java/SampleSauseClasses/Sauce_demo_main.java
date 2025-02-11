package SampleSauseClasses;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sauce_demo_main {
	
public static void main(String[] args) throws InterruptedException {
	

	WebDriver driver=ChromeDriversetup.chromesetup();
	
	System.out.println("webpage opened ");
	Loginclass lg =new Loginclass(driver);
	lg.sendusername("standard_user");
	Thread.sleep(1000);
	lg.sendpassword("secret_sauce");
	Thread.sleep(1000);
	lg.loginclick();
	Inventory_urls inv=new Inventory_urls(driver);
	List<String> urllist =inv.listallurls();
	
	System.out.println(urllist);
	System.out.println(urllist.size());

	Completeprocess cmp =new Completeprocess(driver,urllist);
	cmp.completefun();
	
	logout log=new logout(driver);
	log.logoutsucc();
	
	
//	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("sda");
	
	driver.quit();
	
	
	
	

}

}

