package SampleSauseClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Completeprocess {

	 
	WebDriver dri=null;
	List<String> urllist=new ArrayList<>();
	public Completeprocess(WebDriver driver, List<String> urllist2) {
		// TODO Auto-generated constructor stub
		this.dri=driver;
		this.urllist=urllist2;
		
	}
	
	public void completefun() throws InterruptedException {
	for(int i=1;i<urllist.size();i=i+2) {
		JavascriptExecutor js = (JavascriptExecutor) dri;
		
		dri.findElement(By.id(urllist.get(i))).click();
		Thread.sleep(1000);
	    dri.findElement(By.id("add-to-cart")).click();Thread.sleep(1000);
	    dri.findElement(By.className("shopping_cart_link")).click();Thread.sleep(1000);
	    js.executeScript("document.getElementById('checkout').scrollIntoView(true);");Thread.sleep(1000);
	    dri.findElement(By.id("checkout")).click(); Thread.sleep(1000);
	    dri.findElement(By.id("first-name")).sendKeys("sai krishna");Thread.sleep(1000);
	    dri.findElement(By.id("last-name")).sendKeys("ellur");Thread.sleep(1000);
	    dri.findElement(By.id("postal-code")).sendKeys("584101");Thread.sleep(1000);
	    js.executeScript("document.getElementById('continue').scrollIntoView(true);");Thread.sleep(1000);
	    dri.findElement(By.id("continue")).click();Thread.sleep(1000);
	    js.executeScript("document.getElementById('finish').scrollIntoView(true);");Thread.sleep(1000);
	    dri.findElement(By.id("finish")).click();Thread.sleep(1000);
	    js.executeScript("document.getElementById('back-to-products').scrollIntoView(true);");Thread.sleep(1000);
	    dri.findElement(By.id("back-to-products")).click();Thread.sleep(1000);
		
	}
	
	}
	
	
}
