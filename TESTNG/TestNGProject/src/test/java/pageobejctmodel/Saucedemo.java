package pageobejctmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;


@Listeners(TestListener.class)
public class Saucedemo {
    WebDriver driver;
    List<String> urllist = new ArrayList<>();

    @BeforeClass
    public void setup(ITestContext context) {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println("WebDriver initialized and navigated to saucedemo.com");
        context.setAttribute("driver", driver);
    }

    @Test(priority=1)
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(priority=2)
    public void selectproduct() {
        WebElement inventorylist = driver.findElement(By.className("inventory_list"));
        List<WebElement> elem = inventorylist.findElements(By.tagName("a"));
        
        for (WebElement webele : elem) {
            urllist.add(webele.getAttribute("id"));
        }
        
        System.out.println(urllist);
    }

    @Test(priority=3)
    public void completeaction() throws InterruptedException {
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
    }

    
    @AfterClass
    public void closedriver() {
        driver.quit();
    }
}
