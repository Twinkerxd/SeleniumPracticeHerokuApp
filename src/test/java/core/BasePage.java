package core;

import org.openqa.selenium.WebDriver;

public class BasePage extends BaseTests {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
