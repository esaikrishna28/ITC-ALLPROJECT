package webdriveruniversity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Set;
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
import org.openqa.selenium.NoSuchWindowException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Zebra5{
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
        wait = new WebDriverWait(dr, Duration.ofSeconds(60));
    }
    @Test
    public void inNav() throws InterruptedException {
        try {
            dr.findElement(By.xpath("//button[@aria-label='Close']")).click();
        } catch (Exception e) {
        }
        Thread.sleep(2000);
        dr.findElement(By.xpath("//span[text()='Industry']")).click();
        List<WebElement> il = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath("(//div[@class='navigation-item__scroll-section']/div)[position() <= 7]")));
        Thread.sleep(2000);
        for (WebElement i : il) {
            System.out.println(i.getText());
            Thread.sleep(1000);
        }
        try {
            WebElement elementToClick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Mobile Technology for Energy and Utilities']")));
            ((JavascriptExecutor)dr).executeScript("arguments[0].scrollIntoView(true);", elementToClick);
            elementToClick.click();
        } catch (ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Mobile Technology for Energy and Utilities']"))).click();
        }
        dr.findElement(By.xpath("//div[text()='Digital Safety Inspection and Compliance Reporting']")).click();
        Thread.sleep(2000);
        dr.findElement(By.xpath("//a[@href='#Hardware']")).click();
        String newWindowUrl = "https://www.zebra.com/ap/en/partners/partner-application-locator.html";
        dr.get(newWindowUrl);
        // Switch to the new window
        Set<String> allWindowHandles = dr.getWindowHandles();
        String mainWindowHandle = dr.getWindowHandle(); // Store the main window handle
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                dr.switchTo().window(handle); // Switch to the new window/tab
                break;
            }
        }
    Thread.sleep(2000);
    dr.findElement(By.xpath("//button[@class='rounded-lightblue' and text()='PARTNER APPS AND OFFERINGS']")).click();
    dr.findElement(By.xpath("//input[@placeholder='Search by name or keyword']")).sendKeys("abc");
    dr.findElement(By.xpath("//*[@id=\"partner_type\"]/div[2]/form[1]/div/div[2]/button/span")).click();
//    dr.findElement(By.xpath("//*[@id=\"partner_search_listing\"]/div[3]/div[2]/div[1]/zbr-search-list-item/div[1]/div[3]/div[2]/a/button")).click();
    Thread.sleep(2000);
    dr.findElement(By.xpath("//*[@id='partner_search_listing']/div[3]/div[2]/div[3]/zbr-search-list-item/div[1]/div[3]/div[2]/a/button")).click();
    Thread.sleep(1000);
    dr.findElement(By.xpath("//a[@href='/ap/en/partners/partner-application-locator/offering-search-results.html']")).click();
    Thread.sleep(2000);
    dr.findElement(By.xpath("//input[@placeholder='Search by name']")).sendKeys("wave");
    dr.findElement(By.xpath("//*[@id=\"partner_search_listing\"]/div[3]/div[1]/zbr-search-name/div[1]/form/div/div[2]/button")).click();
    Thread.sleep(2000);
    dr.findElement(By.xpath("//*[@id=\"partner_search_listing\"]/div[3]/div[2]/div[1]/zbr-search-list-item/div[1]/div[3]/div[2]/a/button")).click();
    Thread.sleep(1000);
    dr.findElement(By.xpath("//span[text()='Contact Partner']")).click();
    Thread.sleep(3000);
    dr.findElement(By.xpath("//input[@name='$FirstName']")).sendKeys("pooja");
    dr.findElement(By.xpath("//input[@name='$LastName']")).sendKeys("patil");
    dr.findElement(By.xpath("//input[@name='$Company']")).sendKeys("ITC");
    Thread.sleep(3000);
    dr.findElement(By.xpath("(//input[@name='$EmailAddress'])[2]")).sendKeys("pooja@example.com");
    Thread.sleep(1000);
    dr.findElement(By.xpath("//input[@placeholder='Please select all options that apply']")).click();
    dr.findElement(By.xpath("(//span[text()='Software'])[2]")).click();
    Thread.sleep(1000);
    WebElement d = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='$UserNeeds']")));
 ((JavascriptExecutor) dr).executeScript("arguments[0].click();", d);
 d.sendKeys("info");
dr.findElement(By.xpath("(//label[@class='gcdc-form-label'])[15]")).click();
WebElement b=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='gcdc-form-button'])[2]")));
//dr.findElement(By.xpath("//*[@id=\"gate-6587e526-037e-4f6f-ad97-5281ea5769bb_form_1738987441483\"]/div[18]/input")).click();
    b.click();
    Thread.sleep(2000);
   WebElement bu=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@role='button'])[3]")));
   bu.click();
   WebElement img=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='cmp-image__image'])[1]")));
   img.click();
    }
    @AfterClass
    void close() {
//        dr.quit();
    }
}