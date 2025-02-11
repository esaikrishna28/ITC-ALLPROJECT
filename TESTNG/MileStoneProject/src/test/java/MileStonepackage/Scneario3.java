package MileStonepackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import MileStonepackage.ReportGenerator;

public class Scneario3 {
	WebDriver driver;
	List<String> mainmenulist = new ArrayList<>();
	private static final String FILE_PATH = "/home/zadmin/Desktop/TESTNG/MileStoneProject/Milestonenotepad.txt"; 
	private WebDriverWait wait;
	 private ReportGenerator reportGenerator;

	@Test(priority=1)
	public void openurl() throws InterruptedException {
		String screenshotPath = "";
        boolean isSuccess = true;
		try {
		driver=new ChromeDriver();
		driver.get("https://www.zebra.com/");
		driver.manage().window().maximize();
        Thread.sleep(1000);
        
      
        reportGenerator = new ReportGenerator(driver);
        WebElement checkbtn = driver.findElement(By.xpath("//button[text()='Accept Cookies']"));
		
		 ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbtn);
		 captureScreenshot();
		 screenshotPath = reportGenerator.captureScreenshot("TestCase1");
		checkbtn.click();
		
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		
		}catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
            
        } finally {
            reportGenerator.addReportEntry("Launch the Url \n 1 Launch the Home page url in the chrome \n 2 Accept the cookies displayed on the screen ", isSuccess, screenshotPath);
        }
		
		
	}
	
	@Test(priority=2)
	public void listurlsofmainmenu() throws Exception {
		String screenshotPath = "";
        boolean isSuccess = true;
		try {
		WebElement navclass = driver.findElement(By.className("cmp-container__nav--navigation-items")); 
	
		 List<WebElement> elem =  navclass.findElements(By.tagName("span"));
		 
		 for(WebElement spanname:elem) {
			 String text = spanname.getText();
			    if (text != null && !text.trim().isEmpty()) {
			        mainmenulist.add(text);
			    }
			
		 }
		 
		 writeToFile("List of Main Menu Values");
		
		for(String mainmenuname :mainmenulist) {
			System.out.println(mainmenuname);
			writeToFile("First Level menu is :");
			writeToFile(mainmenuname);
			 getSecondLevelItems(mainmenuname);
			String xpath = String.format("//span[text()='%s']", mainmenuname);
			WebElement mainmenunameele = driver.findElement(By.xpath(xpath));
			((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mainmenunameele);
			mainmenunameele.click();
			screenshotPath = reportGenerator.captureScreenshot("TestCase2");
			 captureScreenshot();
			Thread.sleep(1000);
			
		}
		
		}catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
           
        } finally {
            reportGenerator.addReportEntry("Main Menu Navigation \n 1 Capture the top level menu and store in file \n 2 Capture the Second Level menu and store in file  ", isSuccess, screenshotPath);
        }
	}
	
	@Test(priority=3)
	public void softwaremenunav() throws Exception {
		String screenshotPath = "";
        boolean isSuccess = true;
		try {
		WebElement sftbtn = driver.findElement(By.xpath("//span[text()='Software']"));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sftbtn);
		 captureScreenshot();
		sftbtn.click();
		 captureScreenshot();
		Thread.sleep(1000);
		WebElement devicesoftware = driver.findElement(By.xpath("//span[text()='Device Software']/parent::div"));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", devicesoftware);
		 captureScreenshot();
		devicesoftware.click();
		 captureScreenshot();
		Thread.sleep(1000);
		 captureScreenshot();
		WebElement mcs = driver.findElement(By.xpath("//div[text()='Mobile Computer Software']/parent::div"));
		((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", mcs);
		 captureScreenshot();
		 screenshotPath = reportGenerator.captureScreenshot("TestCase3");
		mcs.click();
		 captureScreenshot();
		scrollpage();
		
		}catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
           
        } finally {
            reportGenerator.addReportEntry("Navigate to Mobile computer Sowtfare page \n 1 Select the Software option in main menu \n 2 Choose device Software \n Under device software choose Mobile Computer Software option ", isSuccess, screenshotPath);
        }
		
	}
	
	@Test(priority=4)
	public void capturenavitems() throws InterruptedException {
		String screenshotPath = "";
        boolean isSuccess = true;
        try {
		
		writeToFile("\n");
		writeToFile("The Sub Navigation menu at Mobile-Computer-Software is  ");
		
		writeToFile("List of options Availabe under Set Up");
		listAllH5("setup");
		
		writeToFile("List of options Availabe under Secure and Manage");
		listAllH5("secure");
		Thread.sleep(1000);

		writeToFile("List of options Availabe under Optimize ");
		listAllH5("optimize");
		Thread.sleep(1000);

		writeToFile("List of options Availabe under Additional Software");
		listAllH5("additional");
		Thread.sleep(1000);
		screenshotPath = reportGenerator.captureScreenshot("TestCase4");
        }catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
            
        } finally {
            reportGenerator.addReportEntry("Mobile Computer Software \n 1 Scroll the page entirely \n 2 Navigate to the diffent section availabe at the page \n 3 Store all the sub menus of Set up ,Secure and Manage,Additional Software & optimize   ", isSuccess, screenshotPath);
        }
	
	}
	
	@Test(priority=5)
	public void zerotouch() throws InterruptedException {
		String screenshotPath = "";
        boolean isSuccess = true;
		try {
		 captureScreenshot();
		String h5Text = "Zebra Zero Touch"; 
        WebDriverWait waits1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        captureScreenshot();
       
        WebElement targetDiv = waits1.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='content-card']//h5[text()='" + h5Text + "']/ancestor::div[contains(@class, 'content-card')]")
        ));
        captureScreenshot();
        captureScreenshot();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", targetDiv);
        targetDiv.click();
        captureScreenshot();
        captureScreenshot();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[span[contains(text(), 'Find a Partner')]]")).click(); captureScreenshot();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='PARTNER APPS AND OFFERINGS']")).click(); captureScreenshot();
        Thread.sleep(1000);
        
        WebElement inputField = waits1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search by name or keyword']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.sendKeys("Sygic Fleet GPS Navigation"); captureScreenshot();
        Thread.sleep(1000);
        inputField.sendKeys(Keys.ENTER); captureScreenshot();
        Thread.sleep(1000);
        captureScreenshot();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='VIEW PROFILE']"))); // Change to an appropriate XPath
        captureScreenshot();
        screenshotPath = reportGenerator.captureScreenshot("TestCase5");
        WebElement viewprofile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='VIEW PROFILE']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewprofile);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewprofile); 
        captureScreenshot();
        
        driver.findElement(By.xpath("//img[@class='cmp-image__image']/parent::a")).click();
       
        captureScreenshot();
        
        
		}catch (Exception e) {
            isSuccess = false; // Mark as failed if an exception occurs
            e.printStackTrace();
           
        } finally {
            reportGenerator.addReportEntry("Zebra Zero Touch \n  1 Land on the Zebra Zero Touch Page \n 2 Select Find a Partner option on the page \n 3 Click on Partner Apps and offerings \n 4 Enter the input and click on the search button \n 5 Once results are loaded click on View Profile button \n 6 Back to home page ", isSuccess, screenshotPath);
        }

		
		
	}
	
	
	public void listAllH5(String idOfBtn) {
        String url = "https://www.zebra.com/ap/en/software/mobile-computer-software.html"; // Replace with the target website URL

        try {
            // Fetch the HTML from the live website
            Document document = Jsoup.connect(url).get();

            // Select all h5 elements within the specified div
            Elements h5Elements = document.select("div#" + idOfBtn + " h5");
            
            Set<String> h5TextsSet = new LinkedHashSet<>();
            for (Element h5 : h5Elements) {
                h5TextsSet.add(h5.text());
            }

            // Convert the set back to a list if needed
            List<String> uniqueH5Texts = new ArrayList<>(h5TextsSet);

            // Output the unique texts (you can also assert these in your tests)
            for (String text : uniqueH5Texts) {
                System.out.println(text);
                writeToFile("  "+text);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions as needed
        }
    }

	
	
		
		public void writeToFile(String content) {
	        BufferedWriter writer = null;
	        try {
	            writer = new BufferedWriter(new FileWriter(FILE_PATH, true)); 
	            writer.write(content);
	            writer.newLine(); 
	            System.out.println("Successfully wrote to the file: " + FILE_PATH);
	        } catch (IOException e) {
	            System.err.println("An error occurred while writing to the file: " + e.getMessage());
	        } finally {
	            try {
	                if (writer != null) {
	                    writer.close(); 
	                }
	            } catch (IOException e) {
	                System.err.println("Failed to close the writer: " + e.getMessage());
	            }
	        }
	    }	
		
	
		public void getSecondLevelItems(String topLevelText) {
	        List<String> secondLevelItems = new ArrayList<>();

	        try {
	            // Click the top-level menu to expand it
	            WebElement topLevelElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[contains(@class, 'navigation-item__first-level-item')][.//span[text()='" + topLevelText + "']]")
	            ));
	            topLevelElement.click();

	            // Retrieve the second-level items
	            List<WebElement> secondLevelElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                    By.xpath("//div[@data-megamenu='" + topLevelText + "']//div[contains(@class, 'navigation-item__second-level-items')]//span[contains(@class, 'navigation-item__second-lvl-label')]")
	            ));

	            // Collect text of each second-level item and print them
	            for (WebElement secondLevel : secondLevelElements) {
	                String itemText = secondLevel.getText();
	                secondLevelItems.add(itemText);
	                System.out.println("  Second Level: " + itemText); // Print the item here
	                writeToFile("  Sub Menu: " + itemText);
	            }
	        } catch (Exception e) {
	            System.err.println("Error retrieving second-level items: " + e.getMessage());
	        }

	        if (secondLevelItems.isEmpty()) {
	            System.out.println("No second-level items found for: " + topLevelText);
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
		
		public void captureScreenshot() {
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File source = ts.getScreenshotAs(OutputType.FILE);
		    try {
		        // Ensure the target directory exists
		        File targetDir = new File("/home/zadmin/Desktop/TESTNG/MileStoneProject/ScreenShotsofTestng");
		        if (!targetDir.exists()) {
		            targetDir.mkdirs();
		        }
		        // Generate timestamp and use it as the test name
		        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		        String testName = "screenshot_" + timestamp;
		        // Create the file with the generated test name and timestamp
		        FileUtils.copyFile(source, new File(targetDir, testName + ".png"));
		        System.out.println("Screenshot taken with name: " + testName);
		    } catch (IOException e) {
		        System.out.println("Exception while taking screenshot: " + e.getMessage());
		    }
		}
		
		@AfterSuite
		public void closedriver() {
			driver.quit();
			
			 reportGenerator.finalizeReport();	
			
		}
		
		
		
		
}

	
	
	
	
	
	

	
	
	
	

