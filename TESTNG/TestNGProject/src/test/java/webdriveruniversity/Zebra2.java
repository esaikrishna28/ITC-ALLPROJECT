package webdriveruniversity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class  Zebra2 {
    WebDriver dr;
    WebDriverWait wait;
    private void takeScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) dr;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = "/home/zadmin/eclipse-workspace/zebraTesting/Screenshots/" + screenshotName + ".png";
        File destFile = new File(destination);
        try {
            Files.copy(source.toPath(), destFile.toPath());
            System.out.println("Screenshot taken: " + screenshotName);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    @BeforeClass
    public void setUp() {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://www.zebra.com/ap/en.html");
        String pageTitle = dr.getTitle();
        System.out.println("Page Title: " + pageTitle);
        takeScreenshot("PageLoad");
        wait = new WebDriverWait(dr, Duration.ofSeconds(5));
    }
    @Test
    public void inNav() throws InterruptedException {
        dr.findElement(By.xpath("//button[@aria-label='Close']")).click();
        Thread.sleep(2000);
        takeScreenshot("HomePage");
        dr.findElement(By.xpath("//span[text()='Industry']")).click();
        List<WebElement> il = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("//div[@class='navigation-item__scroll-section']/div")));
        Thread.sleep(2000);
        for (WebElement i : il) {
            System.out.println(i.getText());
        }
        Thread.sleep(4000);
        try {
            WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Mobile Technology for Energy and Utilities']")));
            ((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
            elementToClick.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, retrying...");
            WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Mobile Technology for Energy and Utilities']")));
            ((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
            elementToClick.click();
        }
        Thread.sleep(2000);
        dr.findElement(By.xpath("//div[text()='Digital Safety Inspection and Compliance Reporting']")).click();
    }
    @AfterClass
    void close() {
//        dr.quit();
    }
}
