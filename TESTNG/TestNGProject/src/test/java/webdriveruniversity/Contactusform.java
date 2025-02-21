package webdriveruniversity;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;






public class Contactusform {
    WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void urlopening() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
       
    }
    
    @Test
    public void adddata() throws InterruptedException {
    	test = extent.createTest("My First Test");
    	try {
        driver.findElement(By.name("first_name")).sendKeys("sai krishna");
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).sendKeys("ellur");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("ellursai9@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.name("message")).sendKeys("helloboyd ");
        Thread.sleep(1000);
        submit();
        captureScreenshot("addresult");
        test.pass("Test passed");
        } catch (Exception e) {
        	 test.fail("Test failed");
        } 
    	
        
    }

    public void submit() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }
    @Test
    public void submitWithoutData() throws InterruptedException {
    	test = extent.createTest("My Second Test");
    	try {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        submit();
        String mess = driver.findElement(By.tagName("body")).getText();
        System.out.println(mess);
        captureScreenshot("submitted without data ");
        test.pass("Test passed");
    	}catch (Exception e) {
    		 test.fail("Test failed");
        } finally {
         
        }
       
    }

    
    public void captureScreenshot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            // Ensure the target directory exists
            File targetDir = new File("/home/zadmin/Desktop/screenshots/");
            if (!targetDir.exists()) {
                targetDir.mkdirs();
            }

            FileUtils.copyFile(source, new File(targetDir, testName + ".png"));
            System.out.println("Screenshot taken for test: " + testName);
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }

    @AfterSuite
    public void tearDown() {
    	
    	
    	 
    	
        if (driver != null) {
            driver.quit();
        }
        extent.flush();
       
       
    }
}
