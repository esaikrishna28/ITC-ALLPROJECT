package webdriveruniversity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MenuExtract {

    private WebDriver driver;
    private WebDriverWait wait;

    public MenuExtract() {
        // Initialize WebDriver and WebDriverWait
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Test
    public void listMenuItems() {
        try {
            driver.get("https://www.zebra.com/");
            driver.manage().window().maximize();

            // Accept cookies
            WebElement checkbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept Cookies']")));
            checkbtn.click();

            // Call the function for a specific top-level item
            String topLevelItem = "Software"; 
            getSecondLevelItems(topLevelItem);
            String topLevelItem1 = "Industry"; 
            getSecondLevelItems(topLevelItem1);
            String topLevelItem2 = "Hardware"; 
            getSecondLevelItems(topLevelItem2);
            
            
            
        } finally {
            driver.quit(); // Ensure the driver quits
        }
    }

    // Function to retrieve and print second-level items based on the top-level item
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
            }
        } catch (Exception e) {
            System.err.println("Error retrieving second-level items: " + e.getMessage());
        }

        if (secondLevelItems.isEmpty()) {
            System.out.println("No second-level items found for: " + topLevelText);
        }
    }
}
