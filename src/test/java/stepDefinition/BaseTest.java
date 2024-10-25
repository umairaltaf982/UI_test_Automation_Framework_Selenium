package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    protected static WebDriver driver;

    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Reset to ensure new session for new test runs
        }
    }
}
