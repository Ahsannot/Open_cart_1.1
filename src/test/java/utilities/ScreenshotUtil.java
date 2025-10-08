package utilities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for capturing screenshots using Selenium WebDriver.
 */
public class ScreenshotUtil {

    // Static logger for this class
    public static Logger logger ;


    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        logger = LogManager.getLogger(ScreenshotUtil.class);
        try {
            // Cast driver to TakesScreenshot and capture image
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);

            // Define screenshot directory path
            String destDir = System.getProperty("user.dir") + "/screenshots/";

            // Create screenshots directory if it doesn't exist
            Files.createDirectories(Paths.get(destDir));

            // Generate unique file name with timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String dest = destDir + screenshotName + "_" + timestamp + ".png";

            File destination = new File(dest);

            // Copy the screenshot to the destination path
            Files.copy(source.toPath(), destination.toPath());

            // Log and print screenshot path
            System.out.println("Screenshot saved to: " + dest);
            logger.info("Screenshot successfully saved to: {}", dest);

            return dest;

        } catch (IOException e) {
            System.out.println("Error while saving screenshot: " + e.getMessage());
            logger.error("IOException during screenshot capture", e);
            return null;

        } catch (Exception e) {
            System.out.println("Unexpected error during screenshot capture: " + e.getMessage());
            logger.error("Unexpected error during screenshot capture", e);
            return null;
        }
    }
}
