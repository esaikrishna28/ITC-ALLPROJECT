package webdriveruniversity;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class zebra {

	WebDriver driver;
	List<String> mainmenulist = new ArrayList<>();
	List<String> mainmenulist2 = new ArrayList<>();
	List<String> mainmenulist3 = new ArrayList<>();
	List<String> mainmenulist4 = new ArrayList<>();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	//zbr-header__first-level-label
	
	//driver.findElement().click();
	
	@Test(priority=1)
	public void openurl() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://www.zebra.com/");
		driver.manage().window().maximize();
        Thread.sleep(1000);
      
       
        WebElement checkbtn = driver.findElement(By.xpath("//button[text()='Accept Cookies']"));
		
		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbtn);

		checkbtn.click();
		
		Thread.sleep(1000);
		
	}
	@Test(priority=2)
	public void listurls() throws Exception {
		//span[text()='Software']/parent::div
//		WebElement sftbtn = driver.findElement(By.xpath("//span[text()='Industry']"));
//		
//		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sftbtn);
//
//		sftbtn.click();
		
		WebElement navclass = driver.findElement(By.className("cmp-container__nav--navigation-items")); 
	
		 List<WebElement> elem =  navclass.findElements(By.tagName("span"));
		 
		 for(WebElement spanname:elem) {
//			System.out.println(spanname.getText());
//			mainmenulist.add(spanname.getText());
			 String text = spanname.getText();
			    if (text != null && !text.trim().isEmpty()) {
			       // System.out.println(text);
			        mainmenulist.add(text);
			    }
			
		 }
		 
		 System.out.println(mainmenulist);
		
		for(String mainmenuname :mainmenulist) {
			System.out.println(mainmenuname);
			String xpath = String.format("//span[text()='%s']", mainmenuname);
			WebElement mainmenunameele = driver.findElement(By.xpath(xpath));
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainmenunameele);
			mainmenunameele.click();
			Thread.sleep(1000);
			
//			WebElement navclass3 = driver.findElement(By.className("cmp-container__nav--navigation-items")); 
//			
//			 List<WebElement> elem3 =  navclass3.findElements(By.tagName("span"));
//			 
//			 for(WebElement spanname:elem3) {
//				 String text = spanname.getText();
//				    if (text != null && !text.trim().isEmpty()) {
//				        System.out.println(text);
//				        mainmenulist3.add(text);
//				    }
//				
//				    
//				    
//			 }
			
			
			
		
			
		}

		
//		System.out.println(mainmenulist3);
//		System.out.println(mainmenulist3.size());
		
}
	
	@Test(priority=3)
	public void softwarenavigation() {
		WebElement sftbtn = driver.findElement(By.xpath("//span[text()='Software']"));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sftbtn);
		sftbtn.click();
		
		WebElement devicesoftware = driver.findElement(By.xpath("//span[text()='Device Software']/parent::div"));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", devicesoftware);
		devicesoftware.click();
		
		
		
		
		
		
	}
	
	
	
	
	public void software() throws InterruptedException {
		WebElement sftbtn = driver.findElement(By.xpath("//span[text()='Software']"));
		
		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sftbtn);

		sftbtn.click();
		
		
		
		
		WebElement navclass2 = driver.findElement(By.className("cmp-container__nav--navigation-items")); 
		
		 List<WebElement> elem2 =  navclass2.findElements(By.tagName("span"));
		 
		 for(WebElement spanname:elem2) {
			 String text = spanname.getText();
			    if (text != null && !text.trim().isEmpty()) {
			      //  System.out.println(text);
			        mainmenulist2.add(text);
			    }
			
		 }
		 
		 	 	 System.out.println(mainmenulist2);
//		
//		for(String mainmenuname :mainmenulist2) {
//			System.out.println(mainmenuname);
//			String xpath = String.format("//span[text()='%s']", mainmenuname);
//			WebElement mainmenunameele = driver.findElement(By.xpath(xpath));
//			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainmenunameele);
//			mainmenunameele.click();
//			Thread.sleep(1000);
//		}
			
	}
	
	
	public void navigationmenulist() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.navigation-item.megamenu-section")));

	    List<WebElement> megamenuSections = driver.findElements(By.cssSelector("div.navigation-item.megamenu-section"));

	    // Ensure there are at least 6 sections to avoid IndexOutOfBoundsException
	    if (megamenuSections.size() >= 6) {
	        for (int i = 0; i < 6; i++) {
	            // Access the current megamenu section
	            WebElement megamenusection = megamenuSections.get(i);
	            System.out.println("Processing section " + (i + 1) + ": " + megamenusection.getText());

	            // Find all second-level items within the current megamenu section
	            List<WebElement> secondLevelItems = megamenusection.findElements(By.cssSelector("div.navigation-item.second-level-items"));

	            for (WebElement secondLevelItem : secondLevelItems) {
	                // Find span elements within each second-level item
	                List<WebElement> spans = secondLevelItem.findElements(By.cssSelector("span.navigation-item.second-lvl-label"));
	                
	                for (WebElement span : spans) {
	                    String text = span.getText();
	                    if (text != null && !text.trim().isEmpty()) {
	                        System.out.println("Span text: " + text);
	                        mainmenulist4.add(text);
	                    }
	                }
	            }

	            // Print the current state of mainmenulist4 after processing each section
	            System.out.println("After processing section " + (i + 1) + ": " + mainmenulist4);
	        }
	    } else {
	        System.out.println("There are less than six megamenu sections available.");
	    }	
		
	
	
	}
	}
