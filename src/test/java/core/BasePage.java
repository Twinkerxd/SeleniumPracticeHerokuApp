package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Alert alert;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementReady(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return true;
    }

    public Alert waitForAlertReady() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public void mouseOverElement(WebElement webElement) {
        if (isElementReady(webElement)) {
            new Actions(driver).moveToElement(webElement).perform();
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void switchToNewWindow() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    public void switchToDefaultWindow() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
    }
}
