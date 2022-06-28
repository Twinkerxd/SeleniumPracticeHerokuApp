package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
