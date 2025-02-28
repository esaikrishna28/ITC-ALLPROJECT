package TestNgpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.ArrayList;
import java.util.List;

public class Saucedemo {

    WebDriver driver;
    List<String> urllist = new ArrayList<>();
    private ExtentReports extent;
    private ExtentTest test;
    
    @BeforeTest
    public void setup(ITestContext context) {
        // Initialize WebDriver and navigate to the site
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        
        // Set up ExtentReports
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Extent Report Example");
        htmlReporter.config().setReportName("Test Execution Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        System.out.println("WebDriver initialized and navigated to saucedemo.com");
    }

    @Test
    public void login() throws InterruptedException {
        test = extent.createTest("Login Test");
        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(1000);
            driver.findElement(By.id("login-button")).click();
            test.pass("Login test case passed");
        } catch (Exception e) {
            test.fail("Login test case failed");
        }
    }

    @Test
    public void selectproduct() {
        test = extent.createTest("Select Product Test");
        try {
            WebElement inventorylist = driver.findElement(By.className("inventory_list"));
            List<WebElement> elem = inventorylist.findElements(By.tagName("a"));
            
            for (WebElement webele : elem) {
                urllist.add(webele.getAttribute("id"));
            }
            
            System.out.println(urllist);
            test.pass("Select Product test case passed");
        } catch (Exception e) {
            test.fail("Select Product test case failed");
        }
    }

    @Test(dependsOnMethods = {"selectproduct"})
    public void completeaction() throws InterruptedException {
        test = extent.createTest("Complete Action Test");
        try {
            driver.findElement(By.id(urllist.get(0))).click();
            Thread.sleep(1000);
            driver.findElement(By.id("add-to-cart")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("sai krishna");
            driver.findElement(By.id("last-name")).sendKeys("ellur");
            driver.findElement(By.id("postal-code")).sendKeys("584101");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            driver.findElement(By.id("back-to-products")).click();
            test.pass("Complete Action test case passed");
        } catch (Exception e) {
            test.fail("Complete Action test case failed");
        }
    }

    @AfterSuite
    public void closedriver() {
        driver.quit();
        extent.flush();  // Flush the report after all tests are completed
    }
}
