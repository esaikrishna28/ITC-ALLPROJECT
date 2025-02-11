package webdriveruniversity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class zebra4 {
    WebDriver driver;
    WebDriverWait wait;
    List<String> mainmenulist4 = new ArrayList<>();
    private static final String FILE_PATH = "/home/zadmin/Desktop/TESTNG/TestNGProject/milestonewrite.txt";
    

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with your path
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
    }

    @Test(priority=1)
    public void runmenu() throws InterruptedException {
        driver.get("https://www.zebra.com/us/en/software/mobile-computer-software.html");
        WebElement checkbtn = driver.findElement(By.xpath("//button[text()='Accept Cookies']"));
		
		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbtn);

		checkbtn.click();
		
		Thread.sleep(1000);
		
		
		//div[@class='cmp-container__wrapper']
		
				
		
		  WebElement setup = driver.findElement(By.xpath("//a[text()='Set Up']"));
			
			 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbtn);

			setup.click();	
			
			Thread.sleep(1000);
			
			String h5Text = "Zebra Zero Touch"; 
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	       
	        WebElement targetDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[@class='content-card']//h5[text()='" + h5Text + "']/ancestor::div[contains(@class, 'content-card')]")
	        ));

	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetDiv);
	        targetDiv.click();
	     
	        
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//a[span[contains(text(), 'Find a Partner')]]")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//button[text()='PARTNER APPS AND OFFERINGS']")).click();
	        Thread.sleep(1000);
	        
	        
	        
	       //driver.findElement(By.xpath("//*[@id=\"partner_type\"]/div[2]/form[2]/div/div[1]/input")).sendKeys("abc");
	        
	        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name or keyword']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
	        inputField.sendKeys("Sygic Fleet GPS Navigation");
	        inputField.sendKeys(Keys.ENTER);
	        Thread.sleep(1000);
	        
	        //driver.findElement(By.xpath("//*[@id=\"partner_type\"]/div[2]/form[1]/div/div[2]/button/span")).click();
	        
	        Thread.sleep(1000);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='VIEW PROFILE']"))); // Change to an appropriate XPath

	        
	        WebElement viewprofile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='VIEW PROFILE']")));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewprofile);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewprofile); // Use JavaScript click


	        

	        
	        
	        
    
    }
    
    public static void writeToFile(String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FILE_PATH)); // Overwrite mode
            writer.write(content);
            writer.newLine(); // Add a new line after writing
            System.out.println("Successfully wrote to the file: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close(); // Close the writer
                }
            } catch (IOException e) {
                System.err.println("Failed to close the writer: " + e.getMessage());
            }
        }
    }
    
    public void scrollpage() throws InterruptedException {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Scroll to the bottom slowly
        long scrollPause = 500; // Pause in milliseconds
        long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");
        
        for (long i = 0; i < scrollHeight; i += 500) { // Adjust the increment as needed
            js.executeScript("window.scrollTo(0, " + i + ");");
            Thread.sleep(scrollPause); // Pause to simulate slow scrolling
        }
        
        // Pause at the bottom
        Thread.sleep(1000); // Pause for 2 seconds at the bottom
        
        // Scroll back to the top slowly
        for (long i = scrollHeight; i > 0; i -= 500) { // Adjust the decrement as needed
            js.executeScript("window.scrollTo(0, " + i + ");");
            Thread.sleep(scrollPause); // Pause to simulate slow scrolling
        }
    }
    
    
    public void  listallh5() {
    	
    	String url = "https://www.zebra.com/ap/en/software/mobile-computer-software.html"; // Replace with the target website URL

        try {
            // Fetch the HTML from the live website
            Document document = Jsoup.connect(url).get();

            // Select all h5 elements
            Elements h5Elements = document.select("div#optimize h5");
            
            Set<String> h5TextsSet = new LinkedHashSet<>();
            for (Element h5 : h5Elements) {
                h5TextsSet.add(h5.text());
            }

            // Convert the set back to a list if needed
            List<String> uniqueH5Texts = new ArrayList<>(h5TextsSet);

            // Output the unique texts (you can also assert these in your tests)
            for (String text : uniqueH5Texts) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions as needed
        }
    	
    	
    }
}



