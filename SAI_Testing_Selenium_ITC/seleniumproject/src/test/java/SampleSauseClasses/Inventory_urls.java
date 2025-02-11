package SampleSauseClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory_urls {

	static WebDriver dri=null;
	
	public Inventory_urls(WebDriver driver) {
		this.dri=driver;
	}
	
	public static  List listallurls() {
		
		List<String> urllist=new ArrayList<>();
	    
	    WebElement inventorylist = dri.findElement(By.className("inventory_list"));
	     
	    List<WebElement> elem =  inventorylist.findElements(By.tagName("a"));
	 
	    
	    for(WebElement webele: elem) {
	    	urllist.add(webele.getAttribute("id"));
	    	
	    	System.out.println(webele.getText());
	        			
	    }
	    
	    System.out.println(urllist.size());
	    
		
	    
	
	
	
	
	    
	    return urllist;
	     
	}	
}
