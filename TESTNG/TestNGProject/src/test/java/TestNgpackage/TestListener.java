package TestNgpackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;

    @Override
    public void onStart(ITestContext context) {
        // Initialize Extent Reports and HTML Reporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Extent Report Example");
        htmlReporter.config().setReportName("Test Execution Report");

        // Create ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in the Extent report
        test = extent.createTest(result.getMethod().getMethodName());

        // Get the WebDriver instance from the test context
        driver = (WebDriver) result.getTestContext().getAttribute("driver");
        System.out.println("WebDriver retrieved in TestListener: " + driver);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success
        test.log(Status.PASS, "Test Passed");
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
            System.out.println("Screenshot captured and attached to report: " + screenshotPath);
        }
    }
    

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable());

        // Capture screenshot and attach to the report
        String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
        if (screenshotPath != null) {
            test.addScreenCaptureFromPath(screenshotPath);
            System.out.println("Screenshot captured and attached to report: " + screenshotPath);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Finalize the report after all tests are finished
        extent.flush();
    }

    // Method to capture screenshot with timestamped filename
    private String captureScreenshot(String methodName) {
        try {
            // Get current timestamp for the screenshot filename
            String timestamp = new SimpleDateFormat("ddMMyyHHmmss").format(new Date());

            // Capture the screenshot as a file from the current WebDriver instance
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Ensure the screenshots directory exists
            Path screenshotDir = Paths.get("screenshots");
            if (!Files.exists(screenshotDir)) {
                Files.createDirectories(screenshotDir);  // Create directory if it doesn't exist
            }

            // Define the path where the screenshot will be saved with the timestamp
            String screenshotPath = "screenshots/" + methodName + "_" + timestamp + ".png";

            // Copy the screenshot to the target location
            File destFile = new File(screenshotPath);
            Files.copy(screenshotFile.toPath(), destFile.toPath());

            // Return the path of the screenshot
            return screenshotPath;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
