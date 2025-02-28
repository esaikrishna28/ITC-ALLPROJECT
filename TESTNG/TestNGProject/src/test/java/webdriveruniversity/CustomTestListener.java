package webdriveruniversity;




import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomTestListener implements ITestListener {

    private StringBuilder reportContent = new StringBuilder();
    private static final String SCREENSHOT_FOLDER = "/home/zadmin/Desktop/TESTNG/TestNGProject/screenshot/";
    private static final String REPORT_FOLDER = "/home/zadmin/Desktop/TESTNG/TestNGProject/testreport/";


    private WebDriver driver;

    public CustomTestListener(WebDriver driver) {
        this.driver = driver;
        initializeReport();
    }

    private void initializeReport() {
        try {
            Files.createDirectories(Paths.get(SCREENSHOT_FOLDER));
            Files.createDirectories(Paths.get(REPORT_FOLDER));

            reportContent.append("<html><head><title>Test Report</title></head><body>");
            reportContent.append("<h1>Test Execution Report</h1>");
            reportContent.append("<h3>Test Executed on: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "</h3>");
            reportContent.append("<table border='1'><tr><th>Test Step</th><th>Status</th><th>Screenshot</th></tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String captureScreenshot(String screenshotName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotPath = SCREENSHOT_FOLDER + screenshotName + ".png";
            FileHandler.copy(screenshot, new File(screenshotPath));
            return screenshotPath;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String screenshotPath = captureScreenshot(result.getName());
        reportContent.append("<tr><td>").append(result.getName()).append("</td><td>Pass</td><td><img src='")
                     .append(screenshotPath).append("' width='200'></td></tr>");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = captureScreenshot(result.getName());
        reportContent.append("<tr><td>").append(result.getName()).append("</td><td>Fail</td><td><img src='")
                     .append(screenshotPath).append("' width='200'></td></tr>");
    }

    @Override
    public void onFinish(ITestContext context) {
        reportContent.append("</table></body></html>");
        String reportFileName = "TestReport_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".html";
        String reportFilePath = REPORT_FOLDER + reportFileName;

        try (FileWriter writer = new FileWriter(reportFilePath)) {
            writer.write(reportContent.toString());
            System.out.println("HTML Report generated at: " + reportFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
