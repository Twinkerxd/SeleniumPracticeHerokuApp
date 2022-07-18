package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTests implements TestWatcher {
    protected static WebDriver driver;
    protected static String device = "desktop";

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // how long we will wait the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); // how long we will wait the element
        BasePage.setDriver(driver);
    }

    @BeforeEach
    public void setUp() {
        if (device.equals("desktop")) {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/");
        } else if (device.equals("mobile")) {
            driver.manage().window().setSize(new Dimension(360, 740));
            driver.get("https://www.selenium.dev/");
        }
    }

    @AfterEach
    public void tearDown() {
        saveScreenshot(device);
    }

    @AfterAll
    public static void end() {
        driver.quit(); // process in system
    }

    public void saveScreenshot(String name) {
        Allure.getLifecycle().addAttachment(name, "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
    }
}
