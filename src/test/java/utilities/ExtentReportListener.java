package utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentReportListener implements ITestListener {

    public static ExtentReports extentReports;
    public static ExtentTest test;
    public ExtentSparkReporter sparkReporter;

    // You will need a way to pass these values from your BaseClass to here.
    // For simplicity, store them in static vars or set via system properties.
    public static String browser = System.getProperty("browser", "Not Set");
    public static String os = System.getProperty("os", "Not Set");
    public static String runMode = System.getProperty("runMode", "Not Set");

    private static boolean systemInfoSet = false; // Flag to prevent duplication

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart - Test Suite started: " + context.getName());

        // Initialize ExtentReports only once
        if (extentReports == null) {
            String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
            new java.io.File("reports").mkdirs();
            String reportPath = "reports/SparkReport_" + timestamp + ".html";

            sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setReportName("Ecommerce Automation Report");
            sparkReporter.config().setDocumentTitle("Automation Test Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);
        }

        // ✅ Set system info only once per suite
        if (!systemInfoSet) {
            // Get parameters with fallbacks
            String os = context.getSuite().getParameter("os");
            String runMode = context.getSuite().getParameter("runMode");
            String user = System.getProperty("user.name");

            // Since browser is a test-level parameter, we fetch it from the current test (if available)
            String browser = context.getCurrentXmlTest() != null
                    ? context.getCurrentXmlTest().getParameter("browser")
                    : null;

            // Set system info with defaults if any are missing
            extentReports.setSystemInfo("Operating System", os != null ? os : System.getProperty("os.name", "Unknown OS"));
            extentReports.setSystemInfo("Environment", "QA");
            extentReports.setSystemInfo("User", user != null ? user : "Unknown User");
            extentReports.setSystemInfo("Browser", browser != null ? browser : "Not Set");
            extentReports.setSystemInfo("Run Mode", runMode != null ? runMode : "Not Set");

            systemInfoSet = true;
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();

        System.out.println("onTestStart - Starting Test: " + className + "." + methodName);
        test = extentReports.createTest(className + " : " + methodName);
        test.info("Test Started: " + methodName + " in class " + className);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();

        System.out.println("onTestSuccess - Passed Test: " + className + "." + methodName);
        test.pass("Test Passed: " + methodName + " in class " + className);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();

        System.out.println("onTestFailure - Failed Test: " + className + "." + methodName);
        test.fail("Test Failed: " + methodName + " in class " + className);
        test.fail(result.getThrowable());

        WebDriver driver = getDriverFromResult(result);
        if (driver != null) {
            try {
                String screenshotPath = ScreenshotUtil.captureScreenshot(driver, methodName);

                if (screenshotPath != null && new File(screenshotPath).exists()) {
                    test.fail("Screenshot of failure:",
                            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
                } else {
                    test.info("Screenshot path invalid or file does not exist.");
                }

            } catch (Exception e) {
                test.info("Could not attach screenshot: " + e.getMessage());
            }
        } else {
            test.info("WebDriver not available, screenshot not taken.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String className = result.getTestClass().getName();
        String methodName = result.getMethod().getMethodName();

        System.out.println("onTestSkipped - Skipped Test: " + className + "." + methodName);
        test.skip("Test Skipped: " + methodName + " in class " + className);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish - Test Suite finished: " + context.getName());
        extentReports.flush();

        String reportPath = sparkReporter.getFile().getAbsolutePath();

        if (new File(reportPath).exists()) {
            System.out.println("Report exists at: " + reportPath);
            EmailReportSender.sendReport("hafizgee07@gmail.com", reportPath);
            System.out.println("Report Sent to hafizgee07@gmail.com");
        } else {
            System.out.println("Report file does not exist at path: " + reportPath);
        }
    }

    public WebDriver getDriverFromResult(ITestResult result) {
        Object driverObj = result.getAttribute("driver");
        if (driverObj instanceof WebDriver) {
            return (WebDriver) driverObj;
        } else {
            System.out.println("WebDriver not found in ITestResult attributes.");
            return null;
        }
    }
}
