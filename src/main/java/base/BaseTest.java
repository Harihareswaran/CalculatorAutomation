package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    // AndroidDriver instance accessible by test classes
    protected AndroidDriver driver;  

    // This method runs before any test methods in this class
    @BeforeClass
    public void setup() throws Exception {

        // Define capabilities for Appium session
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // Android platform
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // Device name (any string works for real device)
        cap.setCapability(MobileCapabilityType.UDID, "5200c707dc88a697"); // Device UDID (unique ID of your phone)
        cap.setCapability("automationName", "UiAutomator2"); // Recommended automation engine for Android
        cap.setCapability("appPackage", "com.sec.android.app.popupcalculator"); // Package name of Samsung Calculator app
        cap.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator"); // Main activity to launch
        cap.setCapability("noReset", true); // Prevent app data reset between sessions

        // Initialize AndroidDriver with Appium server URL and capabilities
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), cap);

        // Implicit wait for elements to appear
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // This method runs after each test method
    @AfterMethod
    public void captureFailure(ITestResult result) throws IOException {

        // Capture screenshot only if the test failed
        if (ITestResult.FAILURE == result.getStatus()) {

            // Take screenshot
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            // Destination file path (inside "screenshots" folder with test method name)
            File dest = new File("screenshots/" + result.getName() + ".png");

            // Create directories if not exists
            dest.getParentFile().mkdirs();
            
            // Copy screenshot to destination (replace if exists)
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }

    // This method runs after all test methods in the class
    @AfterClass
    public void tearDown() {
        // Quit the driver session if it exists
        if (driver != null) {
            driver.quit();
        }
    }
}