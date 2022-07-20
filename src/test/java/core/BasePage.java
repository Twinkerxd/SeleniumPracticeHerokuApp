package core;

import io.qameta.allure.Step;
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
    private static final Duration DEFAULT_TIMEOUT_SECONDS = Duration.ofSeconds(4);

    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Alert alert;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver,DEFAULT_TIMEOUT_SECONDS);
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return true;
    }

    public Alert waitForAlertReady() {
        alert = wait.until(ExpectedConditions.alertIsPresent());
        return alert;
    }

    public void mouseOverElement(WebElement webElement) {
        if (isElementClickable(webElement)) {
            new Actions(driver).moveToElement(webElement).perform();
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 4275)");
    }

    @Step("Switching to the new window")
    public void switchToNewWindow() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
    }

    @Step("Switching to the default window")
    public void switchToDefaultWindow() {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
    }

    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
