package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public ChromeOptions chromeOptions;
    public EdgeOptions edgeOptions;
    public Logger logger;

    public String browser;
    public String os;
    public String runMode;

    public Properties prop;

    // ========== SETUP ==========
    @BeforeClass(groups = {"Sanity", "Regression", "Master"})
    @Parameters({"browser", "os", "runMode"})
    public void setup(
            @Optional("chrome") String browser,
            @Optional("Linux") String os,
            @Optional("sequential") String runMode
    ) throws IOException {

        this.browser = browser;
        this.os = os;
        this.runMode = runMode;

        logger = LogManager.getLogger(this.getClass());

        // Log the parameters for clarity (and for Extent Report later)
        logger.info("Starting tests with Browser: " + browser + ", OS: " + os + ", Run Mode: " + runMode);

        // Loading property file
        FileInputStream file = new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(file);

        chromeOptions = new ChromeOptions();
        edgeOptions = new EdgeOptions();
        chromeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--incognito");

        if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
            DesiredCapabilities dp = new DesiredCapabilities();

            // Set platform
            if (os.equalsIgnoreCase("Windows")) {
                dp.setPlatform(Platform.WIN11);
            } else if (os.equalsIgnoreCase("Linux")) {
                dp.setPlatform(Platform.LINUX);
            } else if (os.equalsIgnoreCase("Mac")) {
                dp.setPlatform(Platform.MAC);
            } else {
                System.out.println("Invalid OS");
                return;
            }

            // Set browser name - note lowercase for switch cases since using .toLowerCase()
            switch (browser.toLowerCase()) {
                case "chrome":
                    dp.setBrowserName("chrome");
                    break;
                case "microsoftedge":
                case "edge":  // optionally handle 'edge' as input too
                    dp.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    dp.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("Invalid Browser");
                    return;
            }

            // Remote WebDriver URL should be configurable, consider moving to config.properties
            driver = new RemoteWebDriver(new URL("http://192.168.100.4:4444/wd/hub"), dp);
        } else if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                case "microsoftedge":
                    driver = new EdgeDriver(edgeOptions);
                    break;
                default:
                    System.out.println("Invalid Browser Name ...");
                    return;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("baseURL"));  // Reading URL from properties file
        driver.manage().window().maximize();

        // TODO: Add code to pass browser, os, runMode info to Extent Report here if you have an Extent manager/listener
    }

    // Attach driver to test result attributes before each test method
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method, ITestResult result) {
        result.setAttribute("driver", driver);
    }

    // ========== TEARDOWN ==========
    @AfterClass(groups = {"Sanity", "Regression", "Master"})
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // ========== RANDOM DATA HELPERS ==========
    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5); // e.g., "Abcde"
    }

    public String randomNumber() {
        return RandomStringUtils.randomNumeric(10); // e.g., "1234567890"
    }

    public String randomAlphaNumeric() {
        return RandomStringUtils.randomAlphanumeric(8); // e.g., "A1B2C3D4"
    }
}
