package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.BrowserDriverFactory;
import utils.Screenshots;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.BufferedReader;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeClass
    public void setup() {
        Properties properties = loadProperties();
        String browser = properties.getProperty("browser").toUpperCase();
        BrowserDriverFactory.BrowserType type = BrowserDriverFactory.BrowserType.valueOf(browser);
        BrowserDriverFactory browserFactory = new BrowserDriverFactory(type);

        // Create WebDriver instance
        driver = browserFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();

        // Create Wait instance
        wait = new WebDriverWait(driver, Duration.ofSeconds(50)); // Wait for up to 50 seconds
    }

    @AfterClass
    public void CloseBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    private Properties loadProperties() {
        String propertyFilePath = System.getProperty("config", "src/test/resources/config.properties");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath));
            Properties properties = new Properties();
            properties.load(reader);

            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void onTestFailure(ITestResult result) {
        Screenshots.captureScreenshot(driver, result.getMethod().getMethodName());
    }


}