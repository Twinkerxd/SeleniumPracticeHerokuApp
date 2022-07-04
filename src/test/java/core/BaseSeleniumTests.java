package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseSeleniumTests implements TestWatcher {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Alert alert;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // how long we will wait the page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4)); // how long we will wait the element
        BaseSeleniumPage.setDriver(driver);
    }

    @AfterEach
    public void tearDown() {
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        //driver.close(); // process in system
        driver.quit(); // browser
    }


    public static boolean isDisplayed(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isElementReady(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return true;
    }

    public static Alert waitForAlertReady() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public static void mouseOverElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        if (isElementReady(webElement)) {
            actions.moveToElement(webElement).perform();
        }
    }
}
